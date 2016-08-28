package Lesson14.HomeWork.FirstTask;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by user on 28.08.16.
 */
public class ProxyMain {
    public static void main(String[] args) throws NoSuchMethodException {
        MyCachedProxy proxy = new MyCachedProxy();

        MyRandom myRandom = new MyRandom();

        IMyRandom random =  proxy.create(IMyRandom.class, myRandom);

        ExecutorService executor =  Executors.newCachedThreadPool();


        for (int i = 0; i < 1000; i++) {
            long seed = new Random().nextInt(1000);
            executor.execute(new ThreadRandom(String.valueOf(i), random, seed));
        }
        executor.shutdown();



        if(executor.isShutdown())
            System.out.println("there are "+myRandom.getCallCounter()+" calls for 1000 threads");
    }

}

class ThreadRandom extends Thread{
    private IMyRandom data;
    private long seed;

    public ThreadRandom(String name, IMyRandom data, long seed) {
        super(name);
        this.data = data;
        this.seed = seed;

    }

    @Override
    public void run() {
        data.getRandom(seed);
    }
}
