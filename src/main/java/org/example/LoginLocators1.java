package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLocators1 {
    WebDriver driver;

    public By phoneNumber() {
        return new By.ByXPath("//*[@id=\"mat-input-0\"]");
    }

    public By enterPassword() {
        return new By.ByXPath("//*[@id=\"mat-input-1\"]");

    }


    public By clickLoginButton() {
        return new By.ByXPath("/html/body/app-root/app-auto-registration/app-login/section/form/div[2]/button");

    }

    public By invalidPopUp() {
        return new By.ByXPath("//*[@id=\"toast-container\"]");

    }


}