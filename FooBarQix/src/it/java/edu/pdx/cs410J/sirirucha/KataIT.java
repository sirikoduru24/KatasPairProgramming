package edu.pdx.cs410J.sirirucha;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

class KataIT extends InvokeMainTestCase {

  @Test
  void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class);
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
    assertThat(result.getExitCode(), equalTo(1));
  }
  @Test
  void invokingMainWithMoreArguments() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "12456", "24356");
    assertThat(result.getTextWrittenToStandardError(), containsString("Extraneous arguments provided require only 1"));
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  void invokingMainWithCorrectNumberOfArguments() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "35");
    assertThat(result.getTextWrittenToStandardOut(), containsString("BarQixFooBar"));
    assertThat(result.getExitCode(), equalTo(0));
  }

  @Test
  void invokingMainWithCorrectNumberOfArgumentsWithInvalidNumber() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "12456.00");
    assertThat(result.getTextWrittenToStandardError(), containsString("Not a valid number"));
    assertThat(result.getExitCode(), equalTo(0));
  }

  @Test
  void invokingMainWithNonDivisibleNumberWithZero() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "101");
    assertThat(result.getTextWrittenToStandardOut(), containsString("1*1"));
    assertThat(result.getExitCode(), equalTo(0));

    result = invokeMain(Kata.class, "0");
    assertThat(result.getTextWrittenToStandardOut(), containsString("*"));
    assertThat(result.getExitCode(), equalTo(0));

    result = invokeMain(Kata.class, "446");
    assertThat(result.getTextWrittenToStandardOut(), containsString("446"));
    assertThat(result.getExitCode(), equalTo(0));
  }

  @Test
  void invokingMainWithDivisibleNumberWithZero() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "10101");
    assertThat(result.getTextWrittenToStandardOut(), containsString("FooQix**"));
    assertThat(result.getExitCode(), equalTo(0));
  }

  @Test
  void invokingMainWithDivisibleBySevenNumberWithoutZero() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Kata.class, "7");
    assertThat(result.getTextWrittenToStandardOut(), containsString("QixQix"));
    assertThat(result.getExitCode(), equalTo(0));
  }
}
