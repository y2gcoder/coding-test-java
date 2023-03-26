package chapter.three.myself;

/**
 * 거리두기 확인하기
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
public class ManhattanDistance {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };


        int[] result = solution.solution(places);
        System.out.println("result = " + result);
    }

    private static class Solution {
        public int[] solution(String[][] places) {
            int[] result = new int[5];

            for (int i = 0; i < 5; i++) {
                result[i] = isRoomSafe(places[i]);
            }

            return result;
        }

        private int isRoomSafe(String[] place) {
            for (int i = 0; i < 5; i++) {
                String row = place[i];
                for (int j = 0; j < 5; j++) {
                    row[j];
                }
            }


            return 1;
        }


    }
}
