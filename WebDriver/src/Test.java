import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {

		WebDriver webDriver = null;

		try {

			String path = System.getProperty("user.dir") + "\\src\\driver\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", path);

			webDriver = new ChromeDriver();

			webDriver.navigate().to("http://mail.google.com");
			webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			webDriver.findElement(By.name("identifier")).sendKeys(new String[] { "my_email@gmail.com" });

			webDriver.findElement(By.cssSelector("#identifierNext")).click();

			webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			webDriver.findElement(By.name("password")).sendKeys(new String[] { "my_password" });

			webDriver.findElement(By.cssSelector("#passwordNext")).click();

			webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webDriver.close();
			webDriver.quit();
		}

	}
}
