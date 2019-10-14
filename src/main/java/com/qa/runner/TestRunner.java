package com.qa.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/user/IdeaProjects/n11.com/src/main/java/com/qa/features/n11.feature", glue = {
		"com/qa/stepdefinations",
		"com/qa/util" }, format = { "pretty", "html:test-output", "json:json_output/cucumber.json" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:output/extentReport.html" }, monochrome = true, dryRun = false, strict = true /*
																																				 * tags
																																				 * =
																																				 * {
																																				 * "@End2EndTest, @SmokeTest"
																																				 * }
																																				 */)

// features the path of the feature files
// glue the path of step definition files
// monochrome display the console output in a proper readable format
// dryRun to check the mapping is proper between feature file and step
// definition file
// format is output style on the page junit:junit_xml/cucumer.xml to generate
// different types of reporting
// strict it will check if any step is not defined in the step defination file
public class TestRunner {

	// ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as
	// @SmokeTest OR @RegressionTest
	// ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests
	// tagged as @SmokeTest AND @RegressionTest
	// ~@SmokeTest ignored

}
