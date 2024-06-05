package Model.Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Camel extends PackAnimal {

    public Camel(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Верблюд " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camel)) return false;
        Camel camel = (Camel) o;
        return Objects.equals(getName(), camel.getName())
                && Objects.equals(getBirthday(), camel.getBirthday())
                && Objects.equals(getCommands(), camel.getCommands());
    }

}
