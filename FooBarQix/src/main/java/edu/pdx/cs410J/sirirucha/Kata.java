package edu.pdx.cs410J.sirirucha;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {

  public static void main(String[] args) {
    if(args.length == 0) {
      System.err.println("Missing command line arguments");
      System.exit(1);
    } else if (args.length == 1) {
      if(validateGivenInput(args[0])) {
        String result = compute(args[0]);
        if(!(result.contains("Foo") || result.contains("Bar") || result.contains("Qix"))) {
          String newResult = args[0].replace("0","*");
          System.out.println(newResult);
        } else {
          String newResult = args[0].replace("0","*");
          System.out.println(result);
        }
      } else {
       System.err.println("Not a valid number");
      }
      System.exit(0);
    } else if (args.length > 1) {
      System.err.println("Extraneous arguments provided require only 1");
      System.exit(1);
    }
  }

  public static Boolean validateGivenInput(String number) {
    try {
      int num = Integer.parseInt(number);
      return true;
    } catch(NumberFormatException e) {
      return false;
    }
  }

  public static String compute(String number) {
    String result = "";
    int num = Integer.parseInt(number);
    if(num%3 == 0) {
      result += "Foo";
    }
    if(num%5 == 0) {
      result += "Bar";
    }
    if(num%7 == 0) {
      result += "Qix";
    }
    for(int i = 0; i < number.length(); i++) {
      if(number.charAt(i) == '3') {
        result += "Foo";
      }
      if(number.charAt(i) == '5') {
        result += "Bar";
      }
      if(number.charAt(i) == '7') {
        result += "Qix";
      }
      if(number.charAt(i) == '0') {
        result += "*";
      }
    }

    return result;
  }
}