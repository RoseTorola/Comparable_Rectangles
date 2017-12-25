/**
Rosemary Torola
**/
import java.util.Arrays;

public class RectangleMatch{

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

    Arrays.sort(rectarr); //sorts rectarr
    //System.out.println(rectarr[4].getPerimeter());
    //when uncommented it shows that the mathcing rectangle is at location 4

    Rectangle target = new Rectangle(8,5); //creates a new rectangle object, we will search the array to see if there is one that matches

    int indexBig = binarySearch(rectarr, target);//calls binarySearch on the array and the target rectangle

    System.out.println(indexBig);
    if (indexBig >= 0)
      System.out.println("the desired rectangle is at location " + indexBig);
    else
      System.out.println("there is no such rectangle in the array.");
  }


  public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x){
    return binaryHelp(a, x, 0, a.length-1);
  }//this method is called from the main method with the array and the target rectangle
   //it calls the binary help method and sends it the array, the target, and a start and stop value, which will seearch recursively for the rectangle
   //returns an integer WHATTTT


  private static <AnyType extends Comparable<AnyType>> int binaryHelp(AnyType [] a, AnyType target, int start, int stop){

    int mid = (start + stop)/2;
    System.out.println("mid: " + mid);

    if(start > stop) //the target is not in the array
      return -1;

    if (a[mid].compareTo(target) < 0)//the target is > mid
      return binaryHelp(a, target, mid + 1, stop);
    else if (a[mid].compareTo(target) > 0) //if target is less than mid
      return binaryHelp(a, target, start, mid -1);
    else //target is at mid
      return mid;

    }//end of binaryHelp

}//end of class
