package Lesson7.HomeWork.ru.sbt.mipt.pluginRootDirectory.pluginName.NewPack;

import Lesson7.HomeWork.ru.sbt.mipt.Plugin;

/**
 * Created by user on 04.08.16.
 */
public class Plugin3 implements Plugin {

    public Plugin3() {
        System.out.println("Constructor of Plugin3");
    }

    @Override
    public void doSomething() {
        System.out.println("***Plugin3 executes \"doSomething\"***\n");
    }
}