package Lesson7.HomeWork.ru.sbt.mipt.pluginRootDirectory.pluginName;

import Lesson7.HomeWork.ru.sbt.mipt.Plugin;

/**
 * Created by user on 03.08.16.
 */
public class Plugin1 implements Plugin {

    public Plugin1() {
        System.out.println("Constructor of Plugin1");
    }

    @Override
    public void doSomething() {
        System.out.println("***Plugin1 executes \"doSomething\"***\n");
    }
}
