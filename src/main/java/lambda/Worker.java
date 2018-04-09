package lambda;

import model.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Worker {

    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "venus", "earth", "mars"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        //Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        //Timer timer = new Timer(1000, event -> System.out.println("the time is " + new Date()));
        //timer.start();

        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);
    }
    public static void test(){
        //List<User> users = new ArrayList<>();
        //users.stream().flatMap(List::stream);
    }
}