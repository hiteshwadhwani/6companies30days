package Microsoft;
import java.util.*;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String oprt = "+-*/";
        
        for(int i=0;i<tokens.length;i++){
            String str = tokens[i];
            if(oprt.contains(str) && !stack.isEmpty()){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(help(n1,n2,str));
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    public int help(int n1,int n2,String str){
        if(str.equals("+")) return n2 + n1;
        else if(str.equals("-")) return n2 - n1;
        else if(str.equals("*")) return n2 * n1;
        else if(str.equals("/")) return n2 / n1;
        return -1;
    }
}
