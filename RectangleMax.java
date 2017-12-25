/**
Rosemary Torola
**/
import java.util.*;

public class RectangleMax{

  public RectangleMax(){

  }//constructor

  public static void main(String[] args){
    Rectangle[] rectarr = new Rectangle[6];
    rectarr[0] = new Rectangle(3,6);
    rectarr[1] = new Rectangle(4,6);
    rectarr[2] = new Rectangle(8,5);
    rectarr[3] = new Rectangle(2,10);
    rectarr[4] = new Rectangle(8,8);
    rectarr[5] = new Rectangle(1,1);
    //series of assignment statements hardcoding the rectangles in the array
    //these are calls to the constructor of the Rectangle Class

    Rectangle maxRect = findMax(rectarr);
    int length = maxRect.getLength();
    int width = maxRect.getWidth();
    int perimeter = (length + width)*2;
    System.out.println("The largest Rectangle is: " + length + " by " + width + ", perimeter of " + perimeter);
  }//creates an array of rectangle objects
  //calls the provided findMax method


  public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] arr){
    int maxIndex =0;
    for (int i= 1; i< arr.length; i++)
      if ( arr[i].compareTo(arr[maxIndex]) > 0)
        maxIndex = i;
      return arr[maxIndex];
  }//this method calls the compareTo method in the rectangle class to compare the Rectangles in the array and find the biggest one

}//end of class RectangleMax
