package chapter.three.answer;

/**
 * 행렬의 곱셈
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/12949
 */
public class MatrixMultiplication {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4}, {2, 4}, {3, 1}};


        int[][] result = solution.solution(arr1, arr2);
        System.out.println("result = " + result);
    }

    private static class Solution {

        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] arr = new int[arr1.length][arr2[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = 0;
                    for (int k = 0; k < arr1[i].length; k++) {
                        arr[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }


            return arr;
        }

    }
}
