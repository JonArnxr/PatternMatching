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
        Point[] slopeOrdered = new Point[N];
        //make a copy of array
        for (int i = 0; i < N; i++) {
            slopeOrdered[i] = points[i];          
        }
        //ResizingArrayQueue<Point> candidatePoints = new ResizingArrayQueue<>();
        //Point[] candidatePoints = new Point[N];
        for (int i = 0; i < N; i++) {
            ResizingArrayQueue<Point> candidatePoints = new ResizingArrayQueue<>();
            Point p = points[i];
            Arrays.sort(slopeOrdered);
            Arrays.sort(slopeOrdered, p.SLOPE_ORDER);
            int j = 1;
            while (j < N -1) {
                Point q = slopeOrdered[j];
                double slope = p.slopeTo(q);
                if (slope == p.slopeTo(slopeOrdered[j+1])) {
                    int index = j;
                    int indexstop = j+1;
                    for (int k = j + 1; k < N; k++) {
                        if (slope == p.slopeTo(slopeOrdered[k])) {
                            indexstop = k;
                        }
                        else {
                            break;
                        }
                    }

                    if ((indexstop - index) >= 2 && (p.compareTo(slopeOrdered[index]) < 0)) {
                        candidatePoints.enqueue(p);
                        for (int a = index; a <= indexstop; a++) {
                            candidatePoints.enqueue(slopeOrdered[a]);
                        }
                        lineSegments.enqueue(candidatePoints);
                    }
                    j = indexstop + 1;

                    }
                
                else {
                    j++;
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
        In in = new In("test1600.txt");
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
