package com.bestbuy.cucumber.runner;

import com.bestbuy.testbase.TestBase;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/bestbuy/cucumber/steps",
        tags = "@smoke"
)
public class CucumberRunner extends TestBase {

}
