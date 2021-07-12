package by.zhurauleu.task4_1_1;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Line> lines = new ArrayList();
        List<Integer> points = new ArrayList();
        int linesCount = input.nextInt();
        for (int i = 0; i < linesCount; i++) {
            lines.add(new Line(input.nextInt(), input.nextInt()));
        }
        Collections.sort(lines);
        while (lines.size() != 0) {
            int point = lines.get(0).endPoint;
            points.add(point);
            lines.removeIf(line -> line.isContain(point));
        }
        System.out.println(points.size());
        for (Integer point : points) {
            System.out.print(point + " ");
        }
    }
}

class Line implements Comparable<Line> {
    int startPoint;
    int endPoint;


    @Override
    public int compareTo(Line o) {
        return this.endPoint - o.endPoint;
    }

    Line(int start, int end) {
        startPoint = start;
        endPoint = end;
    }

    boolean isContain(int a) {
        boolean result = false;
        if (a >= startPoint && a <= endPoint) {
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "start:" + startPoint + ", end:" + endPoint;
    }
}
