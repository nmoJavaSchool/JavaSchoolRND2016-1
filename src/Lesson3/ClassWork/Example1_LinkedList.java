package Lesson3.ClassWork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Student on 18.07.2016.
 */
public class Example1_LinkedList {
    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();
//        PersonFirstLoad.init(persons);
//        //System.out.println(persons);
//        PersonFirstLoad.print(persons);
        persons.offer(new Person(1L,"Байда Илья Вадимович","79185551234"));
        persons.offer(new Person(2L,"Истамов Аскар Зохитович","79185551233"));
        persons.offer(new Person(3L,"Кириловский Сергей Владимирович","79185551232"));
        persons.offer(new Person(5L,"Коджаев Шамиль Амил оглы","79185551231"));
        persons.offer(new Person(4L,"Нешин Антон Сергеевич","79185551230"));
        persons.offer(new Person(6L,"Орловский Николай Михайлович","79185551229"));
        persons.offer(new Person(7L,"Павлов Иван Геннадьевич","79185551228"));
        persons.offer(new Person(8L,"Романюта Александр Сергеевич","79185551227"));
        persons.offer(new Person(9L,"Комягин Денис Михайлович","79185551226"));
        persons.offer(new Person(10L,"Чернявский Александр Игоревич","79185551225"));
        persons.offer(new Person(11L,"Шмалько Светлана Григорьевна","79185551224"));
        persons.offer(new Person(12L,"Малеванный Михаил Сергеевич","79185551223"));
        persons.offer(new Person(13L,"Малахова Елена Александровна","79185551222"));
        persons.offer(new Person(14L,"Плешаков Владимир Владимирович","79185551221"));
        persons.offer(new Person(15L,"Жовнир Екатерина Юрьевна","79185551220"));
        persons.offer(new Person(16L,"Смолянинова Дарья Дмитриевна","79185551219"));

        Iterator<Person> it = persons.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("Last element: " + persons.peekLast());
        System.out.println("element: " + persons.get(2));
        System.out.println("element: " + persons.get(5));
        System.out.println("element: " + persons.get(9));

    }

}
