package 刷题.今日头条;

import java.util.*;

public class 用户喜好 {
    public static void main(String[] args) throws InterruptedException{

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        Map<Integer, List> map = new HashMap<>();
        for (int i = 1; i < num + 1; i++) {
            int val = scanner.nextInt();
            if (map.containsKey(val)) {
                map.get(val).add(new User(i, val));
            } else {
                List<User> users = new ArrayList<>();
                users.add(new User(i, val));
                map.put(val, users);
            }
        }

        int lines = scanner.nextInt();

        int result[] = new int[lines];
        for (int i = 0; i < lines; i++) {
            int l = scanner.nextInt();
            int h = scanner.nextInt();
            int val = scanner.nextInt();
            List<User> users;
            if (map.containsKey(val)) {
                users = map.get(val);
            } else {
                result[i] = 0;
                continue;
            }
            Collections.sort(users, new MultistageSort());

            int head = 0;
            boolean f1 = false;
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).id < l || users.get(j).id > h)
                    continue;
                if (users.get(j).id >= l) {
                    head = j;
                    f1 = true;
                    break;
                }
            }
            int tail = users.size() - 1;
            boolean f2 = false;
            for (int j = users.size() - 1; j > head; j--) {
                if (users.get(j).id < l || users.get(j).id > h)
                    continue;
                if (users.get(j).id <= h) {
                    tail = j;
                    f2 = true;
                    break;
                }
            }

            if (f1 && f2) {
                result[i] = tail - head + 1;
            } else {
                result[i] = (f1 || f2) ? 1 : 0;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

   /* static int findLast(List list, int val) {
        int head = 0, tail = list.size() - 1,mid = 0, result = 0;
        while (head < tail) {
            mid = (head + tail) / 2;
            User a = (User)list.get(mid);

            if (a.id >= val) {
                result = mid;
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return result;
    }
    static int findFirst(List list, int val) {
        int head = 0, tail = list.size() - 1,mid = 0, result = 0;
        while (head < tail) {
            mid = (head + tail) / 2;
            User a = (User)list.get(mid);

            if (a.id >= val) {
                result = mid;
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return result;
    }*/
}

class User{
    public int id;
    public int favor;
    public User(){}

    public User(int id, int favor){
        this.id = id;
        this.favor = favor;
    }

}

class MultistageSort implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        int cr = 0;
        int a = o1.favor - o2.favor;
        if (a != 0) {
            return cr = (a > 0) ? 2 : -1;
        } else {
            a = o1.id - o2.id;
            if (a != 0) {
                cr = (a > 0) ? 1 : -2;
            }
        }
        return cr;
    }
}