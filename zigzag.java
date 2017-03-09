
public class zigzag{

	
	public static void main(String[] args){
		
		int[] x=new int[]{
				10, 22, 9, 33, 49, 50, 31, 60
		};
		System.out.println(zigzag1(x));
	}
	public static int zigzag1(int[] arr){
		int n=arr.length;
		int[][] s=new int[n][2];
		//Initializeing all values to 1
		for(int i=0;i<n;i++){
			s[i][0]=s[i][1]=1;			
		}
		int r=1;
		//Computing values in bottom-up manner
		for(int i=1;i<n;i++){
			//consider all the values previous of i
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i] && s[i][0]<s[j][1]+1){
					s[i][0]=s[j][1]+1;
				}
				if(arr[j]>arr[i] && s[i][1]<s[j][0]+1){
					s[i][1]=s[j][0]+1;
				}
			}
			//Picking the max index i
			r=Math.max(s[i][0], sol[i][1]);
		}
		return r;
	}
}
