import java.lang.reflect.Array;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Quick;

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
            //out.println(pointArr[i].x);
            StdDraw.show(0);
        }
        Arrays.sort(pointArr);
        Point[] bla = new Point[N];
        int count = 0;
        for (int p = 0; p < pointArr.length; p++) {
            for (int q = 0; q < pointArr.length; q++) {
                if (q == p) {
                    continue;
                }
                for (int r = 0; r < pointArr.length; r++) {
                    if ((r == q) || (r == q)) {
                        continue;
                    } 
                    for (int s = 0; s < pointArr.length; s++) {
                        if ((s == r) || (s == q) || (s == p)) {
                            continue;
                        }
                        //put each point in to a variable to make the code more readable
                        Point point_p = pointArr[p];
                        Point point_q = pointArr[q];
                        Point point_r = pointArr[r];
                        Point point_s = pointArr[s];

                        if (point_p.slopeTo(point_q) == point_r.slopeTo(point_s)) {
                            if (point_p.slopeTo(point_r) == point_q.slopeTo(point_s)) {
                                if (point_p.slopeTo(point_s) == point_q.slopeTo(point_r)) {
                                    if (point_p.compareTo(point_q) >= 0) {
                                        if (point_q.compareTo(point_r) >= 0) {
                                            if (point_r.compareTo(point_s) >= 0) {
                                                //out.println("p:" + point_p + "q:" + point_q + "r:" + point_r + "s:" + point_s);
                                                Point[] toPrint = new Point[4];
                                                toPrint[0] = point_p;
                                                toPrint[1] = point_q;
                                                toPrint[2] = point_r;
                                                toPrint[3] = point_s;
                                                Arrays.sort(toPrint);
                                                //bla[j] = 
                                                for (int i = 0; i < toPrint.length; i++) {
                                                    out.println(toPrint[i]);
                                                }
                                                out.println("----------------------");
                                                //out.println(toPrint);
                                                point_p.drawTo(point_s);
                                                point_q.drawTo(point_r);
                                                StdDraw.show(0);
                                            } 
                                        }

                                    }
                                    //out.println("p:" + point_p + "q:" + point_q + "r:" + point_r + "s:" + point_s);
                                    //point_p.drawTo(point_s);
                                    //point_q.drawTo(point_r);
                                    //StdDraw.show(0);
                                }
                            }
                        }


                    }
                }
            }
        }
    } 
}
