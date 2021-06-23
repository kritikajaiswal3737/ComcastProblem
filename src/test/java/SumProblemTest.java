import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;

public class SumProblemTest {

  long output;
  String ip;
  String ip1;
  String[] args;

  @Before
  public void setup() {
    output = 0;
    ip="";
    ip1="";
  }

  /*
  Test case for the method ProcessDecimal
 */
  @Test
  public void testCalculateDecimal() {
    output=SumProblem.processDecimal("abc123");
    Assert.assertEquals(6, output);
  }

  /*
  Test case for the method processHexDecimal
   */
  @Test
  public void testCalculateHexDecimal() {
    output=SumProblem.processHexDecimal("abc123");
    Assert.assertEquals(39, output);
  }

  /*
  Test case for an empty string as input to ProcessDecimal method.
 */
  @Test
  public void testEmptyDecimal() {
    output=SumProblem.processDecimal("");
    Assert.assertEquals(0, output);
  }

  /*
  Test case for an empty string as input to ProcessHexDecimal method.
 */
  @Test
  public void testEmptyHexDecimal() {
    output=SumProblem.processHexDecimal("");
    Assert.assertEquals(0, output);
  }

  /*
  Test case when the input string contains only letters and no digits without -x.
 */
  @Test
  public void testAlphabetDecimal() {
    output=SumProblem.processDecimal("abcdeeeeeeee");
    Assert.assertEquals(0, output);
  }


  /*
  Test case when the input string contains only letters and no digits with -x.
 */
  @Test
  public void testAlphabetHexDecimal() {
    output=SumProblem.processHexDecimal("abcdeeeeeeee");
    Assert.assertEquals(158, output);
  }

  /*
  Test case when the input string contains only non-hexadecimal letters and no digits with -x.
 */
  @Test
  public void testNonHexAlphabetHexDecimal() {
    output=SumProblem.processHexDecimal("xxxkjxkjmvnnvv");
    Assert.assertEquals(0, output);
  }


  /*
  Test to check if readInput method correctly reads the standard input provided by the user.
   */
  @Test
  public void testDefaultInput() {
    ip=SumProblem.readInput(new StringReader("666jjj000"));
    Assert.assertEquals("666jjj000", ip);
  }

  /*
  Test if method writeOutput method correctly displays output to the screen STDOUT.
   */
  @Test
  public void testDefaultOutput() {
    output=5;
    Appendable ap = new StringBuilder();
    SumProblem.writeOutput(ap,output);
    Assert.assertEquals("5", ap.toString());
  }

  /*
  Test to check if standard input given by the user generates correct output.
   */
  @Test
  public void testResultDefaultInput() {
    ip=SumProblem.readInput(new StringReader("666jjj000"));
    output=SumProblem.processHexDecimal(ip);
    Assert.assertEquals(18, output);
  }


  /*
  Test to check if file input given by the user generates correct output.
   */
  @Test
  public void testFileInput() throws IOException {
    args = new String[]{"-f","input.txt"};
    ip=SumProblem.readFile(args,0);
    output=SumProblem.processDecimal(ip);
    Assert.assertEquals(22, output);
  }


  /*
  Test to check if -x input given by the user generates correct output.
   */
  @Test
  public void testHexadecimalInput() {
    args = new String[]{"-x"};
    ip=SumProblem.readInput(new StringReader("666a000"));
    output=SumProblem.processHexDecimal(ip);
    Assert.assertEquals(28, output);
  }


  /*
  Test how the code handles incorrect file in input.
   */
  @Test(expected = IOException.class)
  public void testIncorrectFileInput() throws IOException {
    args = new String[]{"-f","hello.txt"};
    SumProblem.readFile(args,0);
  }

  /*
  Test how the code handles when the file is not inputted by the user.
   */
  @Test
  public void testMissingFileInput() {
    Appendable ap = new StringBuilder();
    args = new String[]{"-f"};
    Assert.assertFalse(SumProblem.validateInput(args));
  }


  /*
  Test how the code handles when the file has multiple lines containing string.
   */
  @Test
  public void testFileInputMultipleLines() throws IOException {
    args = new String[]{"-f","input1.txt"};
    ip=SumProblem.readFile(args,0);
    output=SumProblem.processDecimal(ip);
    Assert.assertEquals(28, output);
  }

  /*
  Test how the code handles when the file is not inputted by the user.
   */
  @Test
  public void testInvalidOptions() {
    Appendable ap = new StringBuilder();
    args = new String[]{"-s"};
    Assert.assertFalse(SumProblem.validateInput(args));
  }

}