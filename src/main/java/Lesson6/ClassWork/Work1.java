package Lesson6.ClassWork;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

 class A {
    public final int a =1;
    private int a1 =1;
    public  void AAA(){

    };
    public static void pA(String str){
        System.out.println(str);
    }
}
class B extends A{
    public final int b =1;

    public static void BBB() {

    }
    private static void BBBp() {
        System.out.println("private BBB");
    }
}
public class Work1 {
    public static void main(String[] args) {
//        System.out.println(B.class.getMethods());
        Arrays.asList(B.class.getDeclaredMethods())
                .forEach(System.out::println);

        try {
            System.out.println(A.class.getMethod("pA", String.class).getName());
            System.out.println(A.class.getField("a").getName());
            System.out.println(Object.class.getSuperclass());
            Method m = B.class.getDeclaredMethod("BBB", null);
            m.setAccessible(true);
            m.invoke("BBB");


            Field name = A.class.getField("a");
            name.setAccessible(true);
            A a = new A();
            name.set(a.a, 2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
