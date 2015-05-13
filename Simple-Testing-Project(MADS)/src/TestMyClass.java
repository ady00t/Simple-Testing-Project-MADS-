import org.junit.Test;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 

 
import junit.framework.Assert;
import junit.framework.TestCase;


/**
 *
 * @author Braxis
 */

@RunWith(value = Parameterized.class)
public class TestMyClass {
    private static int tearDownCount = 0;
    private static int setUpCount = 0;
    private int parameter;
 
    public TestMyClass(int parameter) {
        this.parameter = parameter;
    }
 
    @Parameters
    /**
     * Defines a list of parameters that will be used by the JUnit. These
     * parameters are passed onto the constructor. Each JUnit methods will be
     * run for each of those parameters.
     */
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1001 }, { 1002 }, { 0 } };
        return Arrays.asList(data);
    }
 
    @Test
    public void testBasicStuffs() {
        System.out.println("...Testing Basic Stuffs");
        System.out.println("...Parameter :" + parameter);
        MyClass stuff = new MyClass();
        Assert.assertEquals(7.0, stuff.testMethodOne(21, 3));
        Assert.assertFalse(stuff.testMethodOne(21, 3) > 21);
        Assert.assertNotNull(stuff);
        stuff = null;
        Assert.assertNull(stuff);
    }
 
    /**
     * If you are expecting an exception, add expected attribute to the @Test
     * annotation.
     * This causes the test case to pass with expected exception. If you don't
     * use this attribute, your JUnit will fail.
     */
    @Test(expected = java.lang.ArithmeticException.class)
    public void testDivideByZeroException() {
        System.out.println(("...Testing Divide By Zero"));
        System.out.println("...Parameter :" + parameter);
        MyClass stuff = new MyClass();
        stuff.testMethodOne(7, 0);
    }
 
    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBounds() {
        System.out.println("...Testing out of bounds");
        System.out.println("...Parameter :" + parameter);
        new ArrayList().get(1);
    }
 
    /**
     * Items here are executed before the actual tests are run Note that this
     * method gets called for each testXXX method call
     *
     * We are using @before annotation here as we are not extending the
     * TestCase. If you are extending TestCase, the setUp() method with no
     * parameter will be automatically picked up.
     */
    @Before
    public void setUp() {
        System.out.println("\n@Before - Setting Up Stuffs: Pass "
                + ++setUpCount);
        // write setup code that must be executed before each test method run
    }
 
    /**
     * Items in this method are executed after the tests are run. Note that this
     * method gets called for each testXXX method call
     *
     * We are using @after annotation here as we are not extending the TestCase.
     * If you are extending TestCase, the tearDown() method with no parameter
     * will be automatically called after each test method run.
     */
    @After
    public void tearDown() {
        System.out.println("@After - Tearing Down Stuffs: Pass "
                + ++tearDownCount);
    }
 
    /**
     * If your design has excessive coupling, you might need to run setup and
     * tear down code once for all your tests.
     *
     * Excessive coupling is an indication to need for code refactoring, but if
     * you must, then putting the @BeforeClass annotation before the method
     * helps create one time setup. This method will be run before any of the
     * test methods are run.
     */
    @BeforeClass
    public static void oneTimeSetup() {
        System.out.println("@BeforeClass - One Time Setup with");
        // write your one time initialization code here
    }
 
    /**
     * @AfterClass annotation before the method helps create one time tear down.
     *             This method will be run only once after all of the test
     *             methods are run.
     */
    @AfterClass
    public static void oneTimeTearDown() {
        System.out.println("\n@AfterClass - One Time Tear Down");
        // write your one time teardown code here
    }
}