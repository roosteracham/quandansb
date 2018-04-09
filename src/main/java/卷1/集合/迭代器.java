package 卷1.集合;


import 刷题.wangyi.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class 迭代器 {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Person person = new Person();
            person.setInteger(i);
            people.add(person);
        }

        people.iterator().forEachRemaining(person ->
                System.out.println(person.getInteger())

        );
    }
}
