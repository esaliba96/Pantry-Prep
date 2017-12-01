// Trevor Brown's Test Suite

package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IngredientTest.class, RecipeIngredientIntegrationTest.class })

public class TrevorTestSuite {

}
