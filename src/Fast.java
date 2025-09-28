import java.util.Arrays;
import java.util.Scanner;

public class Fast {
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


    //план (1-опорна точка, 2-масив з інших точок,
    // 3 - відсортувати їх за нахилом до опорної
    // 4 - знайти групи з однаковим нахилом)
    public static void findLines(Point[] points) {
        int n = points.length;

        for (int i = 0; i < n; i++) {
            Point p = points[i]; //нехай опорна

            Point [] others = new Point[n-1];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j != i){//без p
                    others[index++] = points[j];
                }
            }

            Arrays.sort(others, p.SLOPE_ORDER);

            for (int j = 0; j < others.length; j++) {
                double currentSlope = p.slopeTo(others[j]);
                int count = 1;

                while (j+count < others.length && p.slopeTo(others[j + count]) == currentSlope) {
                    count++;
                }

                if (count >= 3) {
                    Point[] linePoints = new Point[count + 1];
                    linePoints[0] = p;//опорна

                    for (int k = 0; k < count; k++) {
                        linePoints[k + 1] = others[j+k];
                    }

                    Arrays.sort(linePoints);

                    for (int k = 0; k < linePoints.length; k++) {
                        System.out.print(linePoints[k]);
                        if (k < linePoints.length - 1) {
                            System.out.print(" -> ");
                        }
                    }
                    System.out.println();
                }


                j+=count;
            }


        }
    }
}
