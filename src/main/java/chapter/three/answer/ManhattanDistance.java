package chapter.three.answer;

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

        //상좌우하 => KEYPOINT! 반대방향 구하기 용이하게 변경했네!
        private static final int[] dx = {0, -1, 1, 0};
        private static final int[] dy = {-1, 0, 0, 1};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            for (int i = 0; i < answer.length; i++) {
                String[] place = places[i];
                char[][] room = new char[place.length][];
                for (int j = 0; j < room.length; j++) {
                    room[j] = place[j].toCharArray();
                }
                if (isDistanced(room)) {
                    answer[i] = 1;
                } else {
                    answer[i] = 0;
                }

            }

            return answer;
        }

        private boolean isDistanced(char[][] room) {
            for (int y = 0; y < room.length; y++) {
                for (int x = 0; x < room[y].length; x++) {
                    if (room[y][x] != 'P') continue;
                    if (!isDistanced(room, x, y)) return false;
                }
            }
            return true;
        }

        private boolean isDistanced(char[][] room, int x, int y) {
            //room[y][x]가 거리두기를 지키는 지 검사
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
                // room[ny][nx]를 통해 다른 응시자에게 도달할 수 있는지 검사
                switch (room[ny][nx]) {
                    case 'P': return false;
                    case 'O':
                        if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                        break;
                }
            }
            return true;
        }

        private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
            for (int d = 0; d < 4; d++) {
                if (d == exclude) continue;

                int nx = x + dx[d];
                int ny = y + dy[d];
                if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
                if (room[ny][nx] == 'P') return true;
            }
            return false;
        }

    }
}
