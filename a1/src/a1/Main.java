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

              boolean[] b = new boolean[10];
              for(boolean[] line : benum(b, 9))
              {
                     for(int i = 0;i<10; i++)
                     {
                            print(String.valueOf(line[i]?"1 ":"0 "));
                     }
                     println("");
              }


              Formula f = fp.parse();
              println(fp.parse().toString());
       }

       public static List<boolean[]> benum(boolean[] line, int depth) {
              List<boolean[]> bl;
              if (depth == 0) {
                     bl = new ArrayList<boolean[]>();
                     bl.add(line.clone());
              } else {
                     line[depth] = false;
                     bl = benum(line, depth - 1);

                     line[depth] = true;
                     bl.addAll(benum(line, depth - 1));
              }
              return bl;
       }
}

