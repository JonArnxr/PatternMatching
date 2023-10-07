/**********************************************************************
 *  Pattern Recognition readme.txt template
 **********************************************************************/

Name:             Sæþór Berg Ásgeirsson
Login:            saethor22@ru.is

Partner name:     Jón Arnar Snorrason
Partner login:    jonarn22@ru.is

Hours to complete assignment (optional):  around 20 hours



/**********************************************************************
 *  Step 1.  Explain *briefly* how you implemented brute force.
 *           Describe how you implemented compareTo() and the
 *           slopeTo() methods in the Point data type.
 **********************************************************************/
When using the Brute method we iterated through every combination of 4 points
in the input file and compared if all of the slopes were the same.
for each combination.
the slopeTo() method was used to find the slope between two points.
we used the formula to find the slopes bbetween two points
compareTo() we compared the y values to eachother and if they were the
same we compared the x of the two points so only if the two points were 
exactly the same would the method return 0.


/**********************************************************************
 *  Step 2.  Explain *briefly* how you implemented the sorting solution.
 *           What steps did you do to avoid outputting permutations
 *           and subsegments?
 **********************************************************************/
we always sorted before going through the iteration using the comparator

in Brute we limited the amount of points that form a line to 4 and we
never used the same point for p (the first point) again. as can be seen in 
our chain of for loops.

in Fast we ordered the list using SLOPE_ORDER, so that way for each point p
to we iterated throu the index of this list and when we found that there 
were no longer any points with the same slope we stopped and added the indexes
to the lineSegments. and then we continued on for the next point. now this could
potentially make many lists that have some of the same points always skipping the
first point through the next iteration. but that was okay for the fast.java


/**********************************************************************
 *  Empirical    Fill in the table below with actual running times in
 *  Analysis     seconds when reasonable (say 180 seconds or less).
 *               You can round to the nearest tenth of a second.
 *
 *  Estimate (using tilde notation) the running time (in seconds) of
 *  your two main functions as a function of the number of points N.
 *
 *  Explain how you derive any exponents.
 **********************************************************************/

    
      N       brute       sorting
 ---------------------------------
    150   0.297               0.012
    200   0.79                0.019
    300   3.565               0.034
    400   11.262              0.084
    800   186.806             0.353
   1600   3101.72(approx)     0.863
   3200   51419.5(approx)     2.705
   6400   851693.81(approx)   11.077
  12800   14103389(approx)    45.66

we calculate T(800)/T(400) = 16.58
so T(1600) = 16.58 * 186.806 which makes sense since the amount is being doubled (2^4)
and so on..


Brute: ~ N^4   

Sorting:  ~ N^2 Log N




/**********************************************************************
 *  Theoretical   Give the order of growth of the worst-case running
 *                time of your programs as a function of N. Justify
 *                your answer briefly.
 **********************************************************************/

Brute:    O(N^4)         In the program we are checking 4 points at a time,
                         by doing that we have a nested loop structure that checks combinations of 4 points.
                         That leads to complexity of O(N^4).
          

Sorting:  O(N^2 log N)   Sorting usually has the time complexity of O(N log N) when using efficient algorithms.
                         Since we are applying sorting to each of the N points, the overall time complexity
                         becomes O(N^2 log N).



/**********************************************************************
 *  Known bugs / limitations. For example, if your program prints
 *  out different representations of the same line segment when there
 *  are 5 or more points on a line segment, indicate that here.
 **********************************************************************/
yes, I stated above. when we get many points that form a line the first combination
holds the first p (our point in which we are looking at all other slopes) gets added 
to the listthen when going to the next point that is in the same line as before it 
finds the rest of the same points and adds them to an array that gets added to the 
lineSegments and so on so we do get n-4 arrays forming the same linefor n points 
that form a line.


/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/
We used the internet, different forums for help on how to approach the problems of
this assignment i.e. chatGPT, youtube, Coding Forums. to divide the entire
problem into smaller problems to get a better understanding of what to do.



/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
The use of arrays in this assignment.
we believe the use of arraylists from java util should be allowed
it added unnecessary complexity to use only arrays that need a 
predetermined size. we ended up using resizablearrayqueue from algs4
but even with that it posed unnecessary complexity in how to
iterate through that.



/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
the description for this assignment was very poor. we are given nothing
to work with, and we have no idea how the autograder works. so we have no idea
on how our soloutions should be implemented. and the descriptions themselves for each
problem are not very clear. it was not clear if we should have different combinations
forming the same line. it was not clear if the subarrays returned from segments()
should return always arrays of length 4. we wasted a lot of time trying
to understand what was being asked of us. 

IMPORTANT!!!
please let Magnús know that the description should be updated and that we are
unsatisfied with this assignment.