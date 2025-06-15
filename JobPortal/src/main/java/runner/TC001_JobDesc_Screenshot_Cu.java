package runner;

import base.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features/OpenJobDesc.feature",
glue="pages",
publish = true,
monochrome = true)

public class TC001_JobDesc_Screenshot_Cu extends BaseClass{

}
