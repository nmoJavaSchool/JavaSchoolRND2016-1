package Lesson8.HomeWork;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 06.08.16.
 */
public class MyArrayListTest {
    private MyArrayList<String> arrayList = new MyArrayList<>();
    @Before
    public void setUp() throws Exception {
        arrayList.add("Moscow");
        arrayList.add("Rostov-on-Don");
        arrayList.add("Yekaterinburg");
    }

    @Test
    public void testIteratorForNull() {
        Iterator<String> iterator = arrayList.iterator();
        assertNotNull(iterator);
    }

    @Test
    public void testData() {
        ArrayList<String> tempArray = new ArrayList<>();
        tempArray.add("Moscow");
        tempArray.add("Rostov-on-Don");
        tempArray.add("Yekaterinburg");

        Iterator<String> iterator = arrayList.iterator();

        int counter = 0;
        while(iterator.hasNext()){
            String value = iterator.next();
            assertEquals(tempArray.get(counter++),value);
        }
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testOfIndexOutOfBoundsException(){
        arrayList.get(10);
    }
}
