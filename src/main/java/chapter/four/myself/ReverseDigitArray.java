package chapter.four.myself;

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
            StringBuilder sb = new StringBuilder(String.valueOf(n));
            sb.reverse();

            char[] charArray = sb.toString().toCharArray();

            int[] result = new int[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                result[i] = Character.getNumericValue(charArray[i]);
            }

            return result;

        }


    }
}
