package chapter.four.answer;

/**
 * 자연수 뒤집어 배열로 만들기
 * level 1
 * https://programmers.co.kr/learn/courses/30/lessons/12932
 */
public class ReverseDigitArray {

    public static void main(String[] args) {
        Solution solution = new Solution();

        long n = 12345;


        int[] result = solution.solution(n);
        System.out.println("result = " + result);
    }

    private static class Solution {

        public int[] solution(long n) {
            String str = Long.toString(n);
            String reversed = new StringBuilder(str).reverse().toString();
            char[] arr = reversed.toCharArray();

            int[] result = new int[arr.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = arr[i] - '0';
            }
            return result;
        }


    }
}
