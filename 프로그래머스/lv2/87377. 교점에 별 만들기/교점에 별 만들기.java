import java.util.ArrayList;
import java.util.List;


class Solution {
    private final static String EMPTY = ".";
    private final static String STAR = "*";

    public String[] solution(int[][] line) {
        List<String> answer = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        List<long[]> coordinates = new ArrayList<>();

        for (int i = 0; i < line.length - 1; i++) {
            int[] l1 = line[i];
            for (int j = i + 1; j < line.length; j++) {
                int[] l2 = line[j];
                long[] coordinate = getIntegerCoordinate(l1, l2);
                if (coordinate != null) {
                    coordinates.add(coordinate);
                    minX = Long.min(coordinate[0], minX);
                    maxX = Long.max(coordinate[0], maxX);
                    minY = Long.min(coordinate[1], minY);
                    maxY = Long.max(coordinate[1], maxY);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (long y = maxY; y > minY - 1; y--) {
            for (long x = minX; x < maxX + 1; x++) {
                long finalX = x;
                long finalY = y;
                if (coordinates.stream().anyMatch(coordinate -> coordinate[0] == finalX && coordinate[1] == finalY)) {
                    sb.append(STAR);
                }
                else {
                    sb.append(EMPTY);
                }
            }
            answer.add(sb.toString());
            sb.delete(0, sb.length());
        }

        return answer.toArray(new String[0]);
    }

    private long[] getIntegerCoordinate(int[] l1, int[] l2) {
        double a = l1[0];
        double b = l1[1];
        double e = l1[2];
        double c = l2[0];
        double d = l2[1];
        double f = l2[2];

        if (a * d == b * c) {
            return null;
        }

        double x = (b * f  - e * d) / (a * d - b * c);
        double y = (e * c - a * f) / (a * d - b * c);

        if (isInteger(x) && isInteger(y)) {
            return new long[]{(long) x, (long) y};
        }

        return null;
    }

    private boolean isInteger(double d) {
        return d == (long) d;
    }
}
