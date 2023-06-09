 package genericLibraries ;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all reusable methods to perform operations on webDriver
 * @author latha
 *
 */
public class WebDriverUtility 
{
	private  WebDriver driver;
	public WebDriver  launchBrowser(String browser)
	{
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			default:
				System.out.println("Invalid Browser Info");
		}
		return driver;
	}
	/**
	 * This method is used to maximize the window	
	 */
  public void maximizeBrowser()
  {
	driver.manage().window().maximize();
  }
  /**
   * this method is used to navigate to specified application
   * @param url
   */
  public void navigateToApp(String url)
  {
	  driver.get(url);
  }
  /**
   * this method is used to wait until element or list of elements is found
   * @param time
   */
  public void waitUntilElementFound(long time)
  {
	  driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
  }
  /**
   * this method is used to wait until element is visible
   * @param time
   * @param element
 * @return 
   */
  public WebElement explicitWait(long time, WebElement element) 
  {
	  WebDriverWait wait = new WebDriverWait(driver,time);
	 return wait.until(ExpectedConditions.visibilityOf(element));
  }
  /**
   * this method is used to wait until element is enabled
   * @param element
   * @param time
 * @return 
   */
  public WebElement explicitWait( WebElement element,long time) 
  {
	  WebDriverWait wait = new WebDriverWait(driver,time);
	  return wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  /**
   * this method is used to wait until title of webpage is found
   * @param time
   * @param title
 * @return 
   */
  public Boolean explicitWait(long time, String title) 
  {
	  WebDriverWait wait = new WebDriverWait(driver,time);
	  return wait.until(ExpectedConditions.titleContains(title));
  }
  /**
   * this method is used to mouse hover on an element
   * @param element
   */
  public void mouseOver(WebElement element)
  {
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element).perform();
  }
  /**
   * this method is used to double click on an element
   * @param element
   */
  public void doubleClickOnElement(WebElement element)
  {
	  Actions actions = new Actions(driver);
	  actions.doubleClick(element).perform();  
  }
  /**
   * this method is used to right click on an element
   * @param element
   */
  public void rightClick(WebElement element)
  {
	  Actions actions = new Actions(driver);
	  actions.contextClick(element).perform();
  }
  /**
   * This method is used to drag and drop an element to dest
   * @param element
   * @param dest
   */
  public void dargAndDrop(WebElement element,WebElement dest)
  {
	  Actions actions = new Actions(driver);
	  actions.dragAndDrop(element,dest).perform();
  }
  /**
   * this method is used to switch to frame based on index
   * @param index
   */
  
  public void switchToFrame(int index)
  {
	  driver.switchTo().frame(index);
  }
  /**
   * this method is used to switch to frame based on id or name attribute
   * @param idOrName
   */
  public void switchToFrame(String idOrName)
  {
	  driver.switchTo().frame(idOrName);
  }
  /**
   * this method is used to switch frame based on frame element
   * @param frameElement
   */
  public void switchToFrame(WebElement frameElement)
  {
	  driver.switchTo().frame(frameElement);
  }
  /**
   * this method is used to switch back from frame
   */
  public void switchBackFromFrame()
  {
	  driver.switchTo().defaultContent();
  }
  /**
   * this method is used to take screenshot of webpage
   */
  public void takeScreenshot()
  {
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File dest = new File("./Screenshots/screenshot.png");
	  try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
  }
  /**
   * this method is used to scroll till the element
   * @param element
   */
  public void scrollToElement(WebElement element)
  {
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("argument[0].scrollIntoView(true)", element);
  }
  /**
   * this method selects an element from drop down using index
   * @param element
   * @param index
   */
   public void dropdown(WebElement element, int index)
   {
	   Select s = new Select(element);
	   s.selectByIndex(index);
   }
   /**
    * this method selects an element from drop down using value
    * @param element
    * @param value
    */
   public void dropdown(WebElement element, String value)
   {
	   Select s = new Select(element);
	   s.selectByValue(value);
   }
   /**
    * this method selects an element from drop down using text
    * @param text
    * @param element
    */
   public void dropdown(String text,WebElement element)
   {
	   Select s = new Select(element);
	   s.selectByVisibleText(text);
   }
   /**
    * This method handles alert pop up
    * @param status
    */
   public void handleAlert(String status)
   {
	   Alert a1=driver.switchTo().alert();
	   if(status.equalsIgnoreCase("ok"))
	   {
		   a1.accept();
	   }
	   else
		   a1.dismiss();
   }
   /**
    * This method is used to switch to parent window 
    */
   public void switchToParentWindow()
   {
	   String parentID = driver.getWindowHandle();
	   driver.switchTo().window(parentID);
   }
   /**
    * This method is used to switch to child window 
    */
   public void handleChildBrowser() 
   {
	   Set<String> set = driver.getWindowHandles();	   
	   for(String id : set)
		   driver.switchTo().window(id);
   }
   /**
    * this method is used to close  currenttab or window 
    */
   public void closeCurrentTab()
   {
	   driver.close();
   }
   /**
    * this method is used to close all windows or tabs
    */
   public void quitAllWindows()
   {
	   driver.quit();
   }
}
//due