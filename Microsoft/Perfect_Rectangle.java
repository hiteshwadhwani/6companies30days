package Microsoft;
import java.util.*;

public class Perfect_Rectangle {
    //https://leetcode.com/problems/perfect-rectangle/description/
    public boolean isRectangleCover(int[][] rectangles) {
        //for reactange we will do 3 checks
        //here set maintains the 4 corners of rectangle
        //1) area of smaller reactangle == area of final reactangle
        //2) set should match 4 corner points which we have calculated 
        //3) size of set should be 4(rectangle has 4 corners)

        HashSet<String> set= new HashSet();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;

        for(int[] arr:rectangles){
            x1 = Math.min(arr[0], x1);
            y1 = Math.min(arr[1], y1);
            x2 = Math.max(arr[2], x2);
            y2 = Math.max(arr[3], y2);

            area += (arr[2] - arr[0]) * (arr[3] - arr[1]);

            String str1 = arr[0] + " " + arr[1];
            String str2 = arr[2] + " " + arr[1];
            String str3 = arr[0] + " " + arr[3];
            String str4 = arr[2] + " " + arr[3];

            String[] strArray = new String[]{str1, str2, str3, str4};
            for(String str:strArray){
                if(set.add(str) == false){
                    set.remove(str);
                }
            }
        }
        //check if set cotains all 4 corner points
        if(set.size() != 4) return false;

        //check if our 4 corner points are there in set
        if(!set.contains(x1 + " " + y1) ||
            !set.contains(x2 + " " + y1) ||
            !set.contains(x1 + " " + y2) ||
            !set.contains(x2 + " " + y2)){
                return false;
            }

        int rectArea = (x2 - x1) * (y2 - y1);
        if(area != rectArea) return false;
        
        return true;
    }
}
