/*
    排序算法模板-基数排序

    平均时间复杂度O(d*(n+r))
    最好情况O(d*(n+r))
    最坏情况O(d*(n+r))
    空间复杂度O(n+r)
    其中，d为位数，r为基数，n为原数组个数
    稳定
 */
public class test007 {
    public static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void sort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxDigit = 0;
        while (max != 0) {
            max = max / 10;
            maxDigit++;
        }

        int[][] buckets = new int[10][arr.length];
        int base = 10;

        for (int i = 0; i < maxDigit; i++) {
            //存储各个桶中存储元素的数量
            int[] bucketLen = new int[10];

            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bucketLen[whichBucket]] = arr[j];
                bucketLen[whichBucket]++;
            }

            int k = 0;
            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            for (int l = 0; l < buckets.length; l++) {
                for (int m = 0; m < bucketLen[l]; m++) {
                    arr[k++] = buckets[l][m];
                }
            }

            base *= 10;
        }

    }

    public static void main(String[] args) {
        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
