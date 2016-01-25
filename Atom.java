/** Atomic formula. */
public class Atom extends Formula {
  
  /** The unique identifier id >= 0 of the atom. */
  public final int id;
  
  /** The name of the identifier used for printing (optional). */
  public final String name;
 
  /** Construct an atomic formula.
   * @param id >= 0.
   * @param name maybe be empty, but not null.  */
  Atom (int id, String name) {
    if (id < 0 || name == null) throw new IllegalArgumentException();
    this.id   = id;
    this.name = name;
  }
  /** Construct an atomic formula with default name.
   * @param id >=0.  */
  Atom (int id) { this (id, ""); }
  
  public String toString() {
    if (name.isEmpty()) return "A" + id;
    else return name;
  }
  
  public boolean eval (boolean[] valuation) {
    return valuation[id];
  }
}
