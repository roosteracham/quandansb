package thread.线程间通信.通过管道通信.通过管道_字节流;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException{
        WriteData writeData = new WriteData();

        ReadData readData = new ReadData();

        PipedInputStream in = new PipedInputStream();

        PipedOutputStream out = new PipedOutputStream();

        in.connect(out);
        WriteThread writeThread = new WriteThread(writeData, out);

        ReadThread readThread = new ReadThread(readData, in);


        readThread.start();
        Thread.sleep(100);

        writeThread.start();
    }
}
