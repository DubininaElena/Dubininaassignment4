package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

    @Parameters({"login", "password","name", "qty", "price"})
    @Test

    public void createNewProduct(String login, String password, String name, String qty, String price) throws InterruptedException  {
        // TODO implement test for product creation
        actions.login(login, password);
        actions.createProduct(name, qty, price);
        actions.checkShow();
        actions.checkEquel();

    }
    // TODO implement logic to check product visibility on website
}

