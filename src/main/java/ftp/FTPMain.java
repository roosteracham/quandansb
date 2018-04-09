package ftp;


import java.io.InputStream;
import java.util.Properties;



public class FTPMain {

    public static void main(String[] args) {
        int ftpPort = 0;
        String ftpUserName = "";
        String ftpPassword = "";
        String ftpHost = "";
        String ftpPath = "";
        String writeTempFielPath = "";
        try {
            InputStream in = FtpUtil.class.getClassLoader()
                    .getResourceAsStream("env.properties");
            if (in == null) {
                System.out.println("配置文件env.properties读取失败");
            } else {
                Properties properties = new Properties();
                properties.load(in);
                ftpUserName = properties.getProperty("ftpUserName");
                ftpPassword = properties.getProperty("ftpPassword");
                ftpHost = properties.getProperty("ftpHost");
                ftpPort = Integer.valueOf(properties.getProperty("ftpPort"))
                        .intValue();
                ftpPath = properties.getProperty("ftpPath");
                writeTempFielPath = properties.getProperty("writeTempFielPath");

                ReadFTPFile read = new ReadFTPFile();
                String result = read.readConfigFileForFTP(ftpUserName, ftpPassword,
                        ftpPath, ftpHost, ftpPort, "huawei_220.248.192.200.cfg");
                System.out.println("读取配置文件结果为：" + result);

                WriteFTPFile write = new WriteFTPFile();
                ftpPath = ftpPath + "/" + "huawei_220.248.192.200_new1.cfg";
                write.upload(ftpPath, ftpUserName, ftpPassword, ftpHost, ftpPort, result, writeTempFielPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}  
