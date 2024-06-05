import Model.Model;
import Model.ToyLotteryModel;
import Presenter.Presenter;
import Presenter.ToyLotteryPresenter;
import View.View;
import View.ToyLotteryView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model model = new ToyLotteryModel();
        View view = new ToyLotteryView(new Scanner(System.in));
        Presenter presenter = new ToyLotteryPresenter(model, view);
        presenter.onButtonClicked();
    }
}