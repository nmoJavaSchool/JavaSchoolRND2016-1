package Lesson7.HomeWork.ru.sbt.mipt.pluginRootDirectory.pluginName;

import Lesson7.HomeWork.ru.sbt.mipt.Plugin;

/**
 * Created by user on 03.08.16.
 */
public class Plugin2 implements Plugin {

    public Plugin2() {
        System.out.println("Constructor of Plugin2");
    }

    @Override
    public void doSomething() {
        System.out.println("***Plugin2 executes \"doSomething\"***\n");
    }
}
