package suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.AccountTests;
import tests.LoginTests;
import tests.MovementTests;


@RunWith(Suite.class)
@SuiteClasses({
	LoginTests.class,
	AccountTests.class,
	MovementTests.class

})
public class SuiteTeste {

}