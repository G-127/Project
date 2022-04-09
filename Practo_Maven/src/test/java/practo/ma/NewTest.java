package practo1;

import org.testng.annotations.Test;

//import automation.WebElement;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import practo.ma.ExcelData;	


public class NewTest {
	public static WebDriver driver;
	public static Properties prop;
	public static String sAppURL;
	public static String uname;
	public static String password;

	@Test(priority = 1)
	public void f() throws InterruptedException, IOException {
		System.out.println("Entered Test Method");
		Thread.sleep(3000);
		String[] data = ExcelData.readXL1();
		System.out.println(data[1]);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input"));
		search.clear();
		search.sendKeys(data[1]);
		WebElement sea = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div/input"));
		Thread.sleep(3000);
		
		sea.sendKeys("Hospital");
		sea.sendKeys(Keys.ENTER);
	}
	@Test(priority = 2)
	public void filterPracto() throws InterruptedException
	{
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//Thread.sleep(3000);

		// For Accredited Button
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/div")).click();
		// for 24*7 button
		 //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[1]/div/div/header/div[1]/div/div[3]/label/div")).click();
		// for Consult doctors online during Coronavirus outbreak
		String S = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/a/div/div[2]/h4")).getText();
		System.out.println('\n'+S);
		//IMax Multispeciality Hospital
		String S1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText();
		System.out.println('\n'+S1);
		//Umarji Mother & Child Care
		String S2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[2]/div[3]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText();
		System.out.println('\n'+S2);
		//Kedarnath General Hospital, Laparoscopy & Diabetic Foot Management
		String S3 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[2]/div[4]/div/div[1]/div[1]/div/div[2]/div/a/h2")).getText();
		System.out.println('\n'+S3);
		String S = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/a/div/div[2]/h4")).getText();
		System.out.println('\n'+S);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input"));
		search.clear();
		search.sendKeys(data[2]);*/

	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\G-1-2043\\Desktop\\capita\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
			prop = new Properties();
		} catch (Exception e) {
			e.printStackTrace();
		}

		prop.load(new FileInputStream("C:\\Users\\G-1-2043\\eclipse-workspace\\Practo_Maven\\Configurations\\login.properties"));
		sAppURL = prop.getProperty("sAppURL");
		uname = prop.getProperty("uname");
		password = prop.getProperty("password");
		System.out.println(sAppURL);
		System.out.println(uname);
		System.out.println(password);
		driver.get(sAppURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	@AfterTest
	public void afterTest() {
		// driver.close();

	}

}