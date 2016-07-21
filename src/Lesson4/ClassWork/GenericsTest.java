package Lesson4.ClassWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 21.07.2016.
 */
public class GenericsTest {
    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        strList.add(new String("1"));
        A<String> a = new A<>("dfsd");
        System.out.println(a.getValue());
        System.out.println(a.getType());
        A<Integer> b = new A<>(1);
        System.out.println(b.getValue());
        System.out.println(b.getType());

        System.out.println(new A("sdfsdf"){
            @Override
            public String getType() {
                return super.value.getClass().getTypeName();
            }
        }.getType());

        System.out.println(B.getType((short)6));
        A <? extends Integer> aa = new A<>(5);
        System.out.println(aa.getType());
        System.out.println(aa.getValue());
    }
}
