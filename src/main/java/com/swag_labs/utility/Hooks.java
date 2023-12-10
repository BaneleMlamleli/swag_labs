package com.swag_labs.utility;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.swag_labs.core.BaseClass;

import io.cucumber.java.*;
// import javax.imageio.ImageIO;
// import ru.yandex.qatools.ashot.AShot;
// import ru.yandex.qatools.ashot.Screenshot;
// import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Hooks extends BaseClass {

    @After
    public void afterMethodScenario(Scenario sc) {
        System.out.println("This will run after the scenarios");
        if (sc.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", sc.getName());
        } else {
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", sc.getName());
        }
    }

    // TODO: Use the Ashot library to take screenshot of the entire page not just the screen visible section of the website page
    // @After
    // public void afterMethodScenario(Scenario scenario) {
    //     try {
    //         if (scenario.isFailed()) {
    //             Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(webDriver);
    //             ImageIO.write(screenshot.getImage(), "png", new File("/target/reports/" + scenario.getName() + ".png"));
    //             // Screenshot screenshot = new AShot().takeScreenshot(webDriver);
    //             // File image = new File("/target/reports/"+scenario.getName()+".png");
    //             // ImageIO.write(screenshot.getImage(), "png", image);
    //             // scenario.attach(null, null, null);
    //         }
    //     } catch (IOException e) {
    //         e.toString();
    //         e.printStackTrace();
    //     }
    // }
}