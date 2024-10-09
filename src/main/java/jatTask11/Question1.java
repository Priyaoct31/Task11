package jatTask11;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Question1 {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("https://the-internet.herokuapp.com/windows");
		 
		 String originalWindow = driver.getWindowHandle();
		 
		 WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
         clickHereButton.click();
         
         Set<String> allWindows = driver.getWindowHandles();
         for (String windowHandle : allWindows) {
             if (!windowHandle.equals(originalWindow)) {
                 driver.switchTo().window(windowHandle);
                 break;
             }
         }
         
         WebElement newWindowText = driver.findElement(By.xpath("//h3[text()='New Window']"));
         if (newWindowText.isDisplayed()) {
             System.out.println("New window verification passed.");
         } else {
             System.out.println("New window verification failed.");
         }
         
         driver.switchTo().window(originalWindow);
         
         if (driver.getTitle().equals("The Internet")) {
             System.out.println("Switched back to original window successfully.");
         } else {
             System.out.println("Failed to switch back to the original window.");
         }

         
         driver.quit();

	}

}
