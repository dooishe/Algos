package secondSem.lections.twoDotThree.сonvexHull;

import java.util.List;

public class Main {
  public static void main(String[] args) {

  }

  public static class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return this.x;
    }

    public int getY() {
      return this.y;
    }

    public int minByXY(List<Point> points) {
      int min = 0;
      Point mp = points.get(0);
      for (int i = 1; i < points.size(); i++) {
        Point p = points.get(i);
        if ((p.getX() < mp.getX()) ||
            (p.getX() == mp.getX() && p.getY() < mp.getY())) {
          min = i;
          mp = p;
        }
      }
      return min;
    }
  }

  

}
