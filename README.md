# Comparable_Rectangles
Programs that utilize a comparable rectangle class to make simple comparisons.

FindMax.java:

The rectangle class is a comparable class that allows Problem1.java to call the compareTo method from the findMax method in order to find the largest perimeter rectangle.
I hardcoded the rectangles into an array of rectangle objects
Once the findmax loop has found the largest rectangle, it returns the index of that rectangle to the main class and the main class prints out to the user


FindMatch.java:

This class also uses the rectangle class.
Again, I harcoded an array of rectangles, then I sorted them using the arrays.sort method
The provided binary search method is called, which in turn calls the binary helper method.
The binary helper method calls itself recursively as it searches through the array of sorted rectangles to find one that matches.
It calls the rectangle compareTo method in order to compare rectangles and find the one that is the same.
once it does, the rectangle index is returned to the binary search method, which passes it to the main method
If no rectangle is found to match, an error message is printed
Otherwise, the user is told the location of the matching rectangle
