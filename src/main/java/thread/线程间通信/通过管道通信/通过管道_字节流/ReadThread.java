package thread.线程间通信.通过管道通信.通过管道_字节流;

import java.io.PipedInputStream;

public class ReadThread extends Thread {

    ReadData ReadData;

    PipedInputStream out;

    public ReadThread(ReadData ReadData, PipedInputStream out) {
        this.out = out;
        this.ReadData = ReadData;
    }

    @Override
    public void run() {
        ReadData.readMethod(out);
    }
}
