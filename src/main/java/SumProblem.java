import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * This class is used to calculate the sum of the digits from the given input String.
 */
public class SumProblem {

  private static final Appendable append = System.out;

  /**
   * Main method.
   * @param args The arguments passed to the program.
   */
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
        }
      }

      if (arguments.contains("-x")) {
        output = processHexDecimal(word);
      } else {
        output = processDecimal(word);
      }
      writeOutput(append, output);


    }
  }

  /**
   * This helper method helps to calculate the position of the flag -f in the argument array.
   * @param args Array of arguments passed to the program.
   * @return Position of -f flag.
   */
  private static int helper(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-f")) {
        return i;
      }
    }
    return -1;
  }

  /**
   * This method validates all the arguments passed to the program.
   * @param args Array of arguments passed to the program.
   * @return True if all the arguments passed are valid and False if any argument is invalid.
   */
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

  /**
   * This method reads input from STDIN.
   * @param read Readable object.
   * @return String that is read from STDIN.
   */
  public static String readInput(Readable read) {
    Scanner scan = new Scanner(read);
    return scan.next();
  }

  /**
   * This method reads input from a file.
   * @param args Array of arguments passed to the program.
   * @param position Index of -f argument.
   * @return String read from the file.
   * @throws IOException When the file is invalid.
   */
  public static String readFile(String[] args, int position) throws IOException{
    StringBuilder record = new StringBuilder();
    String line = null;
    BufferedReader br = new BufferedReader(new FileReader(args[position + 1]));
    while ((line = br.readLine()) != null) {
      record.append(line);
    }
    return record.toString();
  }

  /**
   * This method writes output i.e sum to STDOUT.
   * @param write The appendable object.
   * @param number The sum that needs to be outputted to user.
   */
  public static void writeOutput(Appendable write, Long number) {
    try {
      write.append(number.toString());
    } catch (IOException e) {
      writeMessage(append, "");
    }
  }

  /**
   * This method displays any messages to the user as STDOUT.
   * @param write The appendable object.
   * @param msg The message to be displayed.
   */
  public static void writeMessage(Appendable write, String msg) {
    try {
      write.append(msg);
    } catch (IOException e) {
      writeMessage(append, "");
    }
  }

  /**
   * This method calculated sum for hexadecimal numbers.
   * @param word The string for which sum needs to be calculated.
   * @return The sum of digits.
   */
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

  /**
   * This method calculates sum for decimal numbers.
   * @param word The string for which sum needs to be calculated.
   * @return The sum of digits.
   */
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
