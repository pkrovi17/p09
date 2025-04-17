// TODO Add Complete File Header

/**
 * This class models the Hobbemoun data type.
 *
 */
// public class Hobbemoun /* TODO add the required interface */ {
public class Hobbemoun implements Comparable<Hobbemoun> {
  /**
   * The minimum ID number
   */
  public static final int MIN_ID = HobbedexUtility.MIN_HOBBEMOUN_ID;
  /**
   * The maximum ID number
   */
  public static final int MAX_ID = HobbedexUtility.MAX_HOBBEMOUN_ID;

  /**
   * The name of the Hobbemoun
   */
  private final String NAME;

  /**
   * The first ID of the Hobbemoun
   */
  private final int FIRST_ID;

  /**
   * The second ID of the Hobbemoun
   */
  private final int SECOND_ID;

  /**
   * The primary type of the Hobbemoun; cannot be null; cannot be the same as the secondary type
   */
  private final HobbemounType PRIMARY_TYPE;

  /**
   * The secondary type of the Hobbemoun; may be null; cannot be the same as the primary type
   */
  private final HobbemounType SECONDARY_TYPE;

  /**
   * Creates a new Hobbemoun with specific first and second IDs and initializes all its data fields
   * accordingly.
   *
   * @param firstID  the first ID of the Hobbemoun, between 1-151
   * @param secondID the second ID of the Hobbemoun, between 1-151
   * @throws IllegalArgumentException if the first and second ID are out of bounds or equal to each
   *                                  other.
   */
  public Hobbemoun(int firstID, int secondID) {
    // Ensure the validity of inputs
    if (firstID < 1 || firstID > HobbedexUtility.MAX_HOBBEMOUN_ID || secondID < 1
        || secondID > HobbedexUtility.MAX_HOBBEMOUN_ID || firstID == secondID)
      throw new IllegalArgumentException("invalid IDs!");
    // Initialize fields
    this.FIRST_ID = firstID;
    this.SECOND_ID = secondID;
    this.NAME = HobbedexUtility.getHobbemounName(firstID, secondID);
    HobbemounType[] hobbemounTypes = HobbedexUtility.getHobbemounTypes(firstID, secondID);
    this.PRIMARY_TYPE = hobbemounTypes[0];
    this.SECONDARY_TYPE = hobbemounTypes[1];
  }


  /**
   * This constructor may be used for testing purposes (particularly the compareTo method). It
   * creates a Hobbemoun with the given name, and the first and second IDs set to 0. The primary and
   * secondary types are set to the given primary and secondary types, respectively.
   *
   * @param name          name to be assigned to this Hobbemoun. We assume a valid name.
   * @param primaryType   primary type to be assigned to this Hobbemoun. We assume a valid type.
   * @param secondaryType secondary type to be assigned to this Hobbemoun. We assume a valid type.
   */
  public Hobbemoun(HobbemounType primaryType, HobbemounType secondaryType, String name) {
    this.FIRST_ID = 1;
    this.SECOND_ID = 2;
    this.NAME = name;
    this.PRIMARY_TYPE = primaryType;
    this.SECONDARY_TYPE = secondaryType;
  }

  /**
   * This constructor may be used for testing purposes. It creates a Hobbemoun with the given name,
   * and the first and second IDs set to 1 and 2, respectively. The primary and secondary types are
   * set to NORMAL.
   *
   * @param name name to be assigned to this Hobbemoun. We assume a valid name.
   */
  public Hobbemoun(String name) {
    this.FIRST_ID = 1;
    this.SECOND_ID = 2;
    this.NAME = name;
    this.PRIMARY_TYPE = HobbemounType.NORMAL;
    this.SECONDARY_TYPE = HobbemounType.NORMAL;
  }

  /**
   * Gets the name of this Hobbemoun
   *
   * @return the name of the Hobbemoun
   */
  public String getName() {
    return this.NAME;
  }

  /**
   * Gets the first ID of this Hobbemoun
   *
   * @return the first ID of the Hobbemoun
   */
  public int getFirstID() {
    return this.FIRST_ID;
  }

