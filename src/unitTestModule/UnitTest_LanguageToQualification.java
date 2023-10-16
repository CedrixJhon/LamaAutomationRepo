package unitTestModule;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import admin_Locators.Language;
import admin_Locators.Qualifications;

public class UnitTest_LanguageToQualification {
	String driverPath = "C:\\Selenium Web Driver\\chromedriver-win64\\chromedriver.exe";
	public WebDriver driver;
	@BeforeTest
	public void login() {
		
		System.setProperty("webdriver.chrome.driver",driverPath);
		 ChromeOptions options = new ChromeOptions();
	       options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.admin.lamacare.com.au/signin"); 
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("lama.demo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password@123");
		driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();

			
	}
	
	@Test(priority = 1)
	public void Add_Admin_Language() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		FluentWait<WebDriver> fluwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
	try {
		//click admin module menu
				driver.findElement(By.xpath(Language.click_admin)).click();
				//click language in dropdown menu
				driver.findElement(By.xpath(Language.click_languagDropdown)).click();
				//click new language button
				
				fluwait.until(visibilityOfElementLocated(By.xpath(Language.click_newLanguageButton))).click();
				//name field = Thailand
				Thread.sleep(2000);
				 fluwait.until(visibilityOfElementLocated(By.xpath(Language.name_Field))).sendKeys("Thailand");
				//code field = Thai
				WebElement actual_CodeField = driver.findElement(By.xpath(Language.code_Field));
				actual_CodeField.sendKeys("Thai");
				//click save
				  wait.until(visibilityOfElementLocated(By.xpath(Language.click_saveButton))).click();
		
	}catch(Throwable e) {
		System.out.println("There is an error adding language data");
		e.printStackTrace();
	}
		
		
	} 
	@Test(priority = 2)
	public void verifyInput_Admin_Language() {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		try {
			//inspect if datas are mapped
			 wait.until(visibilityOfElementLocated(By.xpath(Language.update_Icon))).click();
				String assigned_nameField ="Thailand";
				String assigned_codeField = "Thai";
				WebElement actualNameField = driver.findElement(By.xpath(Language.name_Field));
				WebElement actualCodeField = driver.findElement(By.xpath(Language.code_Field));
				Assert.assertEquals(actualNameField.getAttribute("value"), assigned_nameField,"Data mapping is incorrect.");
				Assert.assertEquals(actualCodeField.getAttribute("value"), assigned_codeField,"Data mapping is incorrect.");
				wait.until(visibilityOfElementLocated(By.xpath(Language.close))).click();
		}catch(Throwable e) {
			System.out.println("There is an error verifying added language data");
			e.printStackTrace();
		}
		 
	}
	@Test (priority = 3)
	public void updateAndVerify_Admin_Language() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		FluentWait<WebDriver> fluwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
		try {
			//update datas
			  wait.until(visibilityOfElementLocated(By.xpath(Language.update_Icon))).click();
				//name field = Singapore
				WebElement actual_NameField = wait.until(visibilityOfElementLocated(By.xpath(Language.name_Field)));
				actual_NameField.clear();
				actual_NameField.sendKeys("Singapore");
				//code field = SG
				WebElement actual_CodeField = driver.findElement(By.xpath(Language.code_Field));
				actual_CodeField.clear();
				actual_CodeField.sendKeys("SG");
				//click save
				  fluwait.until(visibilityOfElementLocated(By.xpath(Language.saveButton_Update))).click();
				//verify if the updated data is mapped correctly
				  wait.until(visibilityOfElementLocated(By.xpath(Language.update_Icon))).click();
					String assigned_nameField ="Singapore";
					String assigned_codeField = "SG";
					WebElement actualNameField = driver.findElement(By.xpath(Language.name_Field));
					WebElement actualCodeField = driver.findElement(By.xpath(Language.code_Field));
					Assert.assertEquals(actualNameField.getAttribute("value"), assigned_nameField,"Data mapping is incorrect.");
					Assert.assertEquals(actualCodeField.getAttribute("value"), assigned_codeField,"Data mapping is incorrect.");
					wait.until(visibilityOfElementLocated(By.xpath(Language.close))).click();
				  
		}catch(Throwable e) {
			System.out.println("There is an error while updating and verifying language data");
			e.printStackTrace();
		}
	}
	@Test(priority = 4)
	public void verifyDelete_Admin_Language() throws InterruptedException {
		try {
			//delete
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
					wait.until(visibilityOfElementLocated(By.xpath(Language.deleteButton))).click();
					wait.until(visibilityOfElementLocated(By.xpath(Language.click_DeleteButton))).click();
					Thread.sleep(4000); 
		}catch(Throwable e) {
			System.out.println("There is an error while deleting language data");
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 5)
	public void Add_Admin_Qualifications() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		try {
			//click admin module menu
			driver.findElement(By.xpath(Qualifications.click_admin)).click();
			//click Qualifications in dropdown
			driver.findElement(By.xpath(Qualifications.click_qualificationsDropdown)).click();
			//click new qualifications button
			wait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_newQualificationsButton))).click();
			Thread.sleep(1000);
			//Click type dropdown
			wait.until(visibilityOfElementLocated(By.cssSelector(Qualifications.click_typeDropdown))).click();
			wait.until(visibilityOfElementLocated(By.cssSelector(Qualifications.click_type_Training))).click();
			//Qualifications field
			WebElement qfield = driver.findElement(By.xpath(Qualifications.qualificationsField));
			qfield.sendKeys("Atleast High School Graduate");
			//description field
			WebElement dfield = driver.findElement(By.xpath(Qualifications.descriptionField));
			dfield.sendKeys("The Candidate must posess atleast a High School Diploma");
			//click save
			wait.until(visibilityOfElementLocated(By.xpath(Qualifications.saveButton))).click();
		}catch(Throwable e) {
			System.out.println("There is an error adding a Qualification");
			e.printStackTrace();
		}
	}
	@Test(priority = 6)
	public void verifyInput_Admin_Qualifications() {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			//inspect if datas are mapped
		 wait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_updateIcon))).click();
		String assigned_qualificationsField ="Atleast High School Graduate";
		String assigned_descriptionField = "The Candidate must posess atleast a High School Diploma";
		String assigned_type = "Training";
		WebElement actualType = driver.findElement(By.xpath(Qualifications.verify_typeDropDownInput));
		WebElement actualQualificationsField = driver.findElement(By.xpath(Qualifications.qualificationsField));
		WebElement actualDescriptionField = driver.findElement(By.xpath(Qualifications.descriptionField));
		Assert.assertEquals(actualType.getText(), assigned_type ,"Data mapping is incorrect.");
		Assert.assertEquals(actualQualificationsField.getAttribute("value"), assigned_qualificationsField,"Data mapping is incorrect.");
		Assert.assertEquals(actualDescriptionField.getAttribute("value"), assigned_descriptionField,"Data mapping is incorrect.");
		wait.until(visibilityOfElementLocated(By.xpath(Qualifications.close))).click();
	}
	@Test(priority = 7)
	public void updateAndVerify_Admin_Qualifications() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 FluentWait<WebDriver> fluwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
		 //click update icon
		 wait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_updateIcon))).click();
	
		 
		 //update the type dropdown
		 fluwait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_updateType))).click();
		 Thread.sleep(3000);
			fluwait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_type_Experience))).click();
	
		 //update the qualifications field
		 WebElement updateQualifications_Field = driver.findElement(By.xpath(Qualifications.qualificationsField));
		 updateQualifications_Field.clear();
		 updateQualifications_Field.sendKeys("AtLeast 1 year Experience");
		
		 //update the description field
		 WebElement updateDescription_Field = driver.findElement(By.xpath(Qualifications.descriptionField));
		 updateDescription_Field.clear();
		 updateDescription_Field.sendKeys("The candidate must Possess atleast 1 year of experience in the related field");
	
		 //save
		 wait.until(visibilityOfElementLocated(By.xpath(Qualifications.saveButton))).click();
		
		 //click update icon
		 wait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_updateIcon))).click();
		
	
		 String assigned_Type = "Experience";
		 String assigned_QualificationsField = "AtLeast 1 year Experience";
		 String assigned_DescriptionField  = "The candidate must Possess atleast 1 year of experience in the related field";
		 
		 WebElement actualType = driver.findElement(By.xpath(Qualifications.verifyAndUpdate_typeDropDownInput));
		 WebElement actualQualifications_Field = driver.findElement(By.xpath(Qualifications.qualificationsField));
		 WebElement actualDescription_Field = driver.findElement(By.xpath(Qualifications.descriptionField));
		 
		 //inspect if datas are mapped
		 Assert.assertEquals(actualType.getText(), assigned_Type,"Data mapping is incorrect.");
		 Assert.assertEquals(actualQualifications_Field.getAttribute("value"), assigned_QualificationsField,"Data mapping is incorrect.");
		 Assert.assertEquals(actualDescription_Field.getAttribute("value"), assigned_DescriptionField,"Data mapping is incorrect.");
		 
		 //close
		 wait.until(visibilityOfElementLocated(By.xpath(Qualifications.close))).click();
	}
	@Test(priority = 8)
	public void delete_Admin_Qualifications() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//delete the data 
		wait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_deleteIcon))).click();
		wait.until(visibilityOfElementLocated(By.xpath(Qualifications.click_continueButton))).click();
		Thread.sleep(4000);
	}
	
}
