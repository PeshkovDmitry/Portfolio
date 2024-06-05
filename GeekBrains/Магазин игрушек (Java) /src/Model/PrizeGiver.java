package Model;

import Exceptions.PrizeGiverException;

import java.io.FileWriter;
import java.io.IOException;

public class PrizeGiver {
    private static PrizeGiver prizeGiver;

    private FileWriter fileWriter;

    public static PrizeGiver getInstance() {
        if (prizeGiver == null) {
            prizeGiver = new PrizeGiver();
        }
        return prizeGiver;
    }

    public void give(Toy toy) throws PrizeGiverException {
        try (FileWriter fileWriter = new FileWriter("prizes.txt", true)) {
            if (toy != null)
                fileWriter.write(toy.toString() + "\n");
        } catch (IOException e) {
            throw new PrizeGiverException(
                    "Не могу сохранить параметры игрушки в файл",
                    toy.toString()
            );
        }
    }
}
