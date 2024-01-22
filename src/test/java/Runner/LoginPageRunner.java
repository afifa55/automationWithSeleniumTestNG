package Runner;

import Base.Setup;
import Page.DashboardPage;
import Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageRunner extends Setup {
    @Test
    public void dologintest(){
        LoginPage login = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        login.dologin("Admin","admin123");

        WebElement headerText= driver.findElement(By.tagName("h6"));
        String header_actual= headerText.getText();
        String header_expected="Dashboard";
        Assert.assertEquals(header_actual,header_expected);
        WebElement profilePictureElement= driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(profilePictureElement.isDisplayed());

    }
    @Test
    public void searchEmployeeinfo() throws InterruptedException {
        DashboardPage dashboardPage= new DashboardPage(driver);
        Thread.sleep(3000);
        dashboardPage.menus.get(1).click();
        Thread.sleep(5000);
        String isUserFound = driver.findElements(By.className("oxd-text--span")).get(12).getText();
        Thread.sleep(3000);
        Assert.assertTrue(isUserFound.contains("Records Found"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
}
