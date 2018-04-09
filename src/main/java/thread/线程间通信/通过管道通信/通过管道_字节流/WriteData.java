package thread.线程间通信.通过管道通信.通过管道_字节流;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write : ");
            for (int i = 0; i < 30; i++) {
                String data = "" + i + 1;
                outputStream.write(data.getBytes());
                System.out.println(data);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                outputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
