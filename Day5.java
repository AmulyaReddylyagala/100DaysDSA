
//  Maximum Product Subarray  
//  Given an integer array nums,find a subarray that has the largest product,and return the product.

class Day5 {

    // Bruteforce
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            int prod = nums[i];
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, prod);
                prod *= nums[j];
            }
            res = Math.max(res, prod);
        }
        return res;
    }
    // Tc=O(N2) SC=O(1)

    // Optimal Approach

    public static int maxProductSubArray(int nums[]) {
        int prod = nums[0], prod1 = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(nums[i], Math.max(prod * nums[i], prod1 * nums[i]));
            prod1 = Math.min(nums[i], Math.min(prod * nums[i], prod1 * nums[i]));
            prod = tmp;

            res = Math.max(res, prod);

        }
        return res;
    }
    // TC=O(N) SC=O(1)

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
        // optimal approach
        System.out.println(maxProductSubArray(nums));
    }
}
