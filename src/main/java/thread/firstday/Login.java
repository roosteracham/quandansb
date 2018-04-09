package thread.firstday;

public class Login {
    private static String username;
    private static String pwd;

    synchronized public static void doPost(String userName, String pwdd) {
        try {
            username = userName;
            if ("a".equals(userName)) {
                Thread.sleep(5000);
            }
            pwd = pwdd;
            System.out.println("username = " + username + " password = " + pwd);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
