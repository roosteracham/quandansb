package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class InsertSql {
    public static void main(String[] args) {
        String[] a = {"insert into history_table (tag_id,tag_name, value, timestamp) values('",
                "','", "','", "','", "')"};
        //String b[] = new String[4];

        String tagName = "1号管区液位";
        String tagId = "A001";
        //float value = getValue();
        //System.out.println(value);

        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        getDate(date, sdf);

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 400; i++) {
            String[] b = {tagId, tagName, getValue(101) + "", getDate(date, sdf)};
            stringBuilder.append(a[0]);
            for (int j = 1; j < a.length; j++) {

                stringBuilder.append(b[j - 1])
                        .append(a[j]);/*
                        .append(tagName)
                        .append(getValue())
                        .append(getDate(date, sdf));*/
            }
            stringBuilder.append(";\r\n");
        }

        tagId = "A002";
        tagName = "2号管区液位";
        date = Calendar.getInstance();
        //System.out.println(stringBuilder.toString());
        for (int i = 0; i < 400; i++) {
            String[] b = {tagId, tagName, getValue(98) + "", getDate(date, sdf)};
            stringBuilder.append(a[0]);
            for (int j = 1; j < a.length; j++) {

                stringBuilder.append(b[j - 1])
                        .append(a[j]);/*
                        .append(tagName)
                        .append(getValue())
                        .append(getDate(date, sdf));*/
            }
            stringBuilder.append(";\r\n");

        }

        tagId = "A003";
        tagName = "3号管区液位";
        date = Calendar.getInstance();
        for (int i = 0; i < 400; i++) {
            String[] b = {tagId, tagName, getValue(60) + "", getDate(date, sdf)};
            stringBuilder.append(a[0]);
            for (int j = 1; j < a.length; j++) {

                stringBuilder.append(b[j - 1])
                        .append(a[j]);/*
                        .append(tagName)
                        .append(getValue())
                        .append(getDate(date, sdf));*/
            }
            stringBuilder.append(";\r\n");
        }

        File file = new File("D:\\insert.sql");

        try {
            if (!file.exists()) {
                file.setExecutable(true);
                file.createNewFile();
            }

            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(stringBuilder.toString());
        }catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static String getDate(Calendar date, SimpleDateFormat sdf) {
        date.add(Calendar.MINUTE, 1);
        return sdf.format(date.getTime());
    }

    public static float getValue(float a) {
        return a + Math.round((new Random().nextFloat()) * 100) / 100.0f;
    }
}
