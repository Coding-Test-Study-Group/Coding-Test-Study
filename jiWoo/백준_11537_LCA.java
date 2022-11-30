package jiWoo;

import java.util.*;

public class 백준_11537_LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list[] = new ArrayList[N];
        int [] tree=new int[N+1];
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        
    }
}
