package Homeworks.homework4;

import java.util.*;

public class homework_4 {
    public static void main(String[] args) {

        var mg = new MapGenerator();
        var lee = new WaveAlgorithm(mg.getMap());
        lee.Colorize(new Point2D(1, 1));
        var res = new MapPrinter().rawData(mg.getMap());
        System.out.println(res);

    }
}
class Point2D {
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MapGenerator {
    int[][] map;

    public MapGenerator() {

        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 0, -1, -1, -1, -1, 0, 0, -1, -1, -1, -1 },
                { -1, 0, -1, -1, -1, -1, -1, 0, -1, 0, -1, -1 },
                { -1, 0, 0, -1, 0, -1, -1, -1, 0, 0, -1, -1 },
                { -1, -1, 0, -1, -1, -1, 0, -1, -1, 0, -1, -1 },
                { -1, 0, 0, 0, -1, 0, 0, 0, -1, 0, -1, -1 },
                { -1, -1, 0, -1, -1, -1, 0, 0, -1, -1, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1 },
                { -1, 0, 0, 0, -1, -1, -1, -1, -1, 0, 0, -1 },
                { -1, 0, 0, 0, -1, -1, 0, 0, -1, -1, -1, -1 },
                { -1, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

}

class MapPrinter {
    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}

class WaveAlgorithm {
    int[][] map;

    public WaveAlgorithm(int[][] map) {
        this.map = map;
    }

    public void Colorize(Point2D starPoint) {
        Queue<Point2D> queue = new LinkedList<Point2D>();
        queue.add(starPoint);
        map[starPoint.x][starPoint.y] = 1;

        while (queue.size() != 0) {
            Point2D p = queue.remove();
            
            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }

            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }

            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }

            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }

        }
    }
}
