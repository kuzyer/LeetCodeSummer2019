import java.util.Scanner;

//赛码输入输出模板
public class Main {
    //动脑子认老乡
    //https://exercise.acmcoder.com/online/online_judge_ques?ques_id=9579&konwledgeId=137&opencustomeinput=true
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//            Map<Integer, Integer> mapRelation = new HashMap<>();//确认认识
//            Map<Integer, Integer> mapUnRelation = new HashMap<>();//可能认识
//            mapRelation.put(1, 1);
//            for(int i = 0; i < M; i++){
//                int one = sc.nextInt();
//                int two = sc.nextInt();
//                int three = sc.nextInt();
//                //当有关系时
//                if(three == 1){
//                    if(mapRelation.containsKey(one) && !mapRelation.containsKey(two)){
//                        mapRelation.put(two,two);
//                        if(mapUnRelation.containsKey(two)){
//                            int tmp = mapUnRelation.remove(two);
//                            mapUnRelation.remove(tmp);
//                            mapRelation.put(tmp, tmp);
//                        }
//                    }else if(mapRelation.containsKey(two) && !mapRelation.containsKey(one))  {
//                        mapRelation.put(one,one);
//                        if(mapUnRelation.containsKey(one)){
//                            int tmp = mapUnRelation.remove(one);
//                            mapUnRelation.remove(tmp);
//                            mapRelation.put(tmp, tmp);
//                        }
//                    }else if(!mapRelation.containsKey(one) && !mapRelation.containsKey(two)) {
//                        if(!mapUnRelation.containsKey(one)) mapUnRelation.put(one, two);
//                        if(!mapUnRelation.containsKey(two)) mapUnRelation.put(two, one);
//                    }
//                }
//
//            }
//
//            System.out.println(mapRelation.size() - 1);
//        }
//    }

    //最长回文字前缀
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            System.out.println(longest(a));
        }
    }

    public static int longest(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int i = 0, j = s.length() - 1;
        int end = j;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                j--;
                end = j;
            }
        }

        return end + 1;

    }

    public static int expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R <= s.length() - 1 && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
