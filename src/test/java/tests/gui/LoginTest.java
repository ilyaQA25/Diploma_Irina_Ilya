package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {
    @Test
    public void correctLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps(driver);
        navigationSteps.successLogin(User.builder().build());
        //Assert
    }
}
