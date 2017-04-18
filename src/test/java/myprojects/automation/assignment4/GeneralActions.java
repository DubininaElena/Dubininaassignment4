package myprojects.automation.assignment4;


import myprojects.automation.assignment4.model.ProductData;
import myprojects.automation.assignment4.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogueLink = By.cssSelector("#subtab-AdminCatalog");
    private By productLink = By.cssSelector("#subtab-AdminProducts");
    private By addProduct = By.cssSelector("#page-header-desc-configuration-add");
    private By fieldName = By.cssSelector("#form_step1_name_1");
    private By qtyButton = By.cssSelector("#tab_step3");
    private By fieldQty = By.cssSelector("#form_step3_qty_0");
    private By priceButton = By.cssSelector("#tab_step2");
    private By fieldPrice1 = By.cssSelector("#form_step2_price");
    private By fieldPrice = By.cssSelector("#form_step2_price_ttc");
    private By allProduct = By.xpath("//a[@class='all-product-link pull-xs-left pull-md-right h4']");
    private By openProductTest = By.linkText("ProductTest");



    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) throws InterruptedException {
        driver.navigate().to(Properties.getBaseAdminUrl());
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
    }

     public void createProduct (String name, String qty, String price) throws InterruptedException{
         wait.until(ExpectedConditions.visibilityOfElementLocated(catalogueLink));
         driver.findElement(this.catalogueLink);
         driver.findElement(this.productLink);
         Actions actions = new Actions(driver);
         actions.moveToElement(driver.findElement(this.catalogueLink));
         actions.click(driver.findElement(this.productLink))
                 .build().perform();

         wait.until(ExpectedConditions.visibilityOfElementLocated(addProduct));
         driver.findElement(this.addProduct).click();

         driver.findElement(this.fieldName).sendKeys(name);
         driver.findElement(this.qtyButton).click();
         driver.findElement(this.fieldQty).sendKeys(qty);
         driver.findElement(this.priceButton).click();
         driver.findElement(this.fieldPrice).sendKeys(price);

         driver.findElement(this.fieldPrice1).sendKeys(Keys.chord(Keys.CONTROL, "o"));


     }
     public void checkShow () throws InterruptedException{
        driver.navigate().to(Properties.getBaseUrl());
        driver.findElement(this.allProduct).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#category")).getText().contains("ProductTest"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(openProductTest));
        driver.findElement(this.openProductTest).click();


     }
     public void checkEquel()throws InterruptedException{
        Assert.assertTrue(driver.findElement(By.cssSelector(".h1")).getText().contains("PRODUCTTEST"));
        Assert.assertTrue(driver.findElement(By.cssSelector("[itemprop='price']")).getText().contains("48,00 ₴"));
        Assert.assertTrue(driver.findElement(By.xpath(".//*[text()='12 Товары']/..")).getText().contains("12 Товары"));

     }

    }

