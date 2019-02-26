package com.rs.cucumber.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		plugin = {"pretty", 
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags = "@login",
		features="src/test/resources/features/login.feature",
		glue="com.rs.cucumber.steps"
)
public class LoginFeatureRunner {
		
	@Test
	public void runCukes() {
		
		new TestNGCucumberRunner(getClass()).runCukes();
	}
}

