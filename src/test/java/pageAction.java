import org.example.LoginLocators1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class pageAction {
    LoginLocators1 locate1 = new LoginLocators1();
    Hooks hooks = new Hooks();

    @Test
    public void invalidLoginIntoSystem() throws InterruptedException {

        // This part for opening the browser also entering invalid credentials
        hooks.GetBrowser().navigate().to("https://stage.glamera.com/");
        hooks.GetBrowser().manage().window().maximize();
        hooks.GetBrowser().findElement(locate1.phoneNumber()).sendKeys("01207546229");
        hooks.GetBrowser().findElement(locate1.enterPassword()).sendKeys("P@ssw0rd");
        hooks.GetBrowser().findElement(locate1.clickLoginButton()).click();


        //This part for the website to open to get popup text to save it
        WebDriverWait LoginWait = new WebDriverWait(hooks.GetBrowser(),Duration.ofSeconds(10));
        LoginWait.until(ExpectedConditions.presenceOfElementLocated(locate1.invalidPopUp()));
        String URL = hooks.GetBrowser().findElement(locate1.invalidPopUp()).getText();
        System.out.println("\n"+URL+"\n");

        //This part to assert that pop-up appears successfully
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hooks.GetBrowser().findElement(locate1.invalidPopUp()).getText(),"Invaild user name or password", "\n"+"FAILED"+"\n");
        softAssert.assertAll();
        hooks.QuitBrowser();
    }

}
