package Model.Repositories;

import Exceptions.BirthdayParseException;
import Exceptions.DatabaseException;
import Model.Entities.Animal;

import java.util.List;

public interface Repository {

    void create(Animal animal) throws DatabaseException;

    List<Animal> readAll() throws DatabaseException, BirthdayParseException;

    Animal readByName(String name) throws DatabaseException, BirthdayParseException;

    void update(Animal animal) throws DatabaseException, BirthdayParseException;

    void delete(Animal animal) throws DatabaseException, BirthdayParseException;

}
