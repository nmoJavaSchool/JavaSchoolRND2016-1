package Lesson6.HomeWork;

import java.lang.reflect.Proxy;

/**
 * Created by user on 01.08.16.
 */
public class ProxyExecute {
    public static void main(String[] args) {

        MyRandom random = new MyRandom();

        IMyRandom iMyRandom = (IMyRandom) Proxy.newProxyInstance(MyRandom.class.getClassLoader(),
                MyRandom.class.getInterfaces(),
                new MyInvocationHandler(random));

        int number =  iMyRandom.getRandom(100);
        System.out.println("First number = " + number);
        number =  iMyRandom.getRandom(190);
        System.out.println("Second number = " + number);
        number =  iMyRandom.getRandom(100);
        System.out.println("Third number = " + number);

    }
}
