package ua.com.javagame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Alexandr on 22.07.2017.
 */
public class RangeTest {

    private Model model;

    @Before
    public void initRange() {
        model = new Model();
    }

    @Test
    public void testCheckInRange() {
        Assert.assertFalse(model.outOfRange(1));
        Assert.assertFalse(model.outOfRange(20));
        Assert.assertFalse(model.outOfRange(99));
    }

    @Test
    public void testCheckOutOfRange() {
        Assert.assertTrue(model.outOfRange(-10));
        Assert.assertTrue(model.outOfRange(101));
    }
}