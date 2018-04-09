package 克隆;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person p = new Person("zhsn");

        p.date = new StringBuilder("p");
        Person p1 = p.clone();
        p1.setName("lisi");
        p1.date.append("p1");
        p.say("p", "p");
        System.out.println(p.date);
        p1.say("p1", "p1");
        System.out.println(p1.date);
    }
}

class Person implements Cloneable{
    private String name;

    private int age;

    private String sex;

    public StringBuilder date;
    public void say(String something, String string) {
        System.out.println(name + " : " + string +  " : " + something);
    }

    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {

        Person p = (Person)super.clone();

        p.date = new StringBuilder();
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}