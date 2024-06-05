package Model.Repositories;

import Exceptions.BirthdayParseException;
import Exceptions.DatabaseException;
import Model.AnimalFactory;
import Model.Entities.Animal;
import Model.AnimalType;
import Model.Parsers.BirthdayParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRepository implements Repository{

    @Override
    public void create(Animal animal) throws DatabaseException {
        try (FileWriter fileWriter = new FileWriter("Animals.csv", true)) {
            fileWriter.write("\r\n" + animal.getCSV());
            fileWriter.flush();
        } catch (IOException e) {
            throw new DatabaseException("Невозможно записать в файл данных", "Animals.csv");
        }
    }

    @Override
    public List<Animal> readAll() throws DatabaseException, BirthdayParseException {
        List<Animal> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Animals.csv"));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] data = str.split(";");
                if (data.length == 4) {
                    list.add(AnimalFactory.get(
                            AnimalType.valueOf(data[1].toUpperCase()),
                            data[0],
                            BirthdayParser.parse(data[2]),
                            Arrays.asList(data[3].split(","))
                    ));
                }
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            throw new DatabaseException("Невозможно прочитать файл данных", "Animals.csv");
        }
        return list;
    }

    @Override
    public Animal readByName(String name) throws DatabaseException, BirthdayParseException {
        for (Animal animal: readAll()) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public void update(Animal animal) throws DatabaseException, BirthdayParseException {
        List<Animal> list = readAll();
        try (FileWriter fileWriter = new FileWriter("Animals.csv")) {
            for (Animal a: list) {
                if (a.getName().equals(animal.getName())) {
                    fileWriter.write("\r\n" + animal.getCSV());
                } else {
                    fileWriter.write("\r\n" + a.getCSV());
                }
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new DatabaseException("Невозможно записать в файл данных", "Animals.csv");
        }
    }

    @Override
    public void delete(Animal animal) throws DatabaseException, BirthdayParseException {
        List<Animal> list = readAll();
        try (FileWriter fileWriter = new FileWriter("Animals.csv")) {
            for (Animal a: list) {
                if (!a.equals(animal)) {
                    fileWriter.write("\r\n" + animal.getCSV());
                }
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new DatabaseException("Невозможно записать в файл данных", "Animals.csv");
        }
    }
}
