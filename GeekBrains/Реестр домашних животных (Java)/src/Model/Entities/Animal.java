package Model.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Animal {

    String name;

    Date birthday;

    List<String> commands;

    public Animal(String name, Date birthday, List<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getCSV() {
        return getName() + ";"
                + this.getClass().getSimpleName().toLowerCase() + ";"
                + new SimpleDateFormat("yyyy-MM-dd").format(birthday) + ";"
                + String.join(",",commands) + ";";
    }

    @Override
    public String toString() {
        return name
                + ", дата рождения " + new SimpleDateFormat("yyyy-MM-dd").format(birthday)
                + ", знает команды " + commands;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday(), getCommands());
    }

}
