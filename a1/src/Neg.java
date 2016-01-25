/** The negation of a Formula. */
public class Neg extends Formula {
  
  /** The sub formula, never null. */
  public final Formula sub;
  
  /** Construct a negated formula.
   * @param sub != null.
   */
  Neg (Formula sub) {
    if (sub == null) throw new IllegalArgumentException();
    this.sub = sub;
  }
  
  public String toString() { return "¬" + sub.toString(); }
  
  public boolean eval (boolean[] valuation) {
    return !sub.eval(valuation);
  }
}

