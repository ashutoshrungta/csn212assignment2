import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AvoidRoads {
	
	public static void main(String[] args){
		String[] arg=new String[]{"0 0 0 1","6 6 5 6"};
		System.out.println(numWays(6,6,arg));
	}
	public static long Ways(int width, int height, String[] bad) {
        HashMap<String,HashSet<String>> blocks = new HashMap<String,HashSet<String>>();
        for (String badStr : bad) {
            String[] bl = badStr.split(" ");
            int a1 = Integer.parseInt(bl[0]);
            int b1 = Integer.parseInt(bl[1]);
            int a2 = Integer.parseInt(bl[2]);
            int b2 = Integer.parseInt(bl[3]);
            String p1 = "" + a1+ ":" + b1;
            String p2 = "" + a2 + ":" + b2;
            // p1 -> p2 && p2-> p1 are blocked
            if (!blocks.containsKey(p1)) {
                HashSet<String> set = new HashSet<String>();
                blocks.put(p1, set);
            }
            if (!blocks.containsKey(p2)) {
                HashSet<String> set = new HashSet<String>();
                blocks.put(p2, set);
            }
            blocks.get(p1).add(p2);
            blocks.get(p2).add(p1);
        }
        long max[][] = new long[width+1][height+1];
         
        for (int i = 0; i < width+1; i++) {
            for (int j = 0; j < height+1; j++) {
                if (i == 0 && j == 0) {
                    max[i][j] = 1;
                }
                else {
                    String s1 = ""+i+":"+j;
                    String s2 = ""+(i-1)+":"+j;
                    String s3 = ""+i+":"+(j-1);
                    if (i > 0 && !(blocks.containsKey(s2) && blocks.get(s2).contains(s1))) {
                        max[i][j] += max[i-1][j];
                    }
                    if (j > 0 && !(blocks.containsKey(s3) && blocks.get(s3).contains(s1))) {
                        max[i][j] += max[i][j-1];
                    }
                }
            }
        }
        return max[width][height];
    }
}
