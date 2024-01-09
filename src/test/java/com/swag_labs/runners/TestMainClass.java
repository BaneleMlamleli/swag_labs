package com.swag_labs.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\com\\swag_labs\\features",
        glue = { "com.swag_labs.stepdef", "com.swag_labs.utility"}, 
        monochrome = true, 
        plugin = { "pretty", "html:target/reports/html_report.html", "json:target/reports/json_report.json", "junit:target/reports/xml_report.xml" },
        tags = "@Cart"
)
public class TestMainClass{
    
}