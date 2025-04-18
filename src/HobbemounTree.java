//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Hobbemoun Binary Tree Implementation
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
//                  (provided the HobbemounTree Template)
//                  lecture slides showed how binary trees function
// Online Sources:  GeeksforGeeks
//                  - https://www.geeksforgeeks.org/introduction-to-binary-tree/
//                  - https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an Iterable binary search tree for storing Hobbemoun objects.
 *
 * The tree maintains ordering based on Hobbemoun's compareTo method and provides operations for
 * inserting, removing,and traversing Hobbemouns.
 *
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc) in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive strategies only.
 *
 */
// public class HobbemounTree 
/* Iterable <Hobbemoun> so that we can iterate over elements of Hobbemoun type */
public class HobbemounTree implements Iterable<Hobbemoun> {

  /**
   * The root of this HobbemounTree. Set to null when tree is empty.
   */
  private Node<Hobbemoun> root;

  /**
   * The size of this HobbemounTree (total number of Hobbemoun stored in this BST)
   */
  private int size;

  /**
   * Constructor for HobbemounTree. Should set size to 0 and root to null.
   */
  public HobbemounTree() {
    this.root = null;
    this.size = 0;
  }

  /**
   * Constructor for HobbemounTree that takes a root node and initializes the tree with it. It
   * should make sure the root node is the root of a valid BST. This constructor is useful for
   * testing (particularly insert), as one can manually set the tree state.
   *
   * This constructor also sets the size of the tree to the number of elements stored in the tree
   * rooted at the input root. See countNodes private helper method.
   *
   * @param root the root of the tree
   * @throws IllegalArgumentException if the input root is not the root of a valid BST
   */
  public HobbemounTree(Node<Hobbemoun> root) {
    if (!isValidBST(root)) {
      throw new IllegalArgumentException("The input root is not the root of a valid BST");
    } else {
      this.root = root;
      this.size = countNodes(root);
    }
  }


  /**
   * Returns the number of nodes in the tree. While not required, this recursive method may be
   * helpful in setting the size of the tree in the HobbemounTree(root) constructor.
   *
   * @return the number of nodes in the tree
   */
  private int countNodes(Node<Hobbemoun> node) {
    // Base case: empty tree
    if (node == null) {
      return 0;
    }
    // Recursive case: count the current node and recurse on left and right subtrees
    return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
  }

  /**
   * Getter method for the Node<Hobbemoun> at the root of this BST. This method is used for testing
   * purposes (eg, to check if the current state of the tree is a valid BST). It should return a
   * deep copy of the root node.
   *
   * @return a deep copy of the root of the BST.
   */
  protected Node<Hobbemoun> getRoot() {
    return getRootHelper(root);
  }


