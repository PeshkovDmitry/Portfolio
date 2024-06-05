package Model.Entities;

import Model.Entities.Animal;

import java.util.Date;
import java.util.List;

public abstract class Pet extends Animal {

    public Pet(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

}
