import java.util.HashSet;
import java.util.Set;
//字符串处理专题-LeetCode929.独特的电子邮件地址
public class test005 {
    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            normalized.add(local[0].replace(".","") + "@" + parts[1]);
        }
        return normalized.size();
    }
}
