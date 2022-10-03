package org.Practicepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import static org.Practicepage.Pracicepage.driver;

public class AddonAddress {

    @FindBy(xpath="")
    WebElement Addon_Button;
    @FindBy(xpath="")
    WebElement Addon_dropdown;
    @FindBy(xpath="")
    WebElement Street;
    @FindBy(xpath="")
    WebElement City;
    @FindBy(xpath="")
    WebElement Usethis;
    @FindBy(xpath="")
    WebElement Continue;
    public WebDriverWait wait=new WebDriverWait(driver,6);

    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setExperimentalOption("debuggerAddress","localhost:57315");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("");
        driver.manage().window().maximize();

    }
    @Test
    public void AddonAddress() throws IOException {
        wait.until(ExpectedConditions.titleIs(""));
        takescreenshot("Addressed page");
       Addon_Button.click();
       wait.until(ExpectedConditions.visibilityOf(Addon_dropdown));
        takescreenshot("Addressed page");
       Select options=new Select(Addon_dropdown);
        options.selectByValue("");
        Street.sendKeys("");
        City.sendKeys("");

    }

    public static void takescreenshot( String fileName ) throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C://Users//manikandansr//IdeaProjects//Practice_Cucumber//src//Screensot"
                + "src/Screensot" +fileName+".jpg"));
    }


}
