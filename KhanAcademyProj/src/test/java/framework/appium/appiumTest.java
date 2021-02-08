package framework.appium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

public class appiumTest extends capability{
	AndroidDriver<AndroidElement> driver;
	
	
	
	@BeforeMethod
	public void LaunchDevice() throws IOException, InterruptedException {
		service=startServer();
		driver =capabilities(appPacckage, appActivity, deviceName, platformName, chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void  dismiss() throws InterruptedException {
		System.out.println("Khan Academy launched");
		//Thread.sleep(7000);
		//driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Dismiss\")")).click();
		Thread.sleep(4000);
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Dismiss\")")).click();
		Thread.sleep(6000);
		}


	@Test(priority=2)
	public void  SignIn() throws InterruptedException {
		
		System.out.println("Khan Academy launched");
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Sign in\")")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue with Google\"]/android.view.ViewGroup")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Add another account\")")).click();
		Thread.sleep(6000);
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Email or phone\")")).sendKeys("thiagoragabrosh2012");
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next \"]")).click();
		driver.findElement(By.xpath("//*[@class='android.view.View']")).sendKeys("Rupam@1995");
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next \"]")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Yes, I’m in \"))").click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Yes, I’m in \"]")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"I agree \"]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView']")).click();
		String id = driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"thiagoragabrosh2012\")")).getText();
		System.out.println(id);
	}
	
	@Test(priority=3)
	public void  SelectCourse() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Get started\"))").click();
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Class 7\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Algebra 1\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Done\")")).click();
		Thread.sleep(4000);
	}
	
	
	@Test(priority=4)
	public void  LanguageCheck() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Select language\"))").click();
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView']")).click();
		Thread.sleep(4000);
	}
	
	@Test(priority=5)
	public void  SignOut() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(" UiSelector().text(\"Sign out\")")).click();
	}
	
	
	@AfterTest
	public void afterExecution() throws IOException, InterruptedException {
		service.stop();
	}
}