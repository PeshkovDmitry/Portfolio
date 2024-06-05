package Model;

import Exceptions.WrongFieldsNumberException;
import Exceptions.WrongIdException;
import Exceptions.WrongWeightException;

public class PrizeToy implements Toy, Comparable {

    private Integer id;

    private String title;

    private Integer weight;

    public PrizeToy(String text) throws WrongFieldsNumberException, WrongIdException, WrongWeightException {
        String[] data = text.split(" ");
        if (data.length != 3)
            throw new WrongFieldsNumberException(
                    "Неправильное количество переданных аргументов, должно быть три",
                    text,
                    data.length
            );
        try {
            id = Integer.parseInt(data[0]);
        } catch (NumberFormatException e) {
            throw new WrongIdException(
                    "Неверный формат ID, должно быть целое число",
                    data[0]
            );
        }
        title = data[1];
        try {
            weight = Integer.parseInt(data[2]);
            if (weight <= 0)
                throw new WrongWeightException(
                    "Вес должен быть положительным",
                    data[2]
            );
        } catch (NumberFormatException e) {
            throw new WrongWeightException(
                    "Неверный формат веса, должно быть целое число",
                    data[2]
            );
        }
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return ((PrizeToy) o).getId() - this.getId();
    }

    @Override
    public String toString() {
        return "№" + id + " " + title;
    }
}
