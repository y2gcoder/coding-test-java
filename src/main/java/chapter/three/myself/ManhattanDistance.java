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
        //상 우 하 좌
        private static final int[] dx = {0, 1, 0, -1};
        private static final int[] dy = {-1, 0, 1, 0};

        public int[] solution(String[][] places) {
            int[] result = new int[places.length];

            for (int i = 0; i < places.length; i++) {
                String[] place = places[i];
                result[i] = checkRoomSafe(place);
            }

            return result;
        }

        private int checkRoomSafe(String[] place) {

            for (int i = 0; i < place.length; i++) {
                String[] row = place[i].split("");
                for (int j = 0; j < row.length; j++) {
                    String d = row[j];
                    if (isPerson(d)) {
                        if (!isSafeDistancing(i, j, place)) {
                            return 0;
                        }
                    }
                }

            }
            return 1;
        }

        private boolean isSafeDistancing(int y, int x, String[] place) {
            int d1 = 0;
            while (d1 < 4) {
                int ny = y + dy[d1];
                int nx = x + dx[d1];
                d1 += 1;
                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
                    continue;
                }
                String d = place[ny].split("")[nx];
                //거리1에 사람 있을 때
                if (isPerson(d)) {
                    return false;
                }
                //거리1에 빈 테이블 있을 때
                if (isEmptyTable(d)) {

                    int d2 = 0;
                    while (d2 < 4) {
                        int n2y = ny + dy[d2];
                        int n2x = nx + dx[d2];
                        d2 += 1;
                        if (n2y < 0 || n2x < 0 || n2y >= 5 || n2x >= 5) {
                            continue;
                        }
                        //원래 좌표 건너뛰기
                        if (n2y == y && n2x == x) {
                            continue;
                        }
                        String dd = place[n2y].split("")[n2x];
                        //거리2에서 사람 있을 때
                        if (isPerson(dd)) {
                            return false;
                        }

                    }
                }

            }


            return true;
        }

        private boolean isPerson(String d) {
            return "P".equals(d);
        }

        private boolean isEmptyTable(String d) {
            return "O".equals(d);
        }

    }
}
