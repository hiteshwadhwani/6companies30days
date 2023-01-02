package Microsoft;
import java.util.*;

public class Combination_Sum_III{
    //https://leetcode.com/problems/combination-sum-iii/description/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n,k,list,ans,0,1);
        return ans;
    }
    public void helper(int n, int k, List<Integer> list, List<List<Integer>> ans, int sum,int idx){
        if(list.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=idx;i<=9;i++){
            list.add(i);
            helper(n,k,list,ans,sum + i,i+1);
            list.remove(list.size() -1);
        }
    }
}
