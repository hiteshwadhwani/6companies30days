package Microsoft;

public class Bulls_and_Cows {
    //https://leetcode.com/problems/bulls-and-cows/description/
    public String getHint(String secret, String guess) {
        int bull = 0;
        boolean[] visited = new boolean[secret.length()];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
                visited[i] = true;
            }
        }
        int cow = 0;
        int[] hash = new int[10];
        for(int i=0;i<secret.length();i++){
            if(visited[i]){
                continue;
            }
            char ch = secret.charAt(i);
            hash[ch - 48]++;
        }
        for(int i=0;i<secret.length();i++){
            if(visited[i]){
                continue;
            }
            int n = guess.charAt(i) - 48;
            if(hash[n] > 0){
                hash[n]--;
                cow++;
            }
        }
        return Integer.toString(bull) + 'A' + Integer.toString(cow) + 'B';
    }
}
