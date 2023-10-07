import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.Out;

public class Fast {
    private final ResizingArrayQueue<Iterable<Point>> lineSegments;

    public Fast(Point[] points) {
        lineSegments = new ResizingArrayQueue<>();
        findLineSegments(points);
    }

    private void findLineSegments(Point[] points) {
        Arrays.sort(points);
        int N = points.length;
        //ResizingArrayQueue<Point> candidatePoints = new ResizingArrayQueue<>();
        //Point[] candidatePoints = new Point[N];
        for (int p = 0; p < N-1; p++) {
            Point[] candidatePoints = new Point[N - (p + 1)]; //the list will never be longer than the rest of the points available
            int startIndex = p + 1;
            for (int i = startIndex; i < N; i++) {
                candidatePoints[i - startIndex] = points[i];
            }
            Arrays.sort(candidatePoints, points[p].SLOPE_ORDER);

            double slope = points[p].slopeTo(candidatePoints[0]);
            double compareSlope = 0;
            int count = 0;
            ResizingArrayQueue<Point> indexes = new ResizingArrayQueue<>();
            indexes.enqueue(points[p]);
            for (int j = 0; j < candidatePoints.length; j++) {
                compareSlope = points[p].slopeTo(candidatePoints[j]);
                if (slope == compareSlope) {
                    count++;
                    indexes.enqueue(candidatePoints[j]);
                }
                if (j + 1 == candidatePoints.length && count >= 3) {
                    lineSegments.enqueue(Arrays.asList(candidatePoints));
                }

            }
        }
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public Iterable<Iterable<Point>> segments() {
        return lineSegments;
    }

    public static void main(String[] args) {
        // Read input points and create fast object

        Out out = new Out();
        In in = new In();
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        Fast fast = new Fast(points);

        // Output the number of line segments and the line segments
        out.println(fast.numberOfSegments());
        for (Iterable<Point> segment : fast.segments()) {
            boolean first = true;
        
            for (Point p : segment) {
                if (!first) {
                    out.print(" -> ");
                }
                out.print(p);
                first = false;
            }
        
            out.println();
        }
    }
}
