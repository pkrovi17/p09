//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Hobbemoun Iterator class
// Course:   CS 300 Spring 2025
//
// Author:   Pranav Krovi
// Email:    pkrovi@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:    x
// Partner Email:   x
// Partner Lecturer's Name: x
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   x Write-up states that pair programming is allowed for this assignment.
//   x We have both read and understand the course Pair Programming Policy.
//   x We have registered our team prior to the team registration deadline.
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         Mouna Kacem
//                  javadocs helped understand which methods to implement
//                  lecture slides showed how iterator class can be used
// Online Sources:  W3 Schools
//                  - https://www.w3schools.com/java/java_iterator.asp
//
///////////////////////////////////////////////////////////////////////////////
// imports
import java.util.Iterator;
import java.util.NoSuchElementException;
/*
 * This class implements the Iterator interface for the Hobbemoun class.
 * It allows for iterating over the Hobbemoun objects in a HobbemounTree.
 */
public class HobbemounIterator extends Object implements Iterator<Hobbemoun> {
    // Instance variables
    private Hobbemoun nextHobbemoun; // The next Hobbemoun to be returned by the iterator
    private HobbemounTree tree; // The HobbemounTree that this iterator is iterating over
    /*
     * Constructor for the HobbemounIterator class.
     * Initializes the iterator with the given HobbemounTree
     * Sets the nextHobbemoun to the weakest Hobbemoun in the tree.
     * @param tree the HobbemounTree to iterate over
     */
    public HobbemounIterator(HobbemounTree tree) {
        this.tree = tree;
        this.nextHobbemoun = tree.getWeakest();
    }
    /*
     * Returns if there is a next Hobbemoun in the iteration.
     * If there are no more Hobbemoun, it returns false
     * @return true if there is another, false otherwise
     * @Override hasnext() method from the Iterator interface
     */
    @Override
    public boolean hasNext() {
        return nextHobbemoun != null;
    }
    /*
     * Returns the next Hobbemoun in the iteration.
     * If there are no more Hobbemoun, it throws a NoSuchElementException.
     * @return the next Hobbemoun in the iteration
     * @Override next() method from the Iterator interface
     * @throws NoSuchElementException if there are no more Hobbemoun in the iteration
     */
    @Override
    public Hobbemoun next() {
        // Cite: W3 schools
        // https://www.w3schools.com/java/java_iterator.asp
        // helped understand how to implement the next() method
        // Check if there is a next Hobbemoun
        if (!hasNext()) {
            throw new NoSuchElementException("No more Hobbemoun in the iterator.");
        }
        Hobbemoun current = nextHobbemoun;
        nextHobbemoun = tree.next(current);
        return current;
    }
}