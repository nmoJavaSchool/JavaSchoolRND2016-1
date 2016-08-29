package Lesson14.HomeWork.FirstTask;

import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by user on 29.08.16.
 */
public class TestProxyMain {
    @Test
    public void TestProxyMaking(){
        MyCachedProxy proxy = new MyCachedProxy();

        MyRandom myRandom = new MyRandom();

        IMyRandom random =  proxy.create(IMyRandom.class, myRandom);

        Random r = new Random();
        r.setSeed(100);
        assertEquals(r.nextInt(), random.getRandom(100));
        r.setSeed(400);
        assertEquals(r.nextInt(), random.getRandom(400));
        r.setSeed(400);
        assertEquals(r.nextInt(), random.getRandom(400));
        r.setSeed(500);
        assertEquals(r.nextInt(), random.getRandom(500));
        assertEquals(3, myRandom.getCallCounter());
    }

}
