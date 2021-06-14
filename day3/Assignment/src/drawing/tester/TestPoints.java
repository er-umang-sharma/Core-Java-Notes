package drawing.tester;

import drawing.basic.Point2D;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestPoints {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of points you want to take:");
            Point2D[] points = new Point2D[sc.nextInt()];

            for (int i=0; i<points.length; i++) {
                System.out.println("Enter the x and y co-ordinates for point no. " + (i+1));
                points[i] = new Point2D(sc.nextDouble(), sc.nextDouble());
            }

            System.out.println("The points given as input are:");
            for (Point2D point: points) {
                System.out.println(point + "\n");
            }

            System.out.println("Enter the co-ordinates 1st point and 2nd point");
            Point2D point1 = new Point2D(sc.nextDouble(), sc.nextDouble());
            Point2D point2 = new Point2D(sc.nextDouble(), sc.nextDouble());

            System.out.println("Are the two points given above same: " + point1.isEqual(point2));

            System.out.println("The distance between the two points is: " + point1.calcDistance(point2));
        } catch (InputMismatchException e) {
            System.out.println("The data entered is not a valid input.");
        }
    }
}
