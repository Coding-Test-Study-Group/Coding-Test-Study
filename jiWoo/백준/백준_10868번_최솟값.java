package jiWoo.백준;

import java.util.*;

public class 백준_10868번_최솟값 {
    static long [] tree;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt(); // N개의 정수
        int M= sc.nextInt(); // M개의 a, b 쌍
        // tree의 size 찾기
        int length=N;
        int treeHeight=0; 
        while(length !=0){
           length/=2;
           treeHeight++;
        }
        int treeSize= (int)Math.pow(2,treeHeight+1);
        int startIdx=treeSize/2;
        tree= new long[treeSize+1];
        // 트리 값 맥스로 최기화
        for(int i=0;i<tree.length;i++){
            tree[i]=Long.MAX_VALUE;
        }
       
        for(int i=0;i<N;i++){
            tree[startIdx+i]=sc.nextLong();
        }
        // 트리 min값 세팅
        setMinTree(treeSize-1);

        // M쌍 a~b까지 최솟값 찾기

        for(int i=0;i<M;i++){
            int a=sc.nextInt()+startIdx-1, b=sc.nextInt()+startIdx-1;
            
            System.out.println(findMin(a, b));
        }

        
    }

    static void setMinTree(int size){ // 트리 min값 세팅
        while(size !=1){
            if(tree[size /2]>tree[size]){ 
                tree[size/2]=tree[size];
            }
            size--;
           
        }
    }

    static long findMin(int a, int b){
       long Min=Long.MAX_VALUE;
        while(a<=b){
            //System.out.println(start +"  "+end);
            if(a%2==1){ // a노드가 트리의 오른쪽 노드면 min 값과 비교해서 저장
                Min=Math.min(Min,tree[a]);
                a++;
            }
            if(b%2==0){ // b노드가 트리의 왼쪽 노드이면 min 값과 비교해서 저장
                Min=Math.min(Min,tree[b]);
                b--;
            }
            // 부모노드로 이동!
            a=a/2;
          
            b=b/2;
          
         }
        return Min;
    }
   
}
