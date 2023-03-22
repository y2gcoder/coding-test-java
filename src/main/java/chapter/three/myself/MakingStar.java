package chapter.three.myself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 삼각 달팽이
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
public class MakingStar {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};

        String[] result = solution.solution(line);
        System.out.println("result = " + result);
    }

    private static class Solution {
        public String[] solution(int[][] line) {
            List<Point> points = new ArrayList<>();
            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    int[] lineOne = line[i];
                    int[] lineTwo = line[j];
                    Point point = getIntersection(lineOne[0], lineOne[1], lineTwo[0], lineTwo[1], lineOne[2], lineTwo[2]);
                    if (point != null) {
                        points.add(point);
                    }
                }
            }
            // 0 - minX / 1 - maxX / 2 - minY / 3 - maxY
            int[] minMaxXy = getMinMaxXy(points);

            return paintStars(minMaxXy, points);
        }

        private Point getIntersection(int a, int b, int c, int d, int e, int f) {
            if ((a * d - b * c) == 0) {
                return null;
            }

            int x = (b * f - e * d) / (a * d - b * c);
            int y = (e * c - a * f) / (a * d - b * c);

            if ((a * x + b * y + e) != 0) {
                return null;
            }
            if ((c * x + d * y + f) != 0) {
                return null;
            }

            return new Point(x, y);
        }

        private int[] getMinMaxXy(List<Point> points) {
            int[] result = new int[4];
            result[0] = 500;
            result[1] = -500;
            result[2] = 500;
            result[3] = -500;

            for (Point point : points) {
                if (result[0] > point.getX()) {
                    result[0] = point.getX();
                }
                if (result[1] < point.getX()) {
                    result[1] = point.getX();
                }
                if (result[2] > point.getY()) {
                    result[2] = point.getY();
                }
                if (result[3] < point.getY()) {
                    result[3] = point.getY();
                }
            }

            return result;
        }

        private String[] paintStars(int[] minMaxXy, List<Point> points) {
            int minX = minMaxXy[0];
            int maxX = minMaxXy[1];
            int minY = minMaxXy[2];
            int maxY = minMaxXy[3];

            String[] result = new String[maxY - minY + 1];
            Arrays.fill(result, "");

            for (int i = 0; i <= maxY - minY; i++) {
                for (int j = 0; j <= maxX - minX; j++) {
                    if (points.contains(new Point(j + minX, -i  + maxY))) {
                        result[i] += "*";
                    } else {
                        result[i] += ".";
                    }
                }
            }

            return result;
        }


        private static class Point {
            private final int x;
            private final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }


    }
}
