package com.qa.stardewproject.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:stardew-schema.sql",
		"classpath:stardew-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SeleniumTests {

	@LocalServerPort
	private int port;

	private RemoteWebDriver driver;

	private WebDriverWait wait;

	@BeforeEach
	void setup() {

		ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);
		this.driver = new ChromeDriver(options);
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		this.driver.manage().window().maximize();

	}

	@Test
	void deleteVillager() {

		this.driver.get("http://localhost:" + port);

		WebElement addName = this.driver.findElement(By.id("villagerName"));
		WebElement addBirthDay = this.driver.findElement(By.id("birthDay"));
		WebElement addBirthSeason = this.driver.findElement(By.id("birthSeason"));
		WebElement addFaveItems = this.driver.findElement(By.id("faveItems"));
		WebElement addLeastFaveItems = this.driver.findElement(By.id("leastFaveItems"));

		addName.sendKeys("DeleteName");
		addBirthDay.sendKeys("6");
		addBirthSeason.sendKeys("Summer");
		addFaveItems.sendKeys("Delete");
		addLeastFaveItems.sendKeys("Delete" + "\n");

		WebElement deleteButton = this.driver.findElement(By.id("DeleteDeleteName"));

		deleteButton.click();

		WebElement card = this.driver.findElement(By.cssSelector("#output"));

		Assertions.assertFalse(card.getText().contains("DeleteName"));

	}

	@Test
	void testCreate() {
		this.driver.get("http://localhost:" + port);

		WebElement addName = this.driver.findElement(By.id("villagerName"));
		WebElement addBirthDay = this.driver.findElement(By.id("birthDay"));
		WebElement addBirthSeason = this.driver.findElement(By.id("birthSeason"));
		WebElement addFaveItems = this.driver.findElement(By.id("faveItems"));
		WebElement addLeastFaveItems = this.driver.findElement(By.id("leastFaveItems"));

		addName.sendKeys("Create");
		addBirthDay.sendKeys("6");
		addBirthSeason.sendKeys("Spring");
		addFaveItems.sendKeys("Beer");
		addLeastFaveItems.sendKeys("Garbage" + "\n");

		WebElement resetButton = this.driver.findElement(By.xpath("//*[@id=\"villagerForm\"]/div[6]/button[1]"));

		resetButton.click();

		WebElement card = this.driver.findElement(By.cssSelector("#output"));

		Assertions.assertTrue(card.getText().contains("Create"));
		Assertions.assertTrue(card.getText().contains("Birthday: spring 6"));
		Assertions.assertTrue(card.getText().contains("Favourite Items: Beer"));
		Assertions.assertTrue(card.getText().contains("Least Favourite Items: Garbage"));

	}

	@Test
	void readVillager() {

		this.driver.get("http://localhost:" + port);

		WebElement addName = this.driver.findElement(By.id("villagerName"));
		WebElement addBirthDay = this.driver.findElement(By.id("birthDay"));
		WebElement addBirthSeason = this.driver.findElement(By.id("birthSeason"));
		WebElement addFaveItems = this.driver.findElement(By.id("faveItems"));
		WebElement addLeastFaveItems = this.driver.findElement(By.id("leastFaveItems"));

		addName.sendKeys("Read");
		addBirthDay.sendKeys("6");
		addBirthSeason.sendKeys("Spring");
		addFaveItems.sendKeys("Read");
		addLeastFaveItems.sendKeys("Read" + "\n");

		WebElement card = this.driver.findElement(By.cssSelector("#output"));

		Assertions.assertTrue(card.getText().contains("Read"));
		Assertions.assertTrue(card.getText().contains("Birthday: spring 6"));
		Assertions.assertTrue(card.getText().contains("Favourite Items: Read"));
		Assertions.assertTrue(card.getText().contains("Least Favourite Items: Read"));

	}

	@Test
	void testUpdate() {

		this.driver.get("http://localhost:" + port);

		WebElement addName = this.driver.findElement(By.id("villagerName"));
		WebElement addBirthDay = this.driver.findElement(By.id("birthDay"));
		WebElement addBirthSeason = this.driver.findElement(By.id("birthSeason"));
		WebElement addFaveItems = this.driver.findElement(By.id("faveItems"));
		WebElement addLeastFaveItems = this.driver.findElement(By.id("leastFaveItems"));

		addName.sendKeys("Update");
		addBirthDay.sendKeys("6");
		addBirthSeason.sendKeys("Spring");
		addFaveItems.sendKeys("Update");
		addLeastFaveItems.sendKeys("Update" + "\n");

		WebElement updateButton = this.driver.findElement(By.cssSelector("#UpdateUpdate"));

		updateButton.click();

		WebElement updateName = this.driver.findElement(By.id("updateVillagerName"));

		updateName.sendKeys("Name" + "\n");

		WebElement card = this.driver.findElement(By.cssSelector("#output"));

		Assertions.assertTrue(card.getText().contains("UpdateName"));
	}

}
