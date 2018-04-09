package thread.线程间通信.通过管道通信.通过管道_字节流;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read : ");
            byte[] byteArray = new byte[20];
            int len = inputStream.read(byteArray); // 没有数据会阻塞在这里
            while (len != -1) {
                String data = new String(byteArray, 0, len);
                System.out.println(data);
                len = inputStream.read(byteArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                inputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
