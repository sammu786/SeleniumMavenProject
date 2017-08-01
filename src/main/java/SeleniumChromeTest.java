import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Nils via frontendtest.org
 */
public class SeleniumChromeTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String

					

						[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumGithubs\\Selenium-Maven-Template-master\\src\\test\\resources\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();

		// Setting the browser size
		webDriver.manage().window().setSize(new Dimension(1024, 768));

		// Go to wikipedia
		webDriver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");

		// Type in the search-field: "WebDriver"
		webDriver.findElement(By.id("searchInput")).sendKeys("WebDriver");

		// submitting the search query
		webDriver.findElement(By.id("searchInput")).submit();

		// Test if Wikipedia redirects to the correct article:
		// "Selenium (software)"
		String textFound = webDriver.findElement(By.cssSelector("h1"))
				.getText();
		if (textFound.contains("Selenium (software)")) {
			System.out.println("Test passes!");
		} else {
			System.out.println("Test fails!");
		}

		// Waiting a little bit before closing
		Thread.sleep(7000);

		// Closing the browser and webdriver
		webDriver.close();
		webDriver.quit();
	}
}


