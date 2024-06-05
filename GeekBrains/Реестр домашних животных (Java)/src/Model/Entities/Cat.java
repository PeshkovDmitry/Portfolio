package Model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cat extends Pet {

    public Cat(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Кот " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(getName(), cat.getName())
                && Objects.equals(getBirthday(), cat.getBirthday())
                && Objects.equals(getCommands(), cat.getCommands());
    }

}
