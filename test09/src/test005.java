/*
    排序算法模板-选择排序

    平均时间复杂度O(n2)
    最好情况O(n2)
    最坏情况O(n2)
    空间复杂度O(1)
    不稳定
 */
public class test005 {
    public static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                //找到最小值放在最前面
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min !=  i) {
                swap(array, min, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void main(String[] args) {
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
