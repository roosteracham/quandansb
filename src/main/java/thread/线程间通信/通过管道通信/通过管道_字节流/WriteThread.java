package thread.线程间通信.通过管道通信.通过管道_字节流;

import java.io.PipedOutputStream;

/**
 * 向管道写数据
 */
public class WriteThread extends Thread {

    WriteData writeData;

    PipedOutputStream out;

    public WriteThread(WriteData writeData, PipedOutputStream out) {
        this.out = out;
        this.writeData = writeData;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
