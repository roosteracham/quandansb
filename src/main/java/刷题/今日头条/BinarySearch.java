package 刷题.今日头条;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {2,2,2,3,3,7,8};
        System.out.println(posFirstly(a, 2));
    }

    // 二分查找元素，需要事先排序
    public static int binarySearchBeforeSoeted(int[] array, int val) {
        Arrays.sort(array);
        return binarySearchAfterSoeted(array, val);
    }

    public static int binarySearch(int[] array, int val) {
        return sortMoreInfo(array, val, new Pos()).getPos();
    }

    public static Pos sortMoreInfo(int[] array, int val, Pos position) {
        int pos = position.getPos();
        int low = position.getLow();
        int heigh = position.getHeigh() < array.length - 1 ?
                position.getHeigh() : array.length - 1;
        int mid = 0;

        while (low <= heigh) {
            mid = (low + heigh) / 2;
            if (array[mid] > val) {
                heigh = mid - 1;
            } else if (array[mid] < val) {
                low = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        position.setHeigh(heigh);
        position.setLow(low);
        position.setPos(pos);
        return position;
    }

    public static int binarySearchAfterSoeted(int[] array, int val) {
        return binarySearch(array, val);
    }

    // 查询第一次出现的位置，第一次二分查找找到某个位置的值，然后挨个往前遍历
    public static int firstlyOccursPos(int[] array, int val) {
        int pos = -1;

        pos = binarySearch(array, val);

        if (pos == -1 || pos == 0) {
            return pos;
        } else {
            for (int i = pos - 1; i >= 0; i--) {
                if (val != array[i]) {
                    break;
                }
                pos = i;
            }
        }
        return pos;
    }

    // 查询最后一次出现的位置，第一次二分查找找到某个位置的值，然后挨个往后遍历
    public static int lastOccursPos(int[] array, int val) {
        int pos = -1;

        pos = binarySearch(array, val);

        if (pos == -1 || pos == array.length - 1) {
            return pos;
        } else {
            for (int i = pos + 1; i < array.length; i++) {
                if (val != array[i]) {
                    break;
                }
                pos = i;
            }
        }
        return pos;
    }

    // 最先出现, 每次查找都是二分查找
    public static int posFirstly(int[] array, int val) {
        Pos pos = new Pos();
        int[] a = array.clone();
        do {
            pos = sortMoreInfo(a, val, pos);
            if (pos.getPos() == -1 || pos.getPos() == 0
                    || array[pos.getPos() - 1] != val) {
                break;
            } else {
                pos.setHeigh(pos.getPos());
            }
        }while (true);
        return pos.getPos();
    }

    // 最后出现, 每次查找都是二分查找
    public static int poslast(int[] array, int val) {
        Pos pos = new Pos();
        int[] a = array.clone();
        do {
            pos = sortMoreInfo(a, val, pos);
            if (pos.getPos() == -1 || pos.getPos() == pos.getHeigh()
                    || array[pos.getPos() + 1] != val) {
                break;
            } else {
                pos.setLow(pos.getLow());
            }
        }while (true);
        return pos.getPos();
    }

    public static int lastMaxPosOfLessThanValue(int[] array, int val, int low, int height) {

        while (true) {
            int mid = (low + height) / 2;
            if (array[mid] > val) {
                height = mid - 1;
            } else if (array[mid] < val){
                low = mid;
            } else {
                low = mid;
                break;
            }
            if (low == height) {
                break;
            }
        }
        return low;
    }
}

class Pos {
    private int low = 0;
    private int heigh = Integer.MAX_VALUE;
    private int pos = -1;

    public Pos(){}

    public Pos(int low, int heigh, int pos) {
        this.low = low;
        this.heigh = heigh;
        this.pos = pos;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}