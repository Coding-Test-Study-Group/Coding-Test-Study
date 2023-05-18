package jiWoo.프로그래머스;

public class 프로그래머스_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int [][] map1=new int[n][n];
        int [][] map2=new int [n][n];
        // arr1[i], arr2[i]의 값들을 2진수로 변환해서 지도의 형태로 넣어준다(#->1)
        for(int i=0;i<n;i++){
            int num1=arr1[i]; // arr1[i]의 값(10진수)
            int num2=arr2[i]; // arr2[i]의 값(10진수)
            for(int j=n-1;j>=0;j--){ // n-1부터 시작해서 오른쪽부터 채워주기
                // num1 영역
                if(num1==1){ //num의 값이 1일 때 현재 map에 1을 넣고 num을 0으로 바꿔준다
                    map1[i][j]=1;
                    num1=0;
                }else if(num1==0){// num이 0일 때 map에 0
                    map1[i][j]=0;
                }else{ // num이 2 이상이면 map에 num의 2로 나눈 나머지 값을 넣어주고
                    // num은 2로 나눠준다
                    map1[i][j]=num1%2;
                    num1=num1/2;
                }
                // num2 영역
                // 위와 동일
                if(num2==1){
                    map2[i][j]=1;
                    num2=0;
                }else if(num2==0){
                    map2[i][j]=0;
                }else{
                    map2[i][j]=num2%2;
                    num2=num2/2;
                }
            }
        }

        // 최종 결과 구하기
        for(int i=0;i<n;i++){
            String result="";
            for(int j=0;j<n;j++){// map1과 map2를 비교하면서 String에 넣어주기
                if(map1[i][j]==1 || map2[i][j]==1){// 하나라도 1(#)이면 #
                    result+="#";
                }else{// 둘 다 0이면 공백 넣어주기
                    result+=" ";
                }
            }
            answer[i]=result;
        }
        return answer;
    }

    //  10진수->2진수 함수 이용한 풀이
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String [] ar1=new String[n];
        String [] ar2=new String[n];
        for(int i=0; i<n; i++){// 10진수 -> 2진수 진법 변환
            ar1[i]=Integer.toBinaryString(arr1[i]);
            ar2[i]=Integer.toBinaryString(arr2[i]);
            // n 크기의 길이 맞추기
            int len1=n-ar1[i].length();
            int len2=n-ar2[i].length();
            for(int a=0; a<len1;a++){
                ar1[i]="0"+ar1[i];
            }
            for(int a=0; a<len2;a++){
                ar2[i]="0"+ar2[i];
            }
        }
        // 2진수로 변한 값 들을 비교
        for(int i=0;i<n;i++){
            String result="";
            for(int j=0; j<n;j++){
                if(ar1[i].charAt(j)=='1' || ar2[i].charAt(j)=='1'){
                    // 둘 중 하나 1(#)이면 # 추가
                    result+="#";
                }else{ // 둘 다 0이면 공백 추가
                    result+=" ";
                }
            }
            answer[i]=result;
        }

        return answer;
    }
}

