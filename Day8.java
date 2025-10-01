import java.util.*;

public class Day8 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char c1[] = s.toCharArray();
        char c2[] = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    public static void main(String[] args) {
        Day8 obj = new Day8();

        System.out.println(obj.isAnagram("anagram", "nagaram"));
        System.out.println(obj.isAnagram("rat", "car"));
    }
}
