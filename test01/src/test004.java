//二分法-LeetCode74.搜索二维矩阵
public class test004 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //判断数组为空
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) return false;
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = 1 + l + (r - l) / 2;
            int element = matrix[mid / m][mid % m];
            if (element >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return matrix[r / m][r % m] == target;
    }
}
