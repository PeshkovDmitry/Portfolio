package Model.Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Horse extends PackAnimal {

    public Horse(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Лошадь " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;
        Horse horse = (Horse) o;
        return Objects.equals(getName(), horse.getName())
                && Objects.equals(getBirthday(), horse.getBirthday())
                && Objects.equals(getCommands(), horse.getCommands());
    }

}
