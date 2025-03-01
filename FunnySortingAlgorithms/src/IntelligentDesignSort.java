import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Any list is sorted for a reason. If you perform operations on a sorted list, you will destroy this perfection.
 * O(1)
 */
public class IntelligentDesignSort {
    public static void main(String[] args) {
        // Ask the user for an unsorted list of integers
        String input = JOptionPane.showInputDialog("Enter a list of integers separated by spaces:");
        // Split the input into an array of strings
        String[] inputArray = input.split(" ");
        // Create an array of integers with the same length as the input array
        List<Integer> intArray = new ArrayList<>();
        // Convert each string in the input array to an integer and add it to the integer array
        for (String s : inputArray) {
            intArray.add(Integer.parseInt(s));
        }
        System.out.println("The list you gave me (" + intArray + ") is sorted in a specific way that humans cannot understand. Performing operations on this list will destroy this perfection.");
    }
}
