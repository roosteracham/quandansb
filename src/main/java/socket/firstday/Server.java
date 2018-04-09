package socket.firstday;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(1089);
            System.out.println("服务已经开启，等待链接。。");
            int count = 0;
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
                System.out.println("第 " + ++count + " 次链接");
                System.out.println("链接地址是： " + socket.getInetAddress().getHostAddress());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
