package Model;

import Exceptions.BirthdayParseException;
import Exceptions.DatabaseException;
import Model.Entities.Animal;
import Model.Repositories.FileRepository;
import Model.Repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class RegistryModel implements Model {

    private Repository repo = new FileRepository();

    @Override
    public void add(Animal animal) throws DatabaseException, BirthdayParseException {
        if (repo.readByName(animal.getName()) == null) {
            repo.create(animal);
        } else {
            repo.update(animal);
        }
    }

    @Override
    public List<Animal> getAll() throws DatabaseException, BirthdayParseException {
        return repo.readAll();
    }

    @Override
    public Animal getByName(String name) throws DatabaseException, BirthdayParseException {
        return repo.readByName(name);
    }

    @Override
    public void addCommand(String command, Animal animal) throws BirthdayParseException, DatabaseException {
        List<String> commands = new ArrayList<>(animal.getCommands());
//        List<String> commands = animal.getCommands();
        commands.add(command);
        animal.setCommands(commands);
        repo.update(animal);
    }
}
