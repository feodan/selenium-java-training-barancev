package ru.st.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import ru.st.selenium.pages.TestBase;

public class LoginTest extends TestBase {

//  @BeforeMethod
//  public void mayBeLogout() {
//    if (app.getUserHelper().isLoggedIn()) {
//      app.getUserHelper().logout();
//    }
//  }
//
//  @Test
//  public void testLoginOK() throws Exception {
//    User user = new User().setLogin("admin").setPassword("admin");
//    app.getUserHelper().loginAs(user);
//    assertTrue(app.getUserHelper().isLoggedInAs(user));
//  }
//
//  @Test
//  public void testLoginFailed() throws Exception {
//    User user = new User().setLogin("admin").setPassword("wrong");
//    app.getUserHelper().loginAs(user);
//    // assertFalse(app.getUserHelper().isLoggedIn());
//    assertTrue(app.getUserHelper().isNotLoggedIn());
//  }

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void testUntitled() throws InterruptedException {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("войдите в личный кабинет")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("feodan@yandex.ru");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("co454540");
        driver.findElement(By.name("auth_submit")).click();
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
