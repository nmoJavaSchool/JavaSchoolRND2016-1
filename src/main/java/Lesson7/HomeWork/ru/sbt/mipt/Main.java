package Lesson7.HomeWork.ru.sbt.mipt;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by user on 03.08.16.
 */
public class Main {
    public static void main(String[] args) {
        Plugin3 plugin3 = new Plugin3();
        plugin3.doSomething();
        String path =  System.getProperty("user.dir");
        path += "/out/production/JavaSchoolRND2016/";

        ArrayList<File> files = new ArrayList<>();

        File directory = new File(path +"Lesson7/HomeWork/ru/sbt/mipt/pluginRootDirectory/pluginName/");

        if(directory.exists()) {
            findFiles(directory,".class", files);
            for (int i = 0; i < files.size(); i++) {
                PluginManager pluginManager = new PluginManager(path);
                String pluginName = files.get(i).getAbsolutePath().substring(
                        files.get(i).getAbsolutePath().indexOf("Lesson7/"),
                        files.get(i).getAbsolutePath().length() - 6
                );

                pluginName = normalize(pluginName);
                Plugin plugin = pluginManager.load(pluginName,
                        files.get(i).getName().substring(0,files.get(i).getName().length()-6));

                plugin.doSomething();

            }

//            Plugin plugin = null;
//            try {
//                plugin = (Plugin3) Class.forName("Lesson7.HomeWork.ru.sbt.mipt.Plugin3").newInstance();
//                plugin.doSomething();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }

        }
    }
    public static void findFiles(File file, String wordStr, ArrayList<File> arrayList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                if(files[i].getAbsolutePath().indexOf(wordStr)!=-1) {
                    arrayList.add(files[i]);
                }
                findFiles(files[i], wordStr, arrayList); // Recursive call
            }
        }
    }
    private static String normalize(String str) {

        if(str.indexOf("/") >=0)
            return str.replace('/', '.');
        else
            return str.replace('\\', '.');
    }
}
