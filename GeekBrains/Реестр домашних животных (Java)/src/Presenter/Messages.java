package Presenter;

public interface Messages {

    public static String MAIN_MENU
            = "********************\n\r"
            + "* Реестр животных: *\n\r"
            + "********************\n\r"
            + "1) Показать список всех животных\t"
            + "2) Добавить животное в реестр\t"
            + "3) Вывести список команд  животного\n\r"
            + "4) Обучить животное новой команде\t"
            + "5) Выход";

    public static String SELECT = "->";

    public static String SHOW_ALL = "В реестре записаны следующие животные:";

    public static String NEW_ANIMAL = "Запись нового животного в реестр";

    public static String GET_NAME = "Введите имя -> ";

    public static String GET_BIRTHDAY = "Введите дату рождения (ГГГГ-ММ-ДД) -> ";

    public static String GET_COMMAND = "Введите команду -> ";

    public static String GET_COMMAND_LIST = "Введите команды -> ";

    public static String GET_TYPE = "Укажите вид животного:";

    public static String ANIMAL_ADDED = "Добавлено животное:";

    public static String ANIMAL_FINDED = "Найдено животное:";

    public static String ANIMAL_NOT_FINDED = "Животное не найдено";


 }
