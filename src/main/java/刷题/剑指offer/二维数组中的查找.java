package 刷题.剑指offer;

public class 二维数组中的查找{

        public boolean Find(int target, int [][] array) {

            boolean flag = false;
            int n = array[0].length;
            try {
                if (target >= array[0][0] && target <= array[array.length - 1][n - 1]) {
                    int low = -1, h = -1;
                    for (int i = 0; i < array.length; i++) {
                        if (target >= array[i][0] && target <= array[i][n - 1]) {
                            for (int j = 0; j < n; j++) {
                                if (target == array[i][j]) {
                                    return true;
                                }
                            }

                        }
                    }
                }
            }catch (Exception e) {
                return false;
            }
            return flag;
        }

    public static void main(String[] args) {
        int[][] a = {{}};
        System.out.println(a.length);
    }
}
