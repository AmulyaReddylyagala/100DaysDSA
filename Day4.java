// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

class Day4 {

    // BruteForce
    public static int maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {

                sum += arr[j];

                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }
    // TC:O(N2) SC=O(1)

    // optimal Approach
    // Kadane's Algorithm
    // 1.Run a loop &intialbe var sum to 0
    // 2.while iterating add elements to sum variable and consider maximum one.
    // 3.if any point sum becomes -ve set sum to 0 because -ve value will always
    // decreae our sum so we wont get maximum sum so acoid it.

    public static int maxSubarraySum2(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
        // otpiml aprch
        int res = maxSubarraySum2(arr, n);
        System.out.println(res);

    }
}
