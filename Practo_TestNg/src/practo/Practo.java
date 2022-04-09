package practo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\G-1-2043\\Desktop\\capita\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://accounts.practo.com/login?next=%2Fcheckid_request&intent=fabric");
		 //driver.findElement(By.className("nav-login-mobile btn-border nav-interact")).click();//nav-login-mobile btn-border nav-interact

		 WebElement uname = driver.findElement(By.id ("username"));// username
		 uname.sendKeys("7888198010"); 
		 driver.findElement(By.id("password")).sendKeys("Jeevan@8120");// password
		 driver.findElement(By.id("login")).click();//login  // 
		 
		

	}

}