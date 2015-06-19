package pl.edu.us.ii.awpto;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
    /**
     * Create the test case.
     *
     * @param testName name of the test case
     */
  public AppTest( String testName ) {
    super( testName );
  }

  /**
   * Zestaw testow.
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite( AppTest.class );
  }

  /**
   * Testy.
   */
  public void testApp() {
    assertTrue( true );
  }
}
