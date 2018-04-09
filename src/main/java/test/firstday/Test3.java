package test.firstday;

import test.enumsome.she;

import java.util.EnumSet;

import static test.enumsome.she.*;

public class Test3 {
    public static void main(String[] args) {
        //Thread thread = new Thread(she.NO);
//        .setVisibility(android.view.View.GONE);
//        thread.start();

        int i=5;

        int s=i++ + (++i);
        System.out.println(s);
    }
}
