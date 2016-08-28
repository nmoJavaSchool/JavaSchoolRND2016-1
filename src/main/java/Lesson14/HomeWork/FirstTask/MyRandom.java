package Lesson14.HomeWork.FirstTask;

import java.util.Random;

/**
 * Created by user on 28.08.16.
 */
public class MyRandom implements IMyRandom<Integer> {
    private int callCounter = 0;

    @Override
    public Integer getRandom(long seed) {
        ++callCounter;
        Random random = new Random();
        random.setSeed(seed);
        return random.nextInt();
    }

    public int getCallCounter() {
        return callCounter;
    }
}
