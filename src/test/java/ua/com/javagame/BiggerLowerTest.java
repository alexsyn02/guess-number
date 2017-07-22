package ua.com.javagame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Alexandr on 22.07.2017.
 */
public class BiggerLowerTest {

    private Model model;

    @Before
    public void initModel() {
        model = new Model(55, 65);
    }

    @Test
    public void testBigger() {
        Assert.assertTrue(model.secretIsBigger(20));
        Assert.assertTrue(model.secretIsBigger(30));
        Assert.assertTrue(model.secretIsBigger(40));
        Assert.assertTrue(model.secretIsBigger(50));
    }

    @Test
    public void testLower() {
        Assert.assertFalse(model.secretIsBigger(70));
        Assert.assertFalse(model.secretIsBigger(80));
        Assert.assertFalse(model.secretIsBigger(90));
    }
}