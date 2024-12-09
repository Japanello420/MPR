package com.example.capybara.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCapybaraPage {
    private WebDriver webDriver;

    @FindBy(id="name")
    private WebElement nameInput;

    @FindBy(id="color")
    private WebElement colorInput;

    @FindBy(id="submit")
    private WebElement submitButton;

    public AddCapybaraPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public AddCapybaraPage open(){
        webDriver.get("http://localhost:8080/capybara/addForm");

        return this;
    }

    public AddCapybaraPage fillInNameInput(String text){
        this.nameInput.sendKeys(text);

        return this;
    }

    public AddCapybaraPage fillInColorInput(String text){
        this.colorInput.sendKeys(text);

        return this;
    }

    public AddCapybaraPage submitForm(){
        this.submitButton.click();

        return this;
    }
}