  /**
   * Gets the second ID of this Hobbemoun
   *
   * @return the second ID of the Hobbemoun
   */
  public int getSecondID() {
    return this.SECOND_ID;
  }

  /**
   * Gets the primary type of this Hobbemoun
   *
   * @return the primary type of the Hobbemoun
   */
  public HobbemounType getPrimaryType() {
    return this.PRIMARY_TYPE;
  }

  /**
   * Gets the secondary type of this Hobbemoun
   *
   * @return the secondary type of the Hobbemoun
   */
  public HobbemounType getSecondaryType() {
    return this.SECONDARY_TYPE;
  }

  /**
   * Determines the ordering of Hobbemoun. Hobbemoun are ordered by:
   *
   * 1) Compare the primary type of the Hobbemoun. If the primary types are different, the Hobbemoun
   * with the higher value primary type is considered greater.
   *
   * 2) If the primary types are the same and both Hobbemoun have a secondary type, compare the
   * secondary types. If the secondary types are different, the Hobbemoun with the higher value
   * secondary type is considered greater. If either Hobbemoun has no secondary type, skip this
   * step.
   *
   * 3) If there is a tie, the Hobbemoun with the name that comes first in the alphabet is
   * considered lesser. (Sort alphabetically by name.)
   *
   * A Hobbemoun with identical #1-3 are considered equal and will return 0.
   *
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   * @param otherHobbemoun the other Hobbemoun to compare this Hobbemoun to.
   * @return a negative int if this Hobbemoun is less than other, a positive int if this Hobbemoun
   *         is greater than other, or 0 if this and the other Hobbemoun are equal.
   */
  @Override
  public int compareTo(Hobbemoun otherHobbemoun) {
    // Compare primary types
    HobbemounType thisPrimaryType = this.PRIMARY_TYPE;
    HobbemounType otherPrimaryType = otherHobbemoun.getPrimaryType();
    // Compare primary types
    int primaryTypeComparison = thisPrimaryType.compareTo(otherPrimaryType);
    if (primaryTypeComparison != 0) {
      return primaryTypeComparison;
    }
    // Compare secondary types if both have one
    HobbemounType thisSecondaryType = this.SECONDARY_TYPE;
    HobbemounType otherSecondaryType = otherHobbemoun.getSecondaryType();
    if (thisSecondaryType != null && otherSecondaryType != null) {
      int secondaryTypeComparison = thisSecondaryType.compareTo(otherSecondaryType);
      if (secondaryTypeComparison != 0) {
        return secondaryTypeComparison;
      }
    }
    // Compare names
    int nameComparison = this.NAME.compareTo(otherHobbemoun.getName());
    if (nameComparison != 0) {
      return nameComparison;
    }
    // If all comparisons are equal, return 0 
    return 0;
  }

  /**
   * A Hobbemoun's String representation is its name followed by " (FIRST_ID, SECOND_ID)" --
   * Example: "Zapchu (145, 25)"
   *
   * @see java.lang.Object#toString()
   * @return a String representation of this Hobbemoun
   */
  @Override
  public String toString() {
    return this.NAME + " (" + this.FIRST_ID + ", " + this.SECOND_ID + ")";
  }

  /**
   * Equals method for Hobbemoun. This Hobbemoun equals another object if other is a Hobbemoun with
   * the exact same name, and their both first and second IDs match.
   *
   * @param other Object to determine equality against this Hobbemoun
   * @return true if this Hobbemoun and other Object are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    // Ensure other is a Hobbemoun object
    if (!(other instanceof Hobbemoun)) {
      return false;
    }
    // Ensure the equality of this Hobbemoun to (Hobbemoun)other
    Hobbemoun hobbemoun = (Hobbemoun) other;
    return this.NAME.equals(hobbemoun.NAME) && this.FIRST_ID == hobbemoun.getFirstID()
        && this.SECOND_ID == hobbemoun.getSecondID();
  }

}
