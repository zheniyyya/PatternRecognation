import java.util.Arrays;
import java.util.Scanner;

public class Brute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of points:");
        int n = sc.nextInt();
        System.out.println("Enter the coordinates:");
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            System.out.println("x: ");
            int x = sc.nextInt();
            System.out.println("y: ");
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        findLines(points);
        sc.close();

    }

    public static void findLines(Point [] points) {
        int n = points.length;

        for (int p = 0; p < n; p++) {
            for (int q = p + 1; q < n; q++) {
                for (int r = q + 1; r < n; r++) {
                    for (int s = r + 1; s < n; s++) {
                        if (areCollinear(points[p], points[q], points[r], points[s])){
                            Point[] line = {points[p], points[q], points[r], points[s]};

                            Arrays.sort(line);
                            System.out.println(line[0] + "->" + line[1] + "->" + line[2]+"->" + line[3]);
                        }
                    }
                }
            }
        }

    }



    //точки на одній прямій -> кут нахилу має бути однаковим
    public static boolean areCollinear(Point p, Point q, Point r, Point s) {
        return p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s);
    }


}
