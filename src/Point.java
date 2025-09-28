    import java.util.Comparator;

    public class Point implements Comparable<Point> {

        // порівняти точки за градієнтом до цієї точки
        public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double slope1 = slopeTo(p1);
                double slope2 = slopeTo(p2);
                return Double.compare(slope1, slope2);
            }
        };
        private final int x, y;


        // створює точку (x, y)
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        // малює точку
        public void draw() {}

        // малює відрізок між цією точкою і that точкою
        public void drawTo(Point that) {}


        // string подання
        public String toString(){
            return "(" + x + ", " + y + ")";
        }


        // чи ця точка лексикографічно менша за that точку?
        public int compareTo(Point that) {
            if (this.y != that.y) {
                return Integer.compare(this.y, that.y);
            }
            return Integer.compare(this.x, that.x);
        }

        // нахил між цією і that точкою
        public double slopeTo(Point that) {
            if (this.x == that.x && this.y == that.y) {
                return Double.NEGATIVE_INFINITY; // Вироджений сегмент
            }
            if (this.x == that.x) {
                return Double.POSITIVE_INFINITY; // Вертикальна лінія
            }
            if (this.y == that.y) {
                return 0.0; // Горизонтальна лінія
            }
            return (double) (that.y - this.y) / (that.x - this.x);
        }


        public static void main(String[] args) {
            Point origin = new Point(0, 0);

            Point horizontal = new Point(5, 0);   // нахил
            Point slope1 = new Point(2, 2);       // нахил 1
            Point slope2 = new Point(1, 3);       // нахил 3
            Point vertical = new Point(0, 5);     // нахил нескінченність
            Point same = new Point(0, 0);         // нахил -нескінченність


            int SLOPE_ORDER_result1 = origin.SLOPE_ORDER.compare(horizontal, slope1);
            System.out.println(SLOPE_ORDER_result1);

            int SLOPE_ORDER_result2 = origin.SLOPE_ORDER.compare(vertical, same);
            System.out.println(SLOPE_ORDER_result2);

            int SLOPE_ORDER_result3 = origin.SLOPE_ORDER.compare(slope2, slope1);
            System.out.println(SLOPE_ORDER_result3);

            int SLOPE_ORDER_result4 = origin.SLOPE_ORDER.compare(origin, horizontal); //origin - ироджений сегмент
            System.out.println(SLOPE_ORDER_result4);


        }

    }

