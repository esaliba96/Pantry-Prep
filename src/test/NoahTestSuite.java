/*
 * Test suite developed by Noah Paige
 */

package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestDay.class,
   TestMeasurementUtil.class,
   IngredientTest.class,
   RecipeTest.class,
})

public class NoahTestSuite {   
}  