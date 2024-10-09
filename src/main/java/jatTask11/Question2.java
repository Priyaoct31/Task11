package jatTask11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question2 {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("http://the-internet.herokuapp.com/nested_frames");
		 
		  driver.switchTo().frame("frame-top");
		  
		  WebElement topFrame = driver.findElement(By.tagName("frameset"));
          int numberOfFramesInTop = topFrame.findElements(By.tagName("frame")).size();
          if (numberOfFramesInTop == 3) {
              System.out.println("Verified: Top frame has 3 frames.");
          } else {
              System.out.println("Verification failed: Top frame does not have 3 frames.");
          }

          
          driver.switchTo().frame("frame-left");
          
          String leftFrameText = driver.findElement(By.cssSelector("body")).getText();
          if (leftFrameText.equals("LEFT")) {
              System.out.println("Verified: Left frame has text 'LEFT'.");
          } else {
              System.out.println("Verification failed: Left frame text mismatch.");
          }
          
          driver.switchTo().parentFrame();
          
          driver.switchTo().frame("frame-middle");
          
          String middleFrameText = driver.findElement(By.cssSelector("#content")).getText();
          if (middleFrameText.equals("MIDDLE")) {
              System.out.println("Verified: Middle frame has text 'MIDDLE'.");
          } else {
              System.out.println("Verification failed: Middle frame text mismatch.");
          }
          
          driver.switchTo().parentFrame();
          
          driver.switchTo().frame("frame-right");
          
          String rightFrameText = driver.findElement(By.cssSelector("body")).getText();
          if (rightFrameText.equals("RIGHT")) {
              System.out.println("Verified: Right frame has text 'RIGHT'.");
          } else {
              System.out.println("Verification failed: Right frame text mismatch.");
          }
          
          driver.switchTo().parentFrame();
          
          driver.switchTo().defaultContent();
          driver.switchTo().frame("frame-bottom");
          
          String bottomFrameText = driver.findElement(By.cssSelector("body")).getText();
          if (bottomFrameText.equals("BOTTOM")) {
              System.out.println("Verified: Bottom frame has text 'BOTTOM'.");
          } else {
              System.out.println("Verification failed: Bottom frame text mismatch.");
          }
          
          
          driver.switchTo().defaultContent();
                
          
          String pageTitle = driver.getTitle();
          if (pageTitle.equals("Frames")) {
              System.out.println("Verified: Page title is 'Frames'.");
          } else {
              System.out.println("Verification failed: Page title mismatch.");
          }
          
          driver.quit();
		
		

	}

}
