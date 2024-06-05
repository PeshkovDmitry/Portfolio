package Model;

import Exceptions.*;

public interface Model {

    void createNewToy(String text) throws WrongWeightException, WrongFieldsNumberException, WrongIdException;

    void changeWeight(String text) throws WrongFieldsNumberException, WrongIdException, WrongWeightException;

    void startLottery(Integer count) throws WrongPrizesCountException;

    void givePrizes(Integer count) throws WrongPrizesCountException, PrizeGiverException;
}
