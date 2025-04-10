package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class MyStepDefinitions {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up Chrome driver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I open the browser and navigate to {string}")
    public void i_open_the_browser_and_navigate_to(String url) {
        driver.get(url);  // Navigate to the specified URL
    }

    @When("I select the state {string}")
    public void i_perform_actions_on_the_site(String state) {
        // Add your Selenium code here for interacting with elements
        WebElement stateDropdown = driver.findElement(By.xpath("//select[@name='_sfm_state[]']/following-sibling::div"));
        stateDropdown.click();
        WebElement washingtonOption = driver.findElement(By.xpath("//li[contains(text(), '"+state+"')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", washingtonOption);

        // Click on the "Washington" option
        washingtonOption.click();
    }


    @When("^I click the Search button$")
    public void iClickSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath("//li[@class='sf-field-submit']//input[@type='submit']"));
        searchButton.click();
    }

    @When("^I click the Reset button$")
    public void  iclickReset(){
        WebElement searchButton = driver.findElement(By.xpath("//li[@class='sf-field-reset']//a"));
        searchButton.click();
    }


    @Then("I verify {string} results")
    public void i_verify_the_site_functions_as_expected(String numerOfResults) {
        WebElement resultsDiv = driver.findElement(By.className("results-found-info"));

        // Get the text inside the div
        String resultsText = resultsDiv.getText();

        System.out.println("Found "+ numerOfResults+" Results");
        Assert.assertTrue(resultsText.contains("Found "+ numerOfResults+" Results"));

    }

    @Then("I search for {string}")
    public void SearchForKeyWord(String keyWord){

        WebElement searchBox =driver.findElement(By.xpath("//div[@class='input-container']/input[@class='sf-input-text']"));
        searchBox.click();
        searchBox.sendKeys(keyWord);

    }

    @Then("I click search")
    public void search(){
        WebElement searchButton = driver.findElement(By.xpath("//li[@class='sf-field-submit']//input[@type='submit']"));
        searchButton.click();
    }

    @Then("I select Funding Source {string}")
    public void SelectFundingSource(String source) throws InterruptedException {
        WebElement stateDropdown = driver.findElement(By.xpath("//select[@name='_sfm_funding_source[]']/following-sibling::div"));
        stateDropdown.click();
        Thread.sleep(1000);
        WebElement fedralOnly = driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+source+"']"));
        fedralOnly.click();
    }

    @Then("I select Spans {string}")
    public void selectSpans(String span) throws InterruptedException {
        WebElement spanDropdown = driver.findElement(By.xpath("//select[@name='_sfm_spans[]']/following-sibling::div"));
        spanDropdown.click();
        Thread.sleep(1000);
        WebElement greater3span= driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+span+"']"));
        greater3span.click();
    }

    @Then("I select Beam Material {string}")
    public void selectBeamMaterial(String material) throws InterruptedException{
        WebElement spanDropdown = driver.findElement(By.xpath("//select[@name='_sfm_beam_material[]']/following-sibling::div"));
        spanDropdown.click();
        Thread.sleep(1000);
        WebElement greater3span= driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+material+"']"));
        greater3span.click();

    }

    @Then("I select the Construction Equipment Category {string}")
    public void selectConstructionEquipement(String category) throws InterruptedException{

        WebElement spanDropdown = driver.findElement(By.xpath("//select[@name='_sfm_construction_equipment[]']/following-sibling::div"));
        spanDropdown.click();
        Thread.sleep(1000);
        WebElement lateralSide= driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+category+"']"));
        lateralSide.click();

    }

    @Then("I select the Traffic Impact Category {string}")
    public void selectTrafficImpactCategory(String category) throws InterruptedException{

        WebElement trafficImpact = driver.findElement(By.xpath("//select[@name='_sfm_impact_category[]']/following-sibling::div"));
        trafficImpact.click();
        Thread.sleep(1000);
        WebElement tire1= driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+category+"']"));
        tire1.click();
    }

    @Then("I select the location {string}")
    public void  selectLocation(String location) throws InterruptedException{

        WebElement trafficImpact = driver.findElement(By.xpath("//select[@name='_sfm_location[]']/following-sibling::div"));
        trafficImpact.click();
        Thread.sleep(1000);
        WebElement tire1= driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+location+"']"));
        tire1.click();
    }

    @Then("I select the Average Daily Traffic Range {string} to {string}")
    public void selectaverageDailyTraffic(String from, String to) throws InterruptedException {

        WebElement avgMin = driver.findElement(By.xpath("//li[@class='sf-field-post-meta-average_daily_traffic_at_time_of_construction']//input[@class='sf-input-range-number sf-range-min sf-input-number']"));
        avgMin.click();
        avgMin.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMin.sendKeys(from);

        WebElement avgMax=driver.findElement(By.xpath("//li[@class='sf-field-post-meta-average_daily_traffic_at_time_of_construction']//input[@class='sf-input-range-number sf-range-max sf-input-number']"));
        avgMax.click();
        avgMax.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMax.sendKeys(to);

    }



    @Then("I select the Year built range {string} to {string}")
    public void selectYearBuilt(String from, String to) throws InterruptedException {

        WebElement avgMin = driver.findElement(By.xpath("//li[@class='sf-field-post-meta-year_abc_built']//input[contains(@class, 'sf-input-range-number sf-range-min sf-input-number')]"));
        avgMin.click();
        avgMin.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMin.sendKeys(from);

        WebElement avgMax=driver.findElement(By.xpath("//li[@class='sf-field-post-meta-year_abc_built']//input[contains(@class, 'sf-input-range-number sf-range-max sf-input-number')]"));
        avgMax.click();
        avgMax.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMax.sendKeys(to);

    }

    @Then ("I select the total bridge length range {string} to {string}")
    public void selectBridgeLengthRange(String from , String to) throws InterruptedException{

        WebElement avgMin = driver.findElement(By.xpath("//li[@class='sf-field-post-meta-total_bridge_length_ft']//input[contains(@class, 'sf-input-range-number sf-range-min sf-input-number')]"));
        avgMin.click();
        avgMin.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMin.sendKeys(from);

        WebElement avgMax=driver.findElement(By.xpath("//li[@class='sf-field-post-meta-total_bridge_length_ft']//input[contains(@class, 'sf-input-range-number sf-range-max sf-input-number')]"));
        avgMax.click();
        avgMax.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMax.sendKeys(to);
    }

    @Then("I select the max span length range {string} to {string}")
    public void selectMaxSpanLength(String from , String to) throws InterruptedException{

        WebElement avgMin = driver.findElement(By.xpath("//li[@class='sf-field-post-meta-max_span_length_ft']//input[contains(@class, 'sf-input-range-number sf-range-min sf-input-number')]"));
        avgMin.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMin.sendKeys(from);

        WebElement avgMax=driver.findElement(By.xpath("//li[@class='sf-field-post-meta-max_span_length_ft']//input[contains(@class, 'sf-input-range-number sf-range-max sf-input-number')]"));
        avgMax.sendKeys(Keys.CONTROL + "a"); // Select all existing text
        avgMax.sendKeys(to);
    }
    @After
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();  // Close the browser
//        }
    }
}
