package suite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.AccountTests;
import tests.LoginTests;


@RunWith(Suite.class)
@SuiteClasses({
	LoginTests.class,
	AccountTests.class
	
})
	public class SuiteTeste {
	
}
