package java虚拟机.outofmemoryerror异常;

import java.util.ArrayList;
import java.util.List;

public class Java堆溢出 {

    static class HeapOOM {

    }

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<HeapOOM>();

        while (true) {
            list.add(new HeapOOM());
        }
    }
}
