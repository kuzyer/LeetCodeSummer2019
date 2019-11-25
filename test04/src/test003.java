import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//字符串处理专题-LeetCode151.翻转字符串里的单词
public class test003 {
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        //反转整个字符串
        reverse(a, 0, n - 1);
        //反转每个词
        reverseWords(a, n);
        //清除空格
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        // A||B&&C 优先级排序为：非-->与-->或,所以是先B&&C,再A||（B&&C）的顺序
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++;//跳过空格，到字符头
            while (j < i || j < n && a[j] != ' ') j++;//通过j<i跳过空格，然后通过a[j] != ''进入到字符尾
            reverse(a, i, j - 1);
        }
    }

    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' '; //保证(非末尾单词)末尾有一个空格
        }
        return new String(a).substring(0, i);
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    //调一堆函数23333
//    public static String reverseWords(String s) {
//        s.trim();
//        String[] b = s.split(" ");
//        List<String> c = Arrays.asList(b);
//        Collections.reverse(c);
//        StringBuffer d = new StringBuffer();
//        for (String e:
//                c) {
//            e.trim();
//            if (!e.equals("")) {
//                d.append(e).append(" ");
//            }
//        }
//        return d.toString().trim();
//    }
}
