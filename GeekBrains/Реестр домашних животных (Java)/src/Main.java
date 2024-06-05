import Model.*;
import Presenter.*;
import View.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Model model = new RegistryModel();
        View view = new RegistryView(new Scanner(System.in));
        Presenter presenter = new RegistryPresenter(model, view);
        presenter.onButtonClicked();
    }

}