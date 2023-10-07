import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class Fast {
    public static void main(String[] args) {
        In in = new In("test.txt"); // Replace "input.txt" with your input file name
        int N = in.readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        findCollinearSegments(points);
    }

    public static void findCollinearSegments(Point[] points) {
        Arrays.sort(points); // Sort points in their natural order

        for (int i = 0; i < points.length - 3; i++) {
            Point p = points[i];
            Arrays.sort(points, i + 1, points.length, p.SLOPE_ORDER); // Sort points based on slopes with p

            int count = 1;
            double slope = p.slopeTo(points[i + 1]);

            int startIdx = -1;
            int endIdx = -1;

            for (int j = i + 2; j < points.length; j++) {
                double currentSlope = p.slopeTo(points[j]);

                if (Double.compare(slope, currentSlope) == 0) {
                    count++;

                    if (startIdx == -1) {
                        startIdx = j - 1;
                    }

                    if (count >= 3 && j == points.length - 1) {
                        endIdx = j;
                        printCollinearSegment(points, startIdx, endIdx, p);
                    }
                } else {
                    if (count >= 3) {
                        endIdx = j - 1;
                        printCollinearSegment(points, startIdx, endIdx, p);
                    }
                    slope = currentSlope;
                    count = 1;
                    startIdx = -1;
                    endIdx = -1;
                }
            }
        }
    }

    private static void printCollinearSegment(Point[] points, int start, int end, Point origin) {
        Point[] collinearPoints = new Point[end - start + 2];
        collinearPoints[0] = origin;

        for (int k = start; k <= end; k++) {
            collinearPoints[k - start + 1] = points[k];
        }

        Arrays.sort(collinearPoints); // Sort collinear points by natural order
        boolean first = true;

        for (Point point : collinearPoints) {
            if (!first) {
                StdOut.print(" -> ");
            }
            StdOut.print(point);
            first = false;
        }
        StdOut.println();
    }
}
