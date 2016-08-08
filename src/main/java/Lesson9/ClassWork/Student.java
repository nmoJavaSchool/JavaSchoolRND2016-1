package Lesson9.ClassWork;

import java.io.*;

/**
 * Created by Student on 08.08.2016.
 */
public class Student implements Serializable {
    private String group;
    private int avgMark;

    public Student(){
        group = "default";
        avgMark = 3;
    }

    public static void main(String[] args) {
        String filename = "C:\\student.bin";
        Student student = new Student();

        try(FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream oss = new ObjectOutputStream(file)) {
            oss.writeObject(student);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Class<String> stringClass = String.class;
        } catch (IOException e) {
            e.printStackTrace();

        }

        try(FileInputStream file = new FileInputStream(filename);
            ObjectInputStream outf = new ObjectInputStream(file)) {
            System.out.println(outf.readObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", avgMark=" + avgMark +
                '}';
    }
}
