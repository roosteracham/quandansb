package 类型信息.反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {

    public static void main(String[] args) {
        try {
            Person p = new Person();
            Field field = Person.class.getDeclaredField("name");
            field.setAccessible(true);
            field.set(p, "zhang");
            p.say("asd", "asd");
            Method method = Person.class.getMethod("say", String.class, String.class);
            method.invoke(p, "全蛋是傻逼！", "abcs");
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException..");
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException..");
        } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException..");
        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException..");
        }
    }
}

class Person {
    private String name;

    private int age;

    private String sex;

    public void say(String something, String string) {
        System.out.println(name + " : " + string +  " : " + something);
    }/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

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