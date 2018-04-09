package serializable;

import java.io.*;

public class Ser1 {
    public static void main(String[] args) {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream("D://a.out");
            ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);

            S2 s2 = new S2();
            objectInputStream.writeObject(s2);
            objectInputStream.flush();
            objectInputStream.close();

            FileInputStream fileInputStream = new FileInputStream("D://a.out");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream);
            S2 s31 = (S2)objectInputStream1.readObject();
            //System.out.println(s31.s1value);
            //System.out.println(s31.s3Value);
            System.out.println(s31.s2Value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class S1 implements Serializable {

    private static final long serialVersionUID = -4963266899668807475L;

    public int s1value = 100;
}

class S2 implements Serializable {

    private static final long serialVersionUID = 5704957411985783570L;

    public int s2Value = 200;
}

class S3 extends S1 implements Serializable {

    private static final long serialVersionUID = -3186721026267206914L;

    public int s3Value = 300;

    public S2 s3Object = new S2();
}