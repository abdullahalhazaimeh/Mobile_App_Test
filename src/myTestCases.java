import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class myTestCases {


	DesiredCapabilities caps = new DesiredCapabilities();

	AndroidDriver driver;

	@BeforeTest
	public void mysetup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "abc");
		File myapplication = new File("src/myApplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, myapplication.getAbsolutePath());

	}

	@Test(enabled = true)

	public void ClickOnAllButtons() throws IOException {

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		List<WebElement> allbuttons = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allbuttons.size(); i++) {
			allbuttons.get(i).click();
		}

		WebElement Results = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));

		String ActualValue = Results.getText();
		String ExpectedValue = "Format error";

		Assert.assertEquals(ActualValue, ExpectedValue);
	}


}
