package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public static void captureScreeShot(WebDriver driver,String screenShotName){
        Path destination = Paths.get("./ScreenShots",screenShotName+".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream output = new FileOutputStream(destination.toString());
            output.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            output.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenShot: " + e.getMessage());
        }
    }
}
