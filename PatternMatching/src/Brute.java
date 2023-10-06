import java.lang.reflect.Array;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;

public class Brute {
    
    public static void main(String[] args) {
        //modified code from PointPlotter.java:
        //StdDraw.setXscale(0, 32768);
        //StdDraw.setYscale(0, 32768);
        StdDraw.setXscale(0, 30);
        StdDraw.setYscale(0, 30);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01); 

        Out out = new Out();

        // read in the input
        //String filename = args[0];
        String filename = "test.txt";
        In in = new In(filename);
        int N = in.readInt();
        Point[] pointArr = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            pointArr[i] = p;
            p.draw();
            StdDraw.show(0);
        }

        // Arrays to store collinear points sets
        Point[][] collinearSets = new Point[N][4];
        int count = 0;

        // Iterate through all combinations of 4 points
        for (int p = 0; p < N - 3; p++) {
            for (int q = p + 1; q < N - 2; q++) {
                for (int r = q + 1; r < N - 1; r++) {
                    for (int s = r + 1; s < N; s++) {
                        Point point_p = pointArr[p];
                        Point point_q = pointArr[q];
                        Point point_r = pointArr[r];
                        Point point_s = pointArr[s];

                        // Check if the points are collinear
                        if (point_p.slopeTo(point_q) == point_p.slopeTo(point_r) &&
                            point_p.slopeTo(point_q) == point_p.slopeTo(point_s)) {
                            // Store collinear points set
                            Point[] collinearSet = {point_p, point_q, point_r, point_s};
                            // Sort the collinear set to match the desired output
                            Arrays.sort(collinearSet);
                            collinearSets[count++] = collinearSet;
                        }
                    }
                }
            }
        }

        // Sort the collinear sets array
        Arrays.sort(collinearSets, 0, count, (a, b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        // Output the sorted collinear sets
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(collinearSets[i][j]);
                if (j < 3) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    } 
}
