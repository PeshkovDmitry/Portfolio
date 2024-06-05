package View;

import Model.Entities.Animal;

import java.util.List;
import java.util.Scanner;

public class RegistryView implements View {

    private Scanner scanner;

    public RegistryView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void show(List<String> list, String message) {
        System.out.println(message);
        if (list != null) {
            Integer count = 0;
            for (String s:list) {
                if (list.size() > 1) {
                    System.out.print(count++ + ") ");
                }
                System.out.println(s);
            }
        }
    }

    @Override
    public String get(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
