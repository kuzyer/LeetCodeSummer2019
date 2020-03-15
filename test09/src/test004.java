/*
    排序算法模板-希尔排序

    平均时间复杂度O(n1.3)
    最好情况O(n)
    最坏情况O(n2)
    空间复杂度O(1)
    不稳定
 */
public class test004 {
    public static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int gap = arr.length / 2;
        for (; gap > 0; gap = gap / 2) {

            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                while (j >= 0 && arr[j] > arr[j + gap]) {
//                    arr[j + gap] = arr[j] + arr[j + gap];
//                    arr[j] = arr[j + gap] - arr[j];
//                    arr[j + gap] = arr[j + gap] - arr[j];
                    swap(arr, j, j + gap);
                    j = j - gap;
                }
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
