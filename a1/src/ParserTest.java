
public class ParserTest {

  public static void main(String[] args) {
    System.out.println("Testing parser for propositional formulae...");
    System.out.println();
    for (String s : args) {
      final FormulaParser parser = new FormulaParser(s);   // Create a parser for String s.
      final Formula       p      = parser.parse();         // Parse all of s into formula p.
      final int           n      = parser.numberOfAtoms(); // After parsing, number of atoms is known.
      System.out.println("Parsed formula " + p + ".");
      System.out.println("It has " + n + " different propositional variables.");
      if (p instanceof Atom) System.out.println("It is an atom.");
      else if (p instanceof Neg) System.out.println("It is a negated formula.");
      else if (p instanceof Bin) System.out.println("Its main connective is binary.");
      System.out.println();
    }
  }
}
