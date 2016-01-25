
/** Binary connection of two sub formulas. */
public class Bin extends Formula {
  
  /** Left sub formula. */
  public final Formula left;
  
  /** The connective. */
  public final Conn connective;
  
  /** Right sub formula. */
  public final Formula right;
  
  Bin (Formula left, Conn connective, Formula right) {
    this.left       = left;
    this.connective = connective;
    this.right      = right;
  }
  
  public String toString() { 
    return "(" + left.toString() + 
           " " + connective.toString() + 
           " " + right.toString() + ")";
  }
  
  public boolean eval (boolean[] valuation) {
    final boolean l = left.eval(valuation);
    final boolean r = right.eval(valuation);
    switch (connective) {
    case AND     : return l && r;
    case OR      : return l || r;
    case IMPLIES : return !l || r;
    case IFF     : return l == r;
    default      : throw new UnsupportedOperationException();
    }
  }
}
