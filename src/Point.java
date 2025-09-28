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




    }

