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
    150
    200
    300
    400
    800
   1600
   3200
   6400
  12800


Brute:    ~

Sorting:  ~




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



/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/



/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/




/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
