package Lesson6.HomeWork;

import java.util.Random;

/**
 * Created by user on 01.08.16.
 */
public class MyRandom implements IMyRandom {

    @Override
    public int getRandom(long rand){
        Random random = new Random();
        random.setSeed(rand);
        return random.nextInt();
    }

}
