package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	public void setup() {
		System.out.println("WebDriver Started");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		readProperties();
	}

	public void readProperties() {
		System.out.println("Properties Reader Started");
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/src/test/java/resources/datafile.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInput);
		} catch (FileNotFoundException e) {
			System.out.println("Reason of exception is " + e.getCause());
		} catch (IOException e) {
			System.out.println("Reason of exception is " + e.getCause());
		}
		System.out.println("Properties Reader Ended");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("WebDriver Closed");
		driver.close();
	}

	public void staticWait(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
