
public class Day18 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 128;
        System.out.println("Number of 1 bits: " + hammingWeight(n));
    }
}
