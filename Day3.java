// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

class Day3 {

    // Brute force
    public static int[] Bruteforce(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            res[i] = product;
        }

        return res;
    }
    // TC =O(N2) SC=O(1)

    // Better Approach
    public static int[] BetterApproach(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;

    }
    // Tc=O(N) sc=O(N)

    // Optimal Approach
    public static int[] OptimalApproach(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] result = Bruteforce(nums);
        System.out.println("solution using Bruteforce");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("solution using better Approach");
        int[] result2 = BetterApproach(nums);
        for (int val : result2) {
            System.out.print(val + " ");
        }

        System.out.println();
        System.out.println("Solution using Optimal Approach");

        int[] result3 = OptimalApproach(nums);
        for (int val : result3) {
            System.out.print(val + " ");
        }

    }
}