package a1;
import java.io.Console;
import java.lang.*;
import java.util.*;
/**
 * Created by jpp on 25/01/16.
 */
public class Main {
       public static Console c;
       public static java.util.Scanner s;

       public static void println(String s) {
              System.out.println(s);
       }

       public static void print(String s) {
              System.out.print(s);
       }

       public static String readLine() {
              return s.nextLine();
       }

       public static void main(String[] args) {
              c = System.console();
              s = new java.util.Scanner(System.in);
              println("Psst... Hey kid, wanna enter a logical formula? : ");
              String formula = readLine();
              FormulaParser fp = new FormulaParser(formula);
              Formula f = fp.parse();
              int count = fp.numberOfAtoms();

              boolean[] b = new boolean[count];
              for(boolean[] line : benum(b, count))
              {
                     for(int i = 0; i < count; i++)
                     {
                            print(String.valueOf(line[i]?"1 ":"0 "));
                     }
                     print(f.eval(line)?"True ":"False ");
                     println("");
              }
       }

       public static List<boolean[]> benum(boolean[] line, int depth) {
              List<boolean[]> bl;
              if (depth == 0) {
                     bl = new ArrayList<>();
                     bl.add(line.clone());
              } else {
                     line[depth-1] = false;
                     bl = benum(line, depth - 1);

                     line[depth-1] = true;
                     bl.addAll(benum(line, depth - 1));
              }
              return bl;
       }
}

