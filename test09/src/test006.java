/*
    排序算法模板-归并排序

    平均时间复杂度O(nlogn)
    最好情况O(nlogn)
    最坏情况O(nlogn)
    空间复杂度O(n)
    稳定
 */
public class test006 {

    public static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static int[] tmp = new int[array.length];

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= r) {
            tmp[k++] = arr[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = tmp[j];
        }
    }

    public static void main(String[] args) {
        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
