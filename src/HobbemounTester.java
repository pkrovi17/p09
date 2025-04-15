// TODO Add Complete File Header

import java.util.NoSuchElementException;
import java.util.Iterator;

// TODO Add javadoc class header
public class HobbemounTester {

  /**
   * Tests the compareTo method when comparing Hobbemouns with different type values
   *
   * @return true if test passes, false otherwise
   */
  public static boolean testCompareToByType() {
    return false; // TODO: implement this test

  }

  /**
   * Tests the compareTo method when comparing Hobbemouns with same type values but different names
   *
   * @return true if test passes, false otherwise
   */
  public static boolean testCompareToByName() {
    return false; // TODO: implement this test

  }

  public static boolean testCompareToSame() {
    return false; // TODO: implement this test

  }

  /**
   * Tests that isEmpty returns true for an empty tree and false for a non-empty tree.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIsEmpty() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that size returns the correct number of Hobbemoun objects in the tree.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSize() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that isValidBST returns true for an empty BST.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIsValidBSTEmpty() {
    return HobbemounTree.isValidBST(null);
  }

  /**
   * Tests that isValidBST returns true for a valid BST. Should use a tree with depth > 2.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIsValidBSTValid() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that isValidBST returns false for an invalid BST. Should use a tree with depth > 2 and
   * include a case where the left subtree contains a node greater than the right subtree.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIsValidBSTInvalid() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that insert throws IllegalArgumentException when given null
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testInsertNullException() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that insert correctly adds a Hobbemoun to an empty tree.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testInsertEmpty() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that insert correctly adds multiple Hobbemoun objects to a non-empty tree.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testInsertMultiple() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that insert returns false when adding a duplicate Hobbemoun.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testInsertDuplicate() {
    return false; // TODO: implement this test
  }

  /**
   * Tests the lookup method for finding existing and non-existing Hobbemoun objects.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testLookup() {
    return false; // TODO: implement this test
  }

  /**
   * Tests the height method for an empty tree, a single node tree, and a multi-level tree.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testHeight() {
    return false; // TODO: implement this test
  }

  /**
   * Tests the getStrongest method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetStrongest() {
    return false; // TODO: implement this test
  }

  /**
   * Tests the getWeakest method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetWeakest() {
    return false; // TODO: implement this test
  }


  /**
   * Tests that next returns the successor of the given Hobbemoun.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testNext() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that next throws IllegalArgumentException when given a null argument.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testNextExceptionEmpty() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that next returns null when the Hobbemoun has no successor.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testNextNoSuccessor() {
    return false; // TODO: implement this test
  }



  /**
   * Tests that the iterator works correctly by checking if it returns the correct elements in
   * order.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIterator() {
    return false; // TODO: implement this test
  }

  /**
   * Tests that the iterator throws NoSuchElementException when there are no more elements to
   * return.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIteratorNoSuchElement() {
    return false; // TODO: implement this test
  }


  /**
   * Tests that the iterator is empty when the tree is empty. hasNext should return false and next()
   * should throw NoSuchElementException.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testIteratorEmpty() {
    return false; // TODO: implement this test
  }


  /**
   * Main method to run all tests
   */
  public static void main(String[] args) {

    System.out.println("Testing Hobbemoun implementation...");

    System.out.println("testCompareToByType: " + testCompareToByType());
    System.out.println("testCompareToByName: " + testCompareToByName());
    System.out.println("testCompareToSame: " + testCompareToSame());
    System.out.println("\nTesting HobbemounTree implementation...");
    System.out.println("testIsEmpty: " + testIsEmpty());
    System.out.println("testSize: " + testSize());
    System.out.println("testIsValidBSTEmpty: " + testIsValidBSTEmpty());
    System.out.println("testIsValidBSTValid: " + testIsValidBSTValid());
    System.out.println("testIsValidBSTInvalid: " + testIsValidBSTInvalid());
    System.out.println("testInsertNullException: " + testInsertNullException());
    System.out.println("testInsertEmpty: " + testInsertEmpty());
    System.out.println("testInsertMultiple: " + testInsertMultiple());
    System.out.println("testInsertDuplicate: " + testInsertDuplicate());
    System.out.println("testLookup: " + testLookup());
    System.out.println("testHeight: " + testHeight());
    System.out.println("testGetStrongest: " + testGetStrongest());
    System.out.println("testGetWeakest: " + testGetWeakest());
    System.out.println("testNext: " + testNext());
    System.out.println("testNextExceptionEmpty: " + testNextExceptionEmpty());
    System.out.println("testNextNoSuccessor: " + testNextNoSuccessor());
    System.out.println("testIterator: " + testIterator());
    System.out.println("testIteratorExceptions: " + testIteratorNoSuchElement());
    System.out.println("testIteratorEmpty: " + testIteratorEmpty());

  }
}
