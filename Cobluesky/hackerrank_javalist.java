import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int elements = sc.nextInt(); // 리스트의 원소 개수에 대한 입력을 받습니다.

        ArrayList<Integer> list = new ArrayList<>(); // 원소를 담을 리스트를 만듭니다.

        for (int i = 0; i < elements; i++) { // 원소 개수만큼 돌며 입력을 받습니다.
            list.add(sc.nextInt());
        }

        int queryCount = sc.nextInt(); // 수행할 쿼리 개수를 받습니다.

        for (int i =0; i < queryCount; i++) {
            String queryType = sc.next(); // 수행할 쿼리 타입을 받습니다.
            //next같은 경우 개행문자를 무시합니다. nextLine은 개행문자를 인식하기 때문에, 이 경우에는 next로 받아야합니다.

            switch(queryType) { // 입력받은 쿼리 타입에 따라 나눕니다.
                case "Insert": // 삽입 수행 시
                    list.add(sc.nextInt(), sc.nextInt()); // 첫 Int는 삽입할 인덱스, 두번째 Int는 삽입할 값입니다.
                    break;

                case "Delete": // 삭제 수행 시
                    list.remove(sc.nextInt()); // 삭제할 인덱스입니다.
                    break;
            }
        }
        sc.close(); // 스캐너 사용이 종료되었으므로, 닫습니다.

        for (Integer iterator : list) // For Each로 값을 출력합니다.
        {
            System.out.print(iterator + " "); // 문자열을 가공합니다.
        }
    }
}
