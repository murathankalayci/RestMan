import controller.RestarauntController;
import model.Manager;
import model.Material;
import view.MainFrame;

public class Main {
    public static void main(String Args[]) {
        Manager manager = new Manager();
        manager.addMaterial("Carrot", 10);
        manager.addMaterial("Egg", 10);
        manager.addMaterial("Garlic", 10);

        manager.removeMaterial("Carrot", 5);

        manager.removeMaterial("Garlic", 10);

        manager.removeMaterial("Egg", 11);

        manager.addMaterial("Onion", 20);


        MainFrame view = new MainFrame(manager);
    }
}
