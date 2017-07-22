package ua.com.javagame;

/**
 * Created by Alexandr on 19.07.2017.
 */
public class Main {

    public static void main(String args[]) {

        try {
            Model model = new Model();
            View view = new View();
            Controller controller = new Controller(model, view);
            controller.startGame();
        } catch(WrongRangeException ex) {
            ex.showErrorMessage();
        }
    }
}