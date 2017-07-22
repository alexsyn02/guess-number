package ua.com.javagame;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alexandr on 19.07.2017.
 */

public class Controller {

    Model model;
    View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        view.printMessage(view.WELCOME_OUTPUT);

        view.printMessage(view.GUESS_IT_OUTPUT);
        guessIt(sc);

        view.printMessage(view.BYE_OUTPUT);
    }

    public void guessIt(Scanner sc) {

        int possibleNumber = 0;

        model.setMin(model.MIN_RANGE);
        model.setMax(model.MAX_RANGE);

        while ( true ) {
            view.printRange(model);
            view.printAttempts(model);
            view.printMessage(view.POSSIBLE_INPUT);

            if (sc.hasNextInt()) {
                possibleNumber = sc.nextInt();

                if (model.isSecretNumber(possibleNumber)) {
                    view.congratulations(model);
                    break;
                } else if (model.outOfRange(possibleNumber)) {
                    view.printMessage(view.OUT_OF_RANGE);
                } else if (model.secretIsBigger(possibleNumber)) {
                    view.printMessage(view.BIGGER_NUMBER);
                } else {
                    view.printMessage(view.LOWER_NUMBER);
                }
            } else {
                view.printMessage(view.INPUT_ERROR);
                sc.next();
            }
        }
    }
}