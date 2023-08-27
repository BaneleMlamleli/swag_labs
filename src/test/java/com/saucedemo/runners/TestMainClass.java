package com.saucedemo.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\com\\saucedemo\\features",
        // TODO: Add "com.saucedemo.utility"  in the glue for screenshot capturing
        glue = { "com.saucedemo.stepdef"}, 
        monochrome = true, 
        plugin = { "pretty", "html:target/reports/html_report.html", "json:target/reports/json_report.json", "junit:target/reports/xml_report.xml" }, 
        tags = "@login"
)
public class TestMainClass{
    
}