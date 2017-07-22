package ua.com.javagame;

/**
 * Created by Alexandr on 22.07.2017.
 */
public class WrongRangeException extends RuntimeException {

    private static final String errorMessage = "Out of the range or incorrect minimum and maximum for the random function";
    private static final long errorNumber = 1L;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void showErrorMessage() {
        System.out.println(errorMessage);
    }

}