package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericLibraries.WebDriverUtility;

/**
 * this class contains elements and respective business libraries of skillrary demo app page
 * @author latha
 *
 */

public class SkillraryDemoAppPage {

	//declrartion
	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement logo;
	
	@FindBy(id="course")
	private WebElement courseTab;
	
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	
	@FindBy(name="addresstype")
	private WebElement categoryDD;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsLink;
	
	//initalization
	
	public SkillraryDemoAppPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	/**
	 * this method is used to return text on the logo
	 * @return
	 */
	public String getLogoText()
	{
	return logo.getText();
	}
	/**
	 * this method is used to mouseHover on course tab
	 * @param web
	 */
	
	public void mouseHoverToCourse(WebDriverUtility web)
	{
		web.mouseOver(courseTab);
	}
	/**
	 * this method is used to click on seleniumTraining
	 */
	public void clickSeleniumTraining()
	{
		seleniumTrainingLink.click();
	}
	/**
	 * this method is used to select category from drop down based on index
	 * @param web
	 * @param index
	 * @param categoryDD
	 */
	public void  selectCategory(WebDriverUtility web , int index)
	{
		web.dropdown(categoryDD, index);
	}
	/**
	 * this method is used to return contact us link
	 * @return
	 */
	public WebElement getContactUs()
	{
		return contactUsLink;
	}
	/**
	 * this method is used to click on contactus link
	 */
	public void clickContactUs()
	{
		contactUsLink.click();
	}
}
//due
