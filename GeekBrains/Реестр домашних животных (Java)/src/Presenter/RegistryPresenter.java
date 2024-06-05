package Presenter;

import Exceptions.*;
import Model.Entities.Animal;
import Model.Model;
import View.View;
import Model.AnimalFactory;
import Model.AnimalType;
import Model.Parsers.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RegistryPresenter implements Presenter {

    private Model model;

    private View view;

    public RegistryPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onButtonClicked() {
        while (true) {
            view.show(null, Messages.MAIN_MENU);
            String answer = view.get(Messages.SELECT);
            switch (answer.trim()) {
                case "1":
                    try {
                        view.show(
                                model.getAll().stream().map(Animal::toString).collect(Collectors.toList()),
                                Messages.SHOW_ALL);
                    } catch (DatabaseException | BirthdayParseException e) {
                        view.show(null, e.getMessage() + " " + e.getText());
                    }
                    break;
                case "2":
                    try {
                        view.show(null, Messages.NEW_ANIMAL);
                        view.show(AnimalType.asList(), Messages.GET_TYPE);
                        AnimalType type = AnimalTypeParser.parse(view.get(Messages.SELECT));
                        String name = view.get(Messages.GET_NAME);
                        if (name.isBlank()) {
                            throw new AnimalNameException("Введено пустое имя","");
                        }
                        Date bithday = BirthdayParser.parse(view.get(Messages.GET_BIRTHDAY));
                        List<String> commands = Arrays.asList(view.get(Messages.GET_COMMAND_LIST).split("\\,"));
                        Animal animal = AnimalFactory.get(type, name, bithday, commands);
                        model.add(animal);
                        view.show(List.of(animal.toString()), Messages.ANIMAL_ADDED);
                    } catch (DatabaseException | BirthdayParseException | AnimalNameException | AnimalTypeParseException e) {
                        view.show(null, e.getMessage() + " " + e.getText());
                    }
                    break;
                case "3":
                    try {
                        String name = view.get(Messages.GET_NAME);
                        Animal animal = model.getByName(name);
                        if (animal == null) {
                            view.show(null, Messages.ANIMAL_NOT_FINDED);
                        } else {
                            view.show(List.of(animal.toString()), Messages.ANIMAL_FINDED);
                        }
                    } catch (DatabaseException | BirthdayParseException e) {
                        view.show(null, e.getMessage() + " " + e.getText());
                    };

                    break;
                case "4":
                    try {
                        String name = view.get(Messages.GET_NAME);
                        Animal animal = model.getByName(name);
                        if (animal == null) {
                            throw new AnimalNameException("Животного с указанным именем не существует","");
                        }
                        List<String> commands = Arrays.asList(view.get(Messages.GET_COMMAND).split("\\,"));
                        if (commands.size() > 1) {
                            throw new CommandsSizeException("Указывайте команды по одной", "");
                        }
                        if (commands.isEmpty() || commands.get(0).isBlank()) {
                            throw new CommandsSizeException("Ввод пустых команд не допустим", "");
                        }
                        model.addCommand(commands.get(0), animal);
                    } catch (DatabaseException | BirthdayParseException | CommandsSizeException | AnimalNameException e) {
                        view.show(null, e.getMessage() + " " + e.getText());
                    }
                    break;
                case "5":
                    view.close();
                    return;
            }
        }
    }
}
