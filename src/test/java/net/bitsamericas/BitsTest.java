package net.bitsamericas;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber.xml"},
        features = "src/test/resources/features",
        glue = {"net.bitsamericas.steps"})
public class BitsTest {
}
