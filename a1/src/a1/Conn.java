
/** Binary connective. */
public enum Conn {
  AND("∧"), OR("∨"), IMPLIES("⇒"), IFF("⇔");
  
  /** How to print the connective. */
  public final String name;
  
  Conn (String name) { this.name = name; }
  
  public String toString() { return name; }
}