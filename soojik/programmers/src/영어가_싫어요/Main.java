package 영어가_싫어요;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("onetwothreefourfivesixseveneightnine"));
        System.out.println(s.solution("onezerotwo"));
        System.out.println(s.solution("onefourzerosixseven"));
    }
}

class Solution {
    static String[] eng = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public long solution(String numbers) {

        int[] record_num_index = new int[51];

        for (int i=0;i<=50;i++) record_num_index[i] = -1;

        for (int i = 0; i <= 9; i++) {
            int idx = 0;
            int idx_of_num;
            while ((idx_of_num = numbers.indexOf(eng[i], idx)) >= 0) {
                record_num_index[idx_of_num] = i;
                idx = idx_of_num + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<=50;i++) {
            if (record_num_index[i] >= 0) {
                sb.append(record_num_index[i]);
            }
        }

        return Long.parseLong(sb.toString());
    }
}