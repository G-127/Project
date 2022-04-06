package practo.ma;

import org.testng.annotations.Test;
//import automation.WebElement;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	
  @Test
  public void f() {
	  
	
  }
  @BeforeTest
  public void beforeTest()throws FileNotFoundException, IOException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\G-1-2043\\Desktop\\capita\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
	  WebElement search = driver.findElement(By.xpath ("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input"));
		 search.clear();
		 search.sendKeys("Pune");
		 WebElement sea = driver.findElement(By.xpath ("//[@id=\"c-omni-container\"]/div/div[2]/div[1]/input"));//[@id="c-omni-container"]/div/div[2]/div[1]/input
		 sea.sendKeys("Hospital");
		 sea.sendKeys(Keys.RETURN);// //*[@id="container"]/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span
		 driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[1]/div/div/header/div[1]/div/div[2]/label/span/span")).click();
	  
	  WebDriver driver1 = null;
		Properties prop = null;
		String sAppURL=null;
		String username=null;
		String password=null;
		
		//This function is used to read data from specified cell of Excel sheet once you give Excelsheet name and path
		
				/*public static String HA_GF_readXL (int row, String column, String strFilePath) throws IOException 
				{
					
					File file =    new File("E:\Capita\Excelfile");
					FileInputStream inputStream = new FileInputStream(file);
					HSSFWorkbook wb=new HSSFWorkbook(inputStream);
					HSSFSheet sheet=wb.getSheet("location");
					HSSFRow row1=sheet.getRow(1);
							
					int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			        System.out.println(rowCount);
			        //iterate over all the row to print the data present in each cell.
			        for(int i=0;i<=rowCount;i++){
			            
			            //get cell count in a row
			            int cellcount=sheet.getRow(i).getLastCellNum();
			            System.out.println(cellcount);
			            //iterate over each cell to print its value
			            System.out.println("Row"+ i+" data is :");
			            
			            for(int j=0;j<cellcount;j++){
			                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
			            }
			            System.out.println();
			        }
			    
				//System.out.println("NO MATCH FOUND IN GIVEN FILE: PROBLEM IS COMING FROM DATA FILE");
				
				return null;
				}*/
		// TODO Auto-generated method stub
		try {
			prop = new Properties();
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  prop.load(new FileInputStream("C:\\Users\\G-1-2043\\eclipse-workspace\\Practo\\Configuration"));
		  sAppURL = prop.getProperty("sAppURL");
		  username = prop.getProperty("uname");
		  password = prop.getProperty("password");
		  System.out.println(sAppURL);
		  System.out.println(username);
		  System.out.println(password);
		//System.setProperty("webdriver.chrome.driver\",\"E:\\\\Capita\\\\chromedriver_win32\\\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver1.get(sAppURL);
		driver1.manage().window().maximize();
		driver1.findElement(By.id("username")).sendKeys(username);
		driver1.findElement(By.id("password")).sendKeys(password);
		driver1.findElement(By.id("login")).click(); 
	  
	  
	 /* System.setProperty("webdriver.chrome.driver","E:\\Capita\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://accounts.practo.com/login?next=%2Fcheckid_request&intent=fabric");
		 //driver.findElement(By.className("nav-login-mobile btn-border nav-interact")).click();//nav-login-mobile btn-border nav-interact

		 WebElement uname = driver.findElement(By.id ("username"));// username
		 uname.sendKeys("7888198010"); 
		 driver.findElement(By.id("password")).sendKeys("Jeevan@8120");// password
		 driver.findElement(By.id("login")).click();*/
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
	  
  }

}