package View;

import Model.Entities.Animal;

import java.util.List;

public interface View {

    public void show(List<String> list, String message);

    public String get(String message);

    public void close();

}
