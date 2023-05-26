package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {
	//Declaration
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoAppLink;
	
	//Initialization
	public SkillraryHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	 //utilization
	/**
	 * this method returns skillrary home page logo
	 * @return
	 */
	public WebElement getLogo()
	{
		return logo;
	}
	/**
	 * this method is used to click on gears tab
	 */
	
	public void clickGearsTab()
	{
		gearsTab.click();
	}
	/**
	 * this method is used to click on skillrary demo app link
	 */
	public void clickSkillraryDemoApp()
	{
		skillraryDemoAppLink.click();
	}
	
}
