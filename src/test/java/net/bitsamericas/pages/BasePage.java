package net.bitsamericas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        this.driver = driver;
    }

    public void navigateToPage(String url) {
        getDriver().navigate().to(url);
    }

    public WebDriverWait getWait(){
        return wait;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    public void dispose(){
        if(null != driver){
            driver.quit();
        }
    }
}
