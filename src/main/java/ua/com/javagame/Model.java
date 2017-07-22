package ua.com.javagame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alexandr on 19.07.2017.
 */

public class Model {
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 100;
    private static final int MIN_DIFFERENCE = 2;
    private int secretNumber;
    private int min;
    private int max;
    private ArrayList<Integer> attempts;

    Model() {
        secretNumber = rand();
        attempts = new ArrayList<>();
    }

    Model(int min, int max) {
        secretNumber = rand(min, max);
        attempts = new ArrayList<>();
    }

    // Random guessing number without arguments
    public int rand() {
        Random random = new Random();
        setMin(MIN_RANGE);
        setMax(MAX_RANGE);
        return random.nextInt(MAX_RANGE - 1) + 1;
    }

    // Random guessing number with two arguments
    public int rand(int min, int max) {
        if (min > MIN_RANGE && max < MAX_RANGE && max - min >= MIN_DIFFERENCE) {
            setMin(min);
            setMax(max);
            return (int) (Math.random() * max - min + 1) + min;
        } else {
            throw new WrongRangeException();
        }
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public boolean isSecretNumber(int number) {
        return number == getSecretNumber();
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void addToAttempts(int number) {
        attempts.add(number);
    }

    public int amountOfAttempts() {
        return attempts.size();
    }

    public String getAttempts() {

        String result = "";

        for (int value : attempts) {
            result = result.concat(Integer.toString(value).concat(" "));
        }
        return result;
    }

    public boolean outOfRange(int possibleNumber) {
        if (possibleNumber >= getMax() || possibleNumber <= getMin()) {
            return true;
        }
        return false;
    }

    public boolean secretIsBigger(int possibleNumber) {
        if (possibleNumber < getSecretNumber()) {
            setMin(possibleNumber);
            addToAttempts(possibleNumber);
            return true;
        } else {
            setMax(possibleNumber);
            addToAttempts(possibleNumber);
            return false;
        }
    }
}