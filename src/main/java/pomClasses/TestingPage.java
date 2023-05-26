package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements and respective business libraries of testing page
 * @author latha
 *
 */
public class TestingPage {

	//declaration
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(id="Python")
	private WebElement pythonPage;
	
	@FindBy(id="cartArea")
	private WebElement mycart;
	
	@FindBy(xpath="//ul/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	//intialization
		public TestingPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		/**
		 * this method returns page header of selenium training page
		 * @return
		 */
		public String getPageHeader() {
			return pageHeader.getText();
		}
		/**
		 * this method is used to get python image
		 * @return
		 */
		
		public WebElement getPythonImage()
		{
			return getPythonImage();
		}
		/**
		 * this method is used to get myCart area
		 * @return
		 */
		public WebElement getMyCart()
		{
			return mycart;
		}
		/**
		 * this method is used to get facebook icon
		 * @return
		 */
		public WebElement getFacebookIcon()
		{
			return facebookIcon;
		}
		/**
		 * this method is used to click on facebook icon
		 */
		public void clickFacebook()
		{
			facebookIcon.click();
		}
}

