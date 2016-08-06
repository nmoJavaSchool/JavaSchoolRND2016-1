package Lesson3.ClassWork;

/**
 * Created by Student on 18.07.2016.
 */
public class Person implements Comparable<Person>{
    private long id;
    private String name;
    private String phoneNumber;

    public Person(long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (!name.equals(person.name)) return false;
        return phoneNumber.equals(person.phoneNumber);

    }

    @Override
    public int hashCode() {
        return (int)getId() + getName().hashCode() + getPhoneNumber().hashCode();
    }

    @Override
    public int compareTo(Person o) {
        return getPhoneNumber().compareTo(o.getPhoneNumber());

    }


}
