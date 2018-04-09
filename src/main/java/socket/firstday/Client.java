package socket.firstday;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {

            Socket socket = new Socket("localhost", 1089);
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write(Thread.currentThread().getName() + " 要上墙。");
            printWriter.flush();
            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String string = null;
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println("client accepts message : " + string);
            }
            socket.shutdownInput();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(printWriter != null) {
                    printWriter.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
