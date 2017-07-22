package ua.com.javagame;

/**
 * Created by Alexandr on 19.07.2017.
 */
public class View {
    public final static String WELCOME_OUTPUT = "Welcome to Java game of guessing number in specified range!";
    public final static String INPUT_ERROR = "Incorrect number! Repeat input please!";
    public final static String GUESS_IT_OUTPUT = "You can try to guess a number with the smallest amount of attempts!";
    public final static String RANGE = "There is range in which is situated secret number: ";
    public final static String POSSIBLE_INPUT = "Input a number that will be winning in this game: ";
    public final static String LOWER_NUMBER = "Incorrect number! The guessed number is lower than you entered! Guess again!";
    public final static String BIGGER_NUMBER = "Incorrect number! The guessed number is bigger than you entered! Guess again!";
    public final static String OUT_OF_RANGE = "You have out of your entered range! Repeat input please!";
    public final static String LIST_OF_ATTEMPTS = "List of attempts: ";
    public final static String AMOUNT_ATTEMPTS = "Amount of attempts: ";
    public final static String CONGRATULATIONS = "Congratulations! You entered guessed number! It was ";
    public final static String BYE_OUTPUT = "Good bye! We will be glad to see you in the next game!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndData(String ... messages) {
        String result = "";
        for (String value : messages) {
            result = result.concat(value);
        }
        System.out.println(result);
    }

    public void printRange(Model model) {
        printMessageAndData(RANGE, "(", Integer.toString(model.getMin()), ", ", Integer.toString(model.getMax()), ")");
    }

    public void printAttempts(Model model) {
        printMessageAndData(AMOUNT_ATTEMPTS, Integer.toString(model.amountOfAttempts()));
        if (model.amountOfAttempts() != 0) {
            printMessageAndData(LIST_OF_ATTEMPTS, model.getAttempts());
        }
    }

    public void congratulations(Model model) {
        printMessageAndData(CONGRATULATIONS, Integer.toString(model.getSecretNumber()) + "!");
        printAttempts(model);
    }
}