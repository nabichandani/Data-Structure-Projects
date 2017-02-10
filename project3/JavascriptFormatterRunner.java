/**
 * Navin Abichandani
 * ID-110313627
 * Homework #3
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project3;
import java.util.Scanner;
public class JavascriptFormatterRunner {
/**
 * The main method is the driver class.  It contains the user 
 * interface and applies the format method.
 */
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Javascript Formatter.");
		System.out.println("Enter the filename: ");
		String text = input.nextLine();
		JavascriptFormatter test = new JavascriptFormatter();
		String output = test.format(text);
		System.out.println(output);
		System.out.println("--Thank you for making your code readable!---");
	}
}