  /**
   * Helper method to get a deep copy of the root of the BST.
   *
   * @param node the root node of the BST
   * @return a deep copy of the root node
   */
  private Node<Hobbemoun> getRootHelper(Node<Hobbemoun> node) {
    // empty tree
    if (node == null) {
      return null;
    }
    // non-empty tree: make a deep copy of the tree rooted at node in the pre-order traversal
    // fashion
    // duplicate self - left - right
    return new Node<>(node.getData(), getRootHelper(node.getLeft()),
        getRootHelper(node.getRight()));
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Checks if the binary subtree rooted at the given node is a valid binary search tree.
   *
   * In order to be a valid BST, the following must be true: For every internal (non-leaf) node X of
   * a binary tree, all the values in the node's left subtree are less than the value in X, and all
   * the values in the node's right subtree are greater than the value in X.
   *
   * @param node the root node of the binary tree
   * @return true if the binary tree is a valid binary search tree, false otherwise
   */
  public static boolean isValidBST(Node<Hobbemoun> node) {
    return isValidBSTHelper(node, null, null);
  }


  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Helper method to check if a binary subtree is a valid BST recursively. We use min and max
   * Hobbemoun values to check if each node's value is within the valid range for its position in
   * the tree.
   *
   * @param node the current node to check
   * @param min  the minimum allowed value for this subtree (null means no minimum)
   * @param max  the maximum allowed value for this subtree (null means no maximum)
   * @return true if the subtree rooted at node is a valid BST, false otherwise
   */
  private static boolean isValidBSTHelper(Node<Hobbemoun> node, Hobbemoun min, Hobbemoun max) {
    // Cite: GeeksforGeeks
    // https://www.geeksforgeeks.org/introduction-to-binary-tree/
    // helped understand how to check if a binary tree is a BST
    // Base case: empty tree
    if (node == null) return true;
    // Check if the current node's value is within the valid range
    // Compare the current node's value with min and max
    Hobbemoun value = node.getData();
    if ((min != null && value.compareTo(min) <= 0) ||
        (max != null && value.compareTo(max) >= 0)) {
      return false;
    }
    // Recursively check the left and right subtrees with updated min and max values
    return isValidBSTHelper(node.getLeft(), min, value) && isValidBSTHelper(node.getRight(), value, max);
  }

  /**
   * Checks whether this HobbemounTree is empty or not
   *
   * @return true if this tree is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Gets the size of this HobbemounTree
   *
   * @return the total number of Hobbemouns stored in this tree
   */
  public int size() {
    return size;
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Adds a new Hobbemoun to this HobbemounTree. Duplicate Hobbemouns are NOT allowed.
   *
   * @param newHobbemoun Hobbemoun to add to this HobbemounTree
   * @throws IllegalArgumentException with a descriptive error message if newHobbemoun is null.
   * @return true if the newHobbemoun is successfully added to this HobbemounTree, false otherwise.
   */
  public boolean insert(Hobbemoun newHobbemoun) {
    if (newHobbemoun == null) {
      throw new IllegalArgumentException("Hobbemoun cannot be null");
    }
    if (root == null) {
      root = new Node<>(newHobbemoun);
      size++;
      return true;
    } 
    boolean inserted = insertHelper(newHobbemoun, root);
    if (inserted) {
      size++;
    }
    return inserted;
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive helper method to insert a new Hobbemoun to a Pokedex rooted at node.
   *
   * @param node         The "root" of the subtree we are inserting the new Hobbemoun into.
   * @param newHobbemoun The Hobbemoun to be added to a BST rooted at node. We assume that
   *                     newHobbemoun is NOT null.
   * @return true if the newHobbemoun is successfully added to this HobbemounTree, false otherwise.
   */
  private static boolean insertHelper(Hobbemoun newHobbemoun, Node<Hobbemoun> node) {
    // Cite: GeeksforGeeks
    // https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
    // helped understand how to implement a binary tree in Java
    int cmp = newHobbemoun.compareTo(node.getData());
    if (cmp == 0) {
      return false; // Duplicate Hobbemoun, do not insert
    } else if (cmp < 0) {
      if (node.getLeft() == null) {
        node.setLeft(new Node<>(newHobbemoun));
        return true; // Inserted as left child
      } else {
        return insertHelper(newHobbemoun, node.getLeft()); // Recur left
      }
    } else {
        if (node.getRight() == null) {
              node.setRight(new Node<>(newHobbemoun));
              return true; // Inserted as right child
            } else {
              return insertHelper(newHobbemoun, node.getRight()); // Recur right
            }
          }
    }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Searches a Hobbemoun given its first and second identifiers.
   *
   * @param firstId  First identifier of the Hobbemoun to find
   * @param secondId Second identifier of the Hobbemoun to find
   * @return the matching Hobbemoun if match found, null otherwise.
   */
  public Hobbemoun lookup(int firstId, int secondId) {
    Hobbemoun toFind = new Hobbemoun(firstId, secondId);
    if (root == null) {
      return null; // Tree is empty
    }
    return lookupHelper(toFind, root);
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive helper method to search and return a match with a given Hobbemoun in the subtree
   * rooted at node, if present.
   *
   * @param toFind a Hobbemoun to be searched in the BST rooted at node. We assume that toFind is
   *               NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a match to target.
   * @return a reference to the matching Hobbemoun if found, null otherwise.
   */
  private static Hobbemoun lookupHelper(Hobbemoun toFind, Node<Hobbemoun> node) {
    // Cite: GeeksforGeeks
    // https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
    // helped understand how to implement a binary tree in Java
    if (node == null) {
      return null; // Base case: empty tree
    }
    int cmp = toFind.compareTo(node.getData());
    if (cmp == 0) {
      return node.getData(); // Found the matching Hobbemoun
    } else if (cmp < 0) {
      return lookupHelper(toFind, node.getLeft()); // Search in left subtree
    } else {
      return lookupHelper(toFind, node.getRight()); // Search in right subtree
    }
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   *
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive helper method that computes the height of the subtree rooted at node counting the
   * number of nodes and NOT the number of edges from node to the deepest leaf
   *
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  private static int heightHelper(Node<Hobbemoun> node) {
    if (node == null) {
      return 0; // Base case: empty tree
    }
    // Recursive case: height is 1 + max height of left and right subtrees
    int leftHeight = heightHelper(node.getLeft());
    int rightHeight = heightHelper(node.getRight());
    return 1 + Math.max(leftHeight, rightHeight);
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive method to find and return the first Hobbemoun, in the increasing order, within this
   * HobbemounTree (meaning the smallest element stored in the tree). As long as this is a valid
   * BST, getting the leftmost value in the tree should satisfy this.
   *
   * @return the first element in the increasing order of this BST, and null if the tree is empty.
   */
  public Hobbemoun getWeakest() {
    if (root == null) {
      return null; // Tree is empty
    }
    return getLeftmostHelper(root).getData(); // Get the leftmost node's data
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive helper method to find and return the leftmost node in the subtree rooted at node.
   *
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  private static Node<Hobbemoun> getLeftmostHelper(Node<Hobbemoun> root) {
    if (root.getLeft() == null) {
      return root; // Base case: leftmost node found
    }
    return getLeftmostHelper(root.getLeft()); // Recur left
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive method to find and return the last Hobbemoun, in the increasing order, within this
   * HobbemounTree (meaning the greatest element stored in the tree). As long as this is a valid
   * BST, getting the rightmost value in the tree should satisfy this.
   *
   * @return the last element in the increasing order of this BST, and null if the tree is empty.
   */
  public Hobbemoun getStrongest() {
    if (root == null) {
      return null; // Tree is empty
    }
    return getRightmostHelper(root).getData(); // Get the rightmost node's data
  }

  /**
   * Recursive helper method to find and return the rightmost node in the subtree rooted at node.
   *
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  private static Node<Hobbemoun> getRightmostHelper(Node<Hobbemoun> root) {
    if (root.getRight() == null) {
      return root; // Base case: rightmost node found
    }
    return getRightmostHelper(root.getRight()); // Recur right
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Finds and returns the in-order successor of a specified Hobbemoun in this HobbemounTree
   *
   * @param hobbemoun the Hobbemoun to find its successor
   * @return the in-order successor of a specified Hobbemoun in this HobbemounTree. If there is no
   *         successor, return null.
   *
   * @throws IllegalArgumentException with a descriptive error message if <b>hobbemoun</b> is null
   */
  public Hobbemoun next(Hobbemoun hobbemoun) {
    if (hobbemoun == null) {
      throw new IllegalArgumentException("Hobbemoun cannot be null");
    }
    return nextHelper(hobbemoun, root,null);
  }

  /**
   * MUST BE IMPLEMENTED RECURSIVELY - NO LOOPS
   *
   * Recursive helper method to find and return the next Hobbemoun in the tree rooted at node.
   *
   * @param hobbemoun a Hobbemoun to search its in-order successor. We assume that <b>hobbemoun</b>
   *                  is NOT null.
   * @param node      "root" of a subtree storing Hobbemoun objects
   * @param next      a Node which stores a potentional candidate for next node
   * @return the next Hobbemoun in the tree rooted at node. If there is no next Hobbemoun, return
   *         null.
   */
  private static Hobbemoun nextHelper(Hobbemoun hobbemoun, Node<Hobbemoun> node,
      Node<Hobbemoun> next) {
    // Base case: node is null
    // Base case: We found the node that matches the target Hobbemoun
    // If node has a right subtree, the successor is the leftmost node in that subtree
    // If no right subtree, the successor is the saved potential successor (if any)
    // Recursive case: target is less than current node
    // The current node might be the successor
    // Search in left subtree, set the current node as potential successor
    // Recursive case: target is greater than current node
    // Successor must be in right subtree (if it exists)
    // Keep the same potential successor

    // Cite: GeeksforGeeks
    // https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/
    // helped understand how to implement a binary tree in Java
    if (node == null) {
      return null; // Base case: empty tree
    }
    int cmp = hobbemoun.compareTo(node.getData());
    if (cmp == 0) {
      // Match Found
      if (node.getRight() != null) {
        // Go right and find leftmost node
        return getLeftmostHelper(node.getRight()).getData();
      } else {
        // No right Child
        return next == null ? null : next.getData();
      }
    } else if (cmp < 0) {
      // Target is smaller
      return nextHelper(hobbemoun , node.getLeft(), node);
    } else {
      // Target is larger
      return nextHelper(hobbemoun, node.getRight(), next);
    }
  }

  /**
   * Returns an iterator over the Hobbemoun objects in this HobbemounTree using in-order travesal
   * (smallest to largest).
   *
   * @return an HobbemounIterator over the Hobbemoun objects in this HobbemounTree
   */
  @Override
  public Iterator<Hobbemoun> iterator() {
    return new HobbemounIterator(this);
  }

  /**
   * YOU MUST USE AN ENHANCED FOR LOOP TO IMPLEMENT THIS METHOD.
   *
   * Returns a String representation of all the Hobbemouns stored within this HobbemounTree in the
   * increasing order with respect to the result of Hobbemoun.compareTo() method. The string should
   * have the Hobbemoun toString() return value on a new line; one Hobbemoun per line:
   *
   * "nameOne (12.25)\nnameTwo (12, 56)\nnameTwo (89,27)"
   *
   *
   * @return a string containing all the Hobbemoun, in the increasing order. Returns an empty string
   *         "" if this BST is empty.
   *
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Hobbemoun h : this) {
      sb.append(h.toString()).append("\n");
    }
    if (sb.length() == 0) {
      return ""; // Empty tree
    }
    return sb.toString().trim(); // Remove trailing newline
  }

  /**
   * OPTIONAL - NOT REQUIRED BUT YOU PROBABLY WANT TO KNOW HOW TO DO THIS JUST SAYING
   *
   * Removes a specific Hobbemoun from this HobbemounTree, recursively.
   *
   * @param hobbemoun the Hobbemoun to remove
   * @return true if the specific Hobbemoun is successfully removed, false if no match found with
   *         any Hobbemoun in this tree.
   * @throws IllegalArgumentException with a descriptive error message if <b>hobbemoun</b> is null
   */
  public boolean remove(Hobbemoun hobbemoun) {
    return false;
  }

  /**
   * OPTIONAL - NOT REQUIRED BUT YOU PROBABLY WANT TO KNOW HOW TO DO THIS JUST SAYING
   *
   * Recursive helper method to search and remove a specific Hobbemoun from the BST rooted at node
   *
   * @param target a reference to a Hobbemoun to remove from the BST rooted at node. We assume that
   *               target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a match with the target
   *               Hobbemoun.
   *
   *
   * @return the new "root" of the subtree we are checking after trying to remove target
   * @throws NoSuchElementException with a descriptive error message if there is no Hobbemoun
   *                                matching target in the BST rooted at <b>node</b>
   */
  private static Node<Hobbemoun> removeHobbemounHelper(Hobbemoun target, Node<Hobbemoun> node) {

    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly

    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.

    // Case 1: node may be a leaf (has no children), set node to null.

    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)

    // Case 3: node may have two children,
    // Replace node with a new Node whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a Node. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.

    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.

    return null;
  }

}
