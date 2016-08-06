package Lesson6.HomeWork;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 31.07.16.
 */
public class CheckClass {
    public static void main(String[] args) {

        Class<?> childClass = Child.class;
        Class<?> superClass = Child.class.getSuperclass();

        System.out.println("*** Methods of the classes ***");
        System.out.println("Parent:");
        for (Method method: superClass.getDeclaredMethods())
            System.out.println("\t" + getModifier(method.getModifiers()) + "  " + method.getName());
        System.out.println("Child:");
        for (Method method: childClass.getDeclaredMethods())
            System.out.println("\t" + getModifier(method.getModifiers()) + "  " + method.getName());

        System.out.println("------------------------------------------------------");

        System.out.println("*** Getters and Setters of the classes ***");
        System.out.println("Parent:");
        printGettersSetters(superClass);
        System.out.println("Child:");
        printGettersSetters(childClass);

        System.out.println("------------------------------------------------------");

        System.out.println("*** Fields of the classes ***");
        System.out.println("Parent:");
        for (Field field: superClass.getDeclaredFields())
            System.out.println("\t" + getModifier(field.getModifiers()) + "  " + field.getName());
        System.out.println("Child:");
        for (Field field: childClass.getDeclaredFields())
            System.out.println("\t" + getModifier(field.getModifiers()) + "  " + field.getName());

        System.out.println("------------------------------------------------------");

        System.out.println("*** Const fields of the classes ***");
        System.out.println("Parent:");

        for (Field field: superClass.getFields()) {
            System.out.println("\t" + getModifier(field.getModifiers()) + "  " + field.getName());
            if(field.toString().contains("final") && field.toString().contains("String")) {
                System.out.print("\t" + getModifier(field.getModifiers()) + "  " + field.getName());
                System.out.println(" = \"" + getValueOfField(field,superClass) + "\"");
            }
        }

        System.out.println("Child:");
        for (Field field: childClass.getFields()) {
            if(field.toString().contains("final") && field.toString().contains("String")) {
                System.out.print("\t" + getModifier(field.getModifiers()) + "  " + field.getName());
                System.out.println(" = \"" + getValueOfField(field,childClass) + "\"");
            }
        }
    }
    private static String getValueOfField(Field field,  Class<?> anyClass){
        try {
            field.setAccessible(true);
            String fieldValue = (String) field.get(anyClass);
            return fieldValue;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String getModifier(int m) {
        String modifier = "";
        if (Modifier.isPublic(m)) modifier += "public ";
        if (Modifier.isProtected(m)) modifier += "protected ";
        if (Modifier.isPrivate(m)) modifier += "private ";
        return modifier;
    }
    private static void printGettersSetters(Class<?> aClass){
        Method[] methods = aClass.getDeclaredMethods();

        for(Method method : methods){
            if(isGetter(method)) System.out.println("\t"
                    + getModifier(method.getModifiers()) + "  " + method.getName());
            if(isSetter(method)) System.out.println("\t"
                    + getModifier(method.getModifiers()) + "  " + method.getName());
        }
    }

    private static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    private static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }
}
