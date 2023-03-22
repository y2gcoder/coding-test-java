package chapter.three.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 삼각 달팽이
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
public class MakingStar {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};

        String[] result = solution.solution(line);
        System.out.println("result = " + result);
    }

    private static class Solution {
        private static class Point {
            public final long x, y;

            private Point(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }

        private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
            double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
            double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

            if (x % 1 != 0 || y % 1 != 0) return null;

            return new Point((long) x, (long) y);
        }

        private Point getMinimumPoint(List<Point> points) {
            long x = Long.MAX_VALUE;
            long y = Long.MAX_VALUE;

            for (Point p : points) {
                if (p.x < x) x = p.x;
                if (p.y < y) y = p.y;
            }

            return new Point(x, y);
        }

        private Point getMaximumPoint(List<Point> points) {
            long x = Long.MIN_VALUE;
            long y = Long.MIN_VALUE;

            for (Point p : points) {
                if (p.x > x) x = p.x;
                if (p.y > y) y = p.y;
            }

            return new Point(x, y);
        }

        public String[] solution(int[][] line) {
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    Point intersection = intersection(line[i][0], line[i][1], line[i][2]
                            , line[j][0], line[j][1], line[j][2]);
                    if (intersection != null) {
                        points.add(intersection);
                    }
                }
            }

            Point minimum = getMinimumPoint(points);
            Point maximum = getMaximumPoint(points);

            int width = (int) (maximum.x - minimum.x + 1);
            int height = (int) (maximum.y - minimum.y + 1);

            char[][] arr = new char[height][width];
            for (char[] row : arr) {
                Arrays.fill(row, '.');
            }

            for (Point point : points) {
                int x = (int) (point.x - minimum.x);
                int y = (int) (maximum.y - point.y);
                arr[y][x] = '*';
            }

            String[] result = new String[arr.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = new String(arr[i]);
            }

            return result;
        }



    }
}
