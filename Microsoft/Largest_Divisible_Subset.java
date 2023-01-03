package Microsoft;
import java.util.*;

public class Largest_Divisible_Subset{
    //https://leetcode.com/problems/bulls-and-cows/description/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] child = new int[nums.length];
        int imax = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(child, -1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        child[i] = j;
                    }
                }
            }
            if(dp[i] > dp[imax]){
                imax = i;
            }
        }

        //backtracking for o/p array
        List<Integer> ans = new ArrayList<>();
        while(imax != -1){
            ans.add(nums[imax]);
            imax = child[imax];
        }
        return ans;
    }
}
