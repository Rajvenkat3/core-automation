package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\hp\\eclipse-workspace\\FacebookLogin\\src\\test\\java",glue="org.stepdefinition",
dryRun = false)
public class RunnerClass {

}
