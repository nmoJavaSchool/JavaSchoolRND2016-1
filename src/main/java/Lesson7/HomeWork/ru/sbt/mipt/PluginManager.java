package Lesson7.HomeWork.ru.sbt.mipt;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by user on 03.08.16.
 */
public class PluginManager extends ClassLoader{
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        try {
            URL myUrl = new URL("file:" + pluginRootDirectory + normalize(pluginName, pluginRootDirectory) + ".class");
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while (data != -1) {
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            return (Plugin) defineClass(pluginName,
                    classData, 0, classData.length).newInstance();
        }catch (Exception e){
            return null;
        }
    }
    private String normalize(String str, String dir) {

        if(dir.charAt(dir.length()-1) == '/')
            return str.replace('.', '/');
        else
            return str.replace('.', '\\');
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        try {
//            URL myUrl = new URL("file:" + pluginRootDirectory + normalize(name, pluginRootDirectory) + ".class");
//            URLConnection connection = myUrl.openConnection();
//            InputStream input = connection.getInputStream();
//            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//            int data = input.read();
//
//            while (data != -1) {
//                buffer.write(data);
//                data = input.read();
//            }
//
//            input.close();
//
//            byte[] classData = buffer.toByteArray();
//
//            return defineClass(name,
//                    classData, 0, classData.length);
//        }catch (Exception e){
//            return null;
//        }
//    }
}