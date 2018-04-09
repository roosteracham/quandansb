package 类型信息.forname;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface i1{}
interface i2{}
interface i3{}
interface  i4{}
class P extends Father implements i1,i2, i3, i4{
    /*P(){
        System.out.println("wucan");
    }*/
    /*P() {
        super(1);
    }*/
}
class Q extends Father{
    Q() {
        super(2);
    }
}
class Father{
    Father(){}

    Father(int i) {}

}
public class Forname获得引用 {

    public static void print(Class cla) {

        System.out.println("【ClassName : " + cla.getName() + " isIterface : " + cla.isInterface() + " simpleName : " + cla.getSimpleName() + " CanoniName : "
                + cla.getCanonicalName() + " 】");
    }

    static void p1(Class object) {
        for (Class cla : object.getDeclaredClasses()) {
            System.out.println(cla.getName());
        }
    }

    static void p2(Class object) {
        for (Field cla : object.getDeclaredFields()) {
            System.out.println(cla.getName());
        }
    }

    static boolean isClass(Class cla) {
        if (cla.isPrimitive() && cla.isArray() && cla.isEnum())
            return false;
        return true;
    }
    public static void main(String[] args) throws Exception{
//        P p = new P();
//        print(p.getClass());
//
//        Class clas = p.getClass();
//        for (Class cla : clas.getInterfaces()) {
//            print(cla);
//        }
//
//        Class cla = clas.getSuperclass();
//        print(cla.newInstance().getClass());

        /*Class cla = new P().getClass();

        System.out.println(isClass(cla));
        System.out.println(isClass(new int[2].getClass()));

        char[]a = {};
        System.out.println(isClass(a.getClass()));*/
/*
        P p1 = new P();

        System.out.println(P.class == p1.getClass());


        System.out.println(P.class.isInstance(p1));*/

        Class cla = Class.forName("java.lang.String");
        /*
        for (Method method : cla.getMethods()) {
            int i = method.getModifiers();
            Class type = method.getReturnType();
            String name = method.getName();
            Class[] classes = method.getParameterTypes();
            System.out.println(i +" " + type + " " + name);
            for (Class j : classes) {
                System.out.println(j.getSimpleName());
            }
        }*/

        for (Field field : cla.getFields()) {
            System.out.println(field.getModifiers() + " " + field.getName());
        }

        for (Constructor constructor : cla.getConstructors()) {
            System.out.println(constructor.getName());
        }
    }
}