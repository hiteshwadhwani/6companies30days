package Microsoft;
import java.util.*;

public class Rotate_Function{
    //https://leetcode.com/problems/rotate-function/description/
    public int maxRotateFunction(int[] nums) {
        //dp
        //general equation -> f(k) = f(k-1) + sum + N(arr[N-K])

        int n = nums.length;
        int[] dp = new int[n];
        int temp = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            temp += (i * nums[i]);
            sum += nums[i];
        }
        dp[0] = temp;
        int max = Integer.MIN_VALUE;
        max = Math.max(max, dp[0]);
        for(int i=1;i<n;i++){
            dp[i] = dp[i-1] + sum - (n * nums[n - i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
