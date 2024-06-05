package Model.Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Dog extends Pet {

    public Dog(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Собака " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getName(), dog.getName())
                && Objects.equals(getBirthday(), dog.getBirthday())
                && Objects.equals(getCommands(), dog.getCommands());
    }

}
