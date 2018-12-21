import model.JSONParser;
import model.Kitchen;
import model.Manager;
import view.MainFrame;

public class Main {
    public static void main(String Args[]) {
        Manager manager = new Manager();
        Kitchen kitchen = new Kitchen();
        MainFrame view = new MainFrame(manager, kitchen);
        view.init();
    }
}
