package 背包;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tongji {
    public static void main(String[] args) {
        String ecsDataPath = "C:/Users/XINDQ/Desktop/初赛文档/练习数据/2015-12-2016-1.txt";
//        String inputFilePath = args[1];
        String resultFilePath = "C:/Users/XINDQ/Desktop/初赛文档/练习数据/2015-12-2016-1统计.txt";
        String[] strings = FileUtil.read(ecsDataPath, null);
        String[] tongji = tongji(strings);
        FileUtil.write(resultFilePath, tongji, false);
    }

    public static String[] tongji(String[] datas) {
        Count count = new Count();
        LocalDate start = LocalDate.parse(getProperty(datas[0], 1));
        LocalDate end = LocalDate.parse(getProperty(datas[datas.length - 1], 1));
        for (String data : datas) {
            String name = getProperty(data, 0);
            String date = getProperty(data, 1);
            count.put(name, date);
        }
        return count.asList(start, end).toArray(new String[0]);
    }

    private static String getProperty(String data, int type) {
        String[] split = data.split("\t");
        if (type == 0) {
            return split[1];
        } else {
            return split[2].substring(0, split[2].indexOf(' '));
        }
    }

    static class Count {
        private Map<String, Integer> rst = new HashMap<>();
        private List<String> nameList = new ArrayList<>();

        public int get(String name, LocalDate date) {
            return get(name, date.toString());
        }

        public int get(String name, String date) {
            String key = date + " " + name;
            Integer integer = rst.get(key);
            if (integer == null) {
                return 0;
            }
            return integer;
        }

        public void put(String name, LocalDate date) {
            put(name, date.toString());
        }

        public void put(String name, String date) {
            putName(name);
            String key = date + " " + name;
            Integer integer = rst.get(key);
            if (integer != null) {
                rst.put(key, integer + 1);
            } else {
                rst.put(key, 1);
            }
        }

        private void putName(String name) {
            if (!nameList.contains(name)) {
                nameList.add(name);
            }
        }

        public List<String> asList(LocalDate start, LocalDate end) {
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nameList.size(); i++) {
                String name = nameList.get(i);
                for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) {
                    sb.delete(0, sb.length());
                    int a = get(name, d);
                    sb.append(name).append(" ").append(d.toString())
                            .append(" ").append(a);
                    list.add(sb.toString());
                }
            }
            return list;
        }

        public List<String> asList(String start, String end) {
            return asList(LocalDate.parse(start), LocalDate.parse(end));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            rst.forEach((s, integer) -> {
                sb.append(s);
                sb.append(" ");
                sb.append(integer);
                sb.append("\n");
            });
            return sb.toString();
        }
    }
}
