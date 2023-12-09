package com.swag_labs.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\com\\swag_labs\\features",
        // TODO: Add "com.saucedemo.utility"  in the glue for screenshot capturing
        glue = { "com.swag_labs.stepdef"}, 
        monochrome = true, 
        plugin = { "pretty", "html:target/reports/html_report.html", "json:target/reports/json_report.json", "junit:target/reports/xml_report.xml" },
        tags = "@CheckoutInformation"
)
public class TestMainClass{
    
}