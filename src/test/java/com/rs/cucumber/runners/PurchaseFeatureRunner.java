package com.rs.cucumber.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags = "@purchase",
		features="src/test/resources/features/purchase.feature",
		glue="com.rs.cucumber.steps"
)
public class PurchaseFeatureRunner {
		
	@Test
	public void runCukes() {
		
		new TestNGCucumberRunner(getClass()).runCukes();
	}
}

