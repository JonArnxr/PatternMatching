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
    
        ResizingArrayQueue<Point> segmentPoints = new ResizingArrayQueue<>();
        for (int p = 0; p < points.length - 3; p++) {
            Arrays.sort(points, p + 1, points.length, points[p].SLOPE_ORDER);
            segmentPoints.enqueue(points[p]);
    
            for (int q = p + 1; q < points.length - 2; q++) {
                double slopePQ = points[p].slopeTo(points[q]);
    
                if (slopePQ != points[p].slopeTo(points[q + 1])) {
                    if (segmentPoints.size() >= 3) {
                        Point[] segmentArray = new Point[segmentPoints.size()];
                        int i = 0;
                        for (Point point : segmentPoints) {
                            segmentArray[i++] = point;
                        }
                        lineSegments.enqueue(Arrays.asList(segmentArray));
                    }
                    segmentPoints = new ResizingArrayQueue<>();
                }
                segmentPoints.enqueue(points[q]);
            }
    
            if (segmentPoints.size() >= 3) {
                Point[] segmentArray = new Point[segmentPoints.size()];
                int i = 0;
                for (Point point : segmentPoints) {
                    segmentArray[i++] = point;
                }
                lineSegments.enqueue(Arrays.asList(segmentArray));
            }
            segmentPoints = new ResizingArrayQueue<>();
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
        In in = new In("test3.txt");
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
