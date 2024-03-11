import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.*;
import pojo.User;

import static org.junit.Assert.assertTrue;

public class LoginTest extends Base {

    private User user;

    @Test
    @DisplayName("Проверка входа по кнопке 'Войти в аккаунт' на главной странице")
    public void loginMainPageLoginButtonTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();
            mainPage.clickLoginButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            assertTrue(mainPage.createOrderButtonDisplayed());
        } finally {
            deleteUser(user);
        }
    }

    @Test
    @DisplayName("Проверка входа по кнопке 'Личный кабинет' на главной странице")
    public void loginMainPagePersonalAccountButtonTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            assertTrue(mainPage.createOrderButtonDisplayed());
        } finally {
            deleteUser(user);
        }
    }

    @Test
    @DisplayName("Проверка входа по кнопке 'Войти' на странице регистрации")
    public void loginRegistrationPageLoginButtonTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.clickRegisterLink();

            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.waitForLoadRegisterPage();
            registerPage.clickLoginLink();

            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            assertTrue(mainPage.createOrderButtonDisplayed());
        } finally {
            deleteUser(user);
        }
    }

    @Test
    @DisplayName("Проверка входа по кнопке 'Войти' в форме восстановления пароля")
    public void loginForgotPasswordPageLoginButtonTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.clickRestorePasswordLink();

            ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
            forgotPasswordPage.waitForLoadForgotPasswordPage();

            forgotPasswordPage.clickLoginLink();

            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            assertTrue(mainPage.createOrderButtonDisplayed());
        } finally {
            deleteUser(user);
        }
    }

}