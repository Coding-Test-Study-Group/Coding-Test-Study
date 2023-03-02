// Baekjoon_1377_버블소트
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;    // value기준 오름차순
    }
}

public class Baekjoon_1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        mData[] arr = new mData[N]; // mData클래스는 comparable인터페이스를 받으므로 오름차순 정렬되어 배열에 저장된다. 

        for(int i=0; i<N; i++) {
            // 정렬 전 인덱스를 저장해놓기 위해서 클래스의 인스턴스변수인 index에 저장해논다.
            arr[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr);    // 오름차순 정렬

        int max = 0;
        for(int i=0; i<N; i++) {
            // (정렬 전 인덱스 - 정렬 후 인덱스)의 최댓값 구하기
            max = Math.max(max, arr[i].index - i);
        }
        System.out.println(max+1);  // +1을 해주는 이유는 false인걸 한번 더 확인 하는 과정이 있으므로
    }
}
