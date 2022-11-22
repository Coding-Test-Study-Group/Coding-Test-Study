package jiWoo;
import java.util.*;
public class SWEA_1206_View{
    static int N;
	static int [] buildings;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			N=sc.nextInt();
			buildings=new int[N];
		
			for(int j=0;j<N;j++){
                buildings[j]=sc.nextInt();
            }
			System.out.println("#"+(i+1)+" "+findNiceView());
		}
	}
	static int findNiceView() {
		int result=0;
		for(int i=2;i<N-2;i++){
			int cnt=0;
			int Left=Math.max(buildings[i-2],buildings[i-1]);
			int Right=Math.max(buildings[i+2],buildings[i+1]);
			int max=Math.max(Left,Right);
	
			if(buildings[i]>max) {
				result+=buildings[i]-max;
				i+=2;
			}
		}
		
		return result;
	}

}
