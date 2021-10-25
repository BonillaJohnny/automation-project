package net.bitsamericas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

    private static final String PAGE_HOME_URL = "https://bits-angular-stg.dev01.bitsamericas.net/";

    @FindBy(xpath = "//*[@id=\"block-navbar\"]/nav/div/ul[1]/li[6]/a")
    private WebElement linkContactenos;

    @FindBy(id = "contact_us__correo_electronico")
    private WebElement emailTextField;

    @FindBy(id = "contact_us__nombre")
    private WebElement nameTextField;

    @FindBy(id = "contact_us__telefono")
    private WebElement phoneTextField;

    @FindBy(id = "contact_us__organizacion")
    private WebElement organizationTextField;

    @FindBy(id = "contact_us__ciudad")
    private WebElement ciudadTextField;

    //@FindBy(id = "contact_us__terms_of_service")
    @FindBy(xpath = "//*[@id=\"contact_us__terms_of_service\"]")
    private WebElement termsOfServiceCheckbox;

    @FindBy(className = "terminos_grupo")
    private WebElement termsOfServiceGroup;

    @FindBy(id = "rc-anchor-container")
    private WebElement captchaGroup;

    //@FindBy(className = "btn btn-primary")
    @FindBy(xpath = "//*[@id=\"formulario_contacto\"]/button")
    private WebElement submitButton;

    @FindBy(className = "success")
    private WebElement sucessText;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateToPage(PAGE_HOME_URL);
    }

    public void navigateToContactPage() {
        getWait().until(ExpectedConditions.elementToBeClickable(linkContactenos));
        linkContactenos.click();
    }

    public void fillInformationData(String name, String email) {
        emailTextField.sendKeys(email);
        nameTextField.sendKeys(name);
    }

    public void fillPhoneAndOrganizationInformation(String phone, String organization) {
        phoneTextField.sendKeys(phone);
        organizationTextField.sendKeys(organization);
    }

    public void checkTermsOfService() {
        getWait().until(ExpectedConditions.elementToBeClickable(termsOfServiceGroup));
        new Actions(getDriver()).moveToElement(termsOfServiceGroup, 1, 1).click().perform();
    }

    public void checkCaptcha() {
        getWait().until(ExpectedConditions.elementToBeClickable(captchaGroup));
        new Actions(getDriver()).moveToElement(captchaGroup, 1, 1).click().perform();
    }

    public void submitInformation() {
        getWait().until(ExpectedConditions.elementToBeClickable(submitButton));
        if(!submitButton.isEnabled()) {
            System.out.println("esta inhabilitado====>>>>>>>");
        }
        submitButton.click();
    }

    public String getSuccessMessage() {
        getWait().until(ExpectedConditions.elementToBeClickable(sucessText));
        return sucessText.getText();
    }

}
