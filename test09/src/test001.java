//https://juejin.im/post/5b95da8a5188255c775d8124
/*
    排序算法模板-冒泡排序

    平均时间复杂度O(n2)
    最好情况O(n)
    最坏情况O(n2)
    空间复杂度O(1)
 */
public class test001 {
    public static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
    //从小到大排列
    public static void sort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int length = array.length;
        //外层：需要length-1次循环比较
        for (int i = 0; i < length - 1; i++) {
            //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j , j + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
