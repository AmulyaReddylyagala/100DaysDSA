
import java.util.*;

class Day12 {
    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies)
            set.add(c);
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {

        System.out.println(distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 })); // 3
        System.out.println(distributeCandies(new int[] { 1, 1, 2, 3 })); // 2
    }
}
