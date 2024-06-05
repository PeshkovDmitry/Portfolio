package Model;

import Exceptions.BirthdayParseException;
import Exceptions.DatabaseException;
import Model.Entities.Animal;

import java.util.List;

public interface Model {

    public void add(Animal animal) throws DatabaseException, BirthdayParseException;

    public List<Animal> getAll() throws DatabaseException, BirthdayParseException;

    public Animal getByName(String name) throws DatabaseException, BirthdayParseException;

    public void addCommand(String command, Animal animal) throws BirthdayParseException, DatabaseException;

}
