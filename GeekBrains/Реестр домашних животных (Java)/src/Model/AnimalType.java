package Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AnimalType {
    CAT ("Кот"),
    DOG ("Собака"),
    HAMSTER("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private String title;

    AnimalType(String title) {
        this.title = title;
    }

    public static List<String> asList() {
        return Arrays.stream(AnimalType.values()).map(AnimalType::toString).collect(Collectors.toList());
    }

    public static AnimalType valueOf(Integer num) {
        return AnimalType.values()[num];
    }

    @Override
    public String toString() {
        return title;
    }

}
