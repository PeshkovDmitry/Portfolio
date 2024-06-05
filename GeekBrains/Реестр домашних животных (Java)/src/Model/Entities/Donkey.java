package Model.Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Donkey extends PackAnimal {

    public Donkey(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Осёл " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donkey)) return false;
        Donkey donkey = (Donkey) o;
        return Objects.equals(getName(), donkey.getName())
                && Objects.equals(getBirthday(), donkey.getBirthday())
                && Objects.equals(getCommands(), donkey.getCommands());
    }

}
