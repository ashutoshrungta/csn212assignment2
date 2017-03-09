import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheLuckyDraw {

	public static int binarySearch(int[] num, int l, int r, int vl) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (num[m] >= vl)
				r = m;
			else
				l = m;
		}
 
		return r;
	}
 
	public static int list(int[] num) {
 
		int N = num.length;
		int[] ansTab = new int[N];
		int length = 1;
		ansTab[0] = num[0];
		for (int x = 1; x < N; x++) {
			if (num[x] < ansTab[0]) {
				ansTab[0] = num[x];
			} else if (num[x] > ansTab[length - 1]) {
				ansTab[length++] = num[x];
			} else {
				ansTab[binarySearch(ansTab, -1, length - 1, num[x])] = num[x];
			}
		}
 
		return length;
	}
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
 
		for (int i = 0; i < t; i++) {
			int N = Integer.parseInt(f.readLine());
			int[] num = new int[N];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for (int x = 0; x < N; x++) {
				num[x] = Integer.parseInt(st.nextToken());
			}
			int ans = Integer.MIN_VALUE;
			for (int x = 0; x < N; x++) {
				int[] newNum = new int[N];
				for (int y = 0; y < N; y++) {
					newNum[y] = num[(x + y) % N];
				}
				ans = Math.max(ans, list(newNum));
			}
			System.out.println(ans);
		}
 		
 
	}
 
	
}
