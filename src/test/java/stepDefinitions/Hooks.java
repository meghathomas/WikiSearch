package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.Utils;

public class Hooks{
	
	stepDef stepdefsObject;
	
	public Hooks(stepDef stepdefsObject) {
		this.stepdefsObject = stepdefsObject;
	}

	@Before
	public void setUp(Scenario scenario) {
		this.stepdefsObject.scenario=scenario;
		Utils.initiateDriver();
	}

	@AfterStep
	public void screenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			Utils.takeScreenShot(scenario);
		}
	}
	
	@After
    public void afterScenario(){	
		Utils.quitBrowser();
    }
	
}
