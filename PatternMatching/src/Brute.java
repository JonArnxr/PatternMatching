import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.Out;

public class Brute {
    private final ResizingArrayQueue<Iterable<Point>> lineSegments;

    public Brute(Point[] points) {
        lineSegments = new ResizingArrayQueue<>();
        findLineSegments(points);
    }

    private void findLineSegments(Point[] points) {
        Arrays.sort(points);
        int N = points.length;

        for (int p = 0; p < N - 3; p++) {
            for (int q = p + 1; q < N - 2; q++) {
                for (int r = q + 1; r < N - 1; r++) {
                    for (int s = r + 1; s < N; s++) {
                        Point[] candidatePoints = {points[p], points[q], points[r], points[s]};
                        double slope1 = points[p].slopeTo(points[q]);
                        double slope2 = points[p].slopeTo(points[r]);
                        double slope3 = points[p].slopeTo(points[s]);

                        if (slope1 == slope2 && slope1 == slope3) {
                            Arrays.sort(candidatePoints);
                            lineSegments.enqueue(Arrays.asList(candidatePoints));
                        }
                    }
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
        // Read input points and create Brute object

        Out out = new Out();
        In in = new In();
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        Brute brute = new Brute(points);

        // Output the number of line segments and the line segments
        System.out.println("Number of line segments: " + brute.numberOfSegments());
        for (Iterable<Point> segment : brute.segments()) {
            for (Point p : segment) {
                out.print(p + " -> ");
            }
            out.println();
        }
    }
}
