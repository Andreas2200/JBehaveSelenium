package steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

public class MySteps extends Steps {

    private static WebDriver driver = null;

    @Given("the browser is open")
    public void openBrowser() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        driver.manage().deleteAllCookies();
    }

    @Given("the page $site is displayed")
    public void navigateToPage(String site) {

        driver.get(site);

    }

    @When("I search for $query")
    public void clickOn(String query) {

        WebElement cookieOption = driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div"));
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]"));
        cookieOption.click();
        searchField.sendKeys(query);
        searchField.sendKeys(" ");
        searchButton.click();
    }

    @Then("the content $content is displayed")
    public void checkContent(String content) {

        Assert.assertEquals(content, driver.findElement(By.xpath("//*[contains(text(),'" + content + "')]")).getText());

    }

    @Then("the system shows results for more cities than just $city")
    public void checkHomepage(String city) {
        WebElement listing2 = driver.findElement(By.id("listing2"));
        String listing2City = listing2.findElement(By.className("city")).getText();

        Assert.assertNotEquals(city,listing2City);
    }

    @When("$name searches for $city with certain criteria")
    public void searchCity(String name, String city) {
        WebElement searchInput = driver.findElement(By.className("search-input"));
        WebElement submitButton = driver.findElement(By.className("front-search-button"));

        searchInput.sendKeys(city);
        submitButton.click();
    }

    @Then("the system shows a full list of all available listings in $city that matches criteria")
    public void showContent(String city) {
        WebElement[] listings = driver.findElements(By.className("apartmentCard")).toArray(new WebElement[0]);

        for (int i = 0; i < listings.length; i++) {
            String listingCity = listings[i].findElement(By.className("city")).getText();
            Assert.assertTrue(listingCity.contains(city));
        }

    }

    @Then("he chooses a listing")
    public void chooseFirstListing() {
        WebElement[] listings = driver.findElements(By.className("apartmentCard")).toArray(new WebElement[0]);
        listings[0].click();
    }

    @Then("the contact information of the owner of that listing is presented")
    public void seeContactInfo() {
        WebElement realtorContact = driver.findElement(By.id("realtorContact"));
        Assert.assertNotNull(realtorContact);
    }

    @Given("the unfiltered list is presented to $name")
    public void seeList() {
        WebElement[] listings = driver.findElements(By.className("apartmentCard")).toArray(new WebElement[0]);
        Assert.assertNotNull(listings);
    }

    @When("he types $price range into price range field")
    public void enterPrice(String price) {
        WebElement priceRange = driver.findElement(By.id("rent"));
        Assert.assertNotNull(priceRange);
        priceRange.sendKeys(price);
    }

    @When("he clicks on amount of rooms he wishes")
    public void amountRooms() {
        WebElement roomRange = driver.findElement(By.id("rooms"));
        Assert.assertNotNull(roomRange);
        roomRange.sendKeys("3");
    }

    @When("he clicks on pets allowed")
    public void selectPets() {
        WebElement pets = driver.findElement(By.id("animals"));
        Assert.assertNotNull(pets);
        pets.sendKeys(" ");
    }

    @When("he clicks on own bathroom")
    public void selectBathroom() {
        WebElement bathroom = driver.findElement(By.id("bath"));
        Assert.assertNotNull(bathroom);
        bathroom.sendKeys(" ");
    }

    @Then("the listings get narrowed down based on the criteria")
    public void seeListNarrow() {
        WebElement[] listings = driver.findElements(By.className("apartmentCard")).toArray(new WebElement[0]);
        Assert.assertNotNull(listings);
    }

    @Then("listings in $city that matches above criteria are presented to $name")
    public void seeListNew() {
        WebElement[] listings = driver.findElements(By.className("apartmentCard")).toArray(new WebElement[0]);
        Assert.assertNotNull(listings);
    }

    @AfterStory
    public void closeSession() {
        driver.quit();
    }

}