/*
    排序算法模板-直接插入排序

    平均时间复杂度O(n2)
    最好情况O(n)
    最坏情况O(n2)
    空间复杂度O(1)
 */
public class test003 {
    public static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    //移位法
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    //交换法
    public static void sort2(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                //只要大就交换操作
                arr[j + 1] = arr[j] + arr[j + 1];
                arr[j] = arr[j + 1] - arr[j];
                arr[j + 1] = arr[j + 1] - arr[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        sort2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
