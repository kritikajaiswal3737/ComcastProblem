import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumProblem {

  private static final Appendable append = System.out;
  public static void main(String args[]) {


    int position = -1;
    String word = "";
    long output;
    Set<String> arguments = new HashSet<>();
    arguments.addAll(Arrays.asList(args));
    Readable read = new InputStreamReader(System.in);

    if (validateInput(args)) {
      if (!arguments.contains("-f")) {
        word = readInput(read);
      } else {
        position = helper(args);
        if (position != args.length - 1) {
          try {
            word = readFile(args, position);
          } catch (IOException e) {
            writeMessage(append, "File name incorrect in the argument");
          }
        } //else {
          //writeMessage(append, "File name missing in the argument");
          //System.exit(0);
        //}
      }

      if (arguments.contains("-x")) {
        output = processHexDecimal(word);
      } else {
        output = processDecimal(word);
      }
      writeOutput(append, output);


    }
  }


  private static int helper(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-f")) {
        return i;
      }
    }
    return -1;
  }

  public static boolean validateInput(String[] args) {
    int pos = helper(args);
    Set<String> valids = new HashSet<>();
    valids.add("-f");
    valids.add("-x");
    for (int i = 0; i < args.length; i++) {
      if(pos != -1 && pos != args.length-1 && i==pos+1) {
        continue;
      }

        if (!valids.contains(args[i]) || pos == args.length-1) {
          writeMessage(append, "Invalid Usage! Below are the valid options:\n");
          writeMessage(append, "Use \"-f filename\" for file input \n");
          writeMessage(append, "Use \"-x\" for hexadecimal \n");
          writeMessage(append, "Use \"-x -f filename\" for hexadecimal file input\n");
          return false;
      }
    }
return true;
  }

  public static String readInput(Readable read) {
    Scanner scan = new Scanner(read);
    return scan.next();
  }

  public static String readFile(String[] args, int position) throws IOException{
    StringBuilder record = new StringBuilder();
    String line = null;
    BufferedReader br = new BufferedReader(new FileReader(args[position + 1]));
    while ((line = br.readLine()) != null) {
      record.append(line);
    }
    return record.toString();
  }

  public static void writeOutput(Appendable write, Long number) {
    try {
      write.append(number.toString());
    } catch (IOException e) {
      writeMessage(append, "");
    }
  }


  public static void writeMessage(Appendable write, String msg) {
    try {
      write.append(msg);
    } catch (IOException e) {
      writeMessage(append, "");
    }
  }

  public static long processHexDecimal(String word) {
    long sum = 0;
    char ch;
    int temp;
    for (int i = 0; i < word.length(); i++) {
      ch = word.charAt(i);
      temp = Character.digit(ch, 16);
      if (temp >= 0) {
        sum += temp;
      }
    }
    return sum;
  }

  public static long processDecimal(String word) {
    long sum = 0;
    char ch;
    int n;
    for (int i = 0; i < word.length(); i++) {
      ch = word.charAt(i);
      if (Character.isDigit(ch)) {
        n = Character.getNumericValue(ch);
        sum += n;
      }
    }
    return sum;
  }

}
