package commonFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {
	WebDriver driver = null;
	public void HighlightWebElement(WebElement element) throws InterruptedException{
		JavascriptExecutor JE = (JavascriptExecutor) driver;
		JE.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "color: white; border: 3px solid white");
		Thread.sleep(200);
		JE.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "color: black; border: 3px solid black");
		Thread.sleep(200);
	}
}