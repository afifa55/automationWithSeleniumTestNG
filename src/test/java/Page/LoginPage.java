package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "username")
    WebElement txtusername;
    @FindBy(name = "password")
    WebElement txtpassword;
    @FindBy(css = "[type=submit")
    WebElement btnLogin;
    

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    public void dologin(String username,String password ){
        txtusername.sendKeys(username);
        txtpassword.sendKeys(password);
        btnLogin.click();
    }

}
