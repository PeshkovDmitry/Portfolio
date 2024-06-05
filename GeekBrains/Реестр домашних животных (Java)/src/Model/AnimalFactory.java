package Model;

import Model.Entities.*;

import java.util.Date;
import java.util.List;

public class AnimalFactory {

    public static Animal get(AnimalType type, String name, Date birthday, List<String> commands) {
        Animal animal = null;
        switch (type) {
            case CAT:
                animal = new Cat(name, birthday, commands);
                break;
            case DOG:
                animal = new Dog(name, birthday, commands);
                break;
            case HAMSTER:
                animal = new Hamster(name, birthday, commands);
                break;
            case HORSE:
                animal = new Horse(name, birthday, commands);
                break;
            case CAMEL:
                animal = new Camel(name, birthday, commands);
                break;
            case DONKEY:
                animal = new Donkey(name, birthday, commands);
                break;
        }
        return animal;
    }
}
