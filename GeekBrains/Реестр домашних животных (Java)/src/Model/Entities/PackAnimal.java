package Model.Entities;

import Model.Entities.Animal;

import java.util.Date;
import java.util.List;

public abstract class PackAnimal extends Animal {

    public PackAnimal(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

}
