package Model.Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Hamster extends Pet {

    public Hamster(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Хомяк " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hamster)) return false;
        Hamster hamster = (Hamster) o;
        return Objects.equals(getName(), hamster.getName())
                && Objects.equals(getBirthday(), hamster.getBirthday())
                && Objects.equals(getCommands(), hamster.getCommands());
    }

}
