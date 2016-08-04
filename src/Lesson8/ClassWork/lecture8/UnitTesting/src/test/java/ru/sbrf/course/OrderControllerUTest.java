package ru.sbrf.course;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Student on 04.08.2016.
 */
public class OrderControllerUTest {
    private OrderController controller;
    @Before
    public void init(){
        controller = new OrderController(new DicounteRegistryImpl());
    }

    @Test(expected = NullPointerException.class)
    public void npeItems(){
        controller.getItemDiscountForClient(null,null);
    }

    @Test
    public void npeItem2(){

        String g = new String("");
        Assert.assertNull(g);
    }

}
