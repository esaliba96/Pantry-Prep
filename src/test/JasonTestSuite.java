//Person in Charge: Jason Lomsdalen
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RecipeDatabaseOutputIntegrationTest.class, RecipeDatabaseOutputTest.class,
		ShoppingListOutputIntegrationTest.class, ShoppingListOutputTest.class })
public class JasonTestSuite {

}
