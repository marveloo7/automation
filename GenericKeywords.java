package Common;



import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;






public class GenericKeywords
{	
	//public static long unixTime = System.currentTimeMillis() / 1000L;
	 
	public static WebElement get_element(String type, String locator)
	{
		WebElement ele = null;
		//Switch is not working -- need to check
		if(type.equals("xpath"))
				ele = config.driver.findElement(By.xpath(locator));
		else if (type.equals("name"))
			ele = config.driver.findElement(By.name(locator));	
		return ele;
	}
	 public static  void moveblock(String id,String style,String locator) throws InterruptedException 
	    {
			WebElement div = config.driver.findElement(By.xpath(locator));
			String a=div.getAttribute("id");
			 JavascriptExecutor js = (JavascriptExecutor) config.driver;
			  WebElement element = config.driver.findElement(By.id(a+id));
			  Actions  builder;
			  builder = new Actions(config.driver);
			  builder.moveToElement(element, 5, 5);
			  builder.clickAndHold();
			  js.executeScript(style,element);
			  builder.moveByOffset(5, 5);
			  builder.release();
		    			
			}
	public static void StringEqual(String a ,String b)
	{
		a.equalsIgnoreCase(b);
	}
	public static  String Dates()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    Date date = new Date();
	    String date1= dateFormat.format(date);
	    return date1;
	}
	public static void frame(String locator)
	{
		WebElement iframe=config.driver.findElement(By.xpath(locator));
		config.driver.switchTo().frame(iframe);
	}
	
	public static void enter_text(String locator,String text)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		config.driver.findElement(By.xpath(locator)).sendKeys(text);
		
	}
	
	public static void enter_text_By_css(String locator,String text)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		config.driver.findElement(By.cssSelector(locator)).sendKeys(text);
		
	}
	public static void enter_text_By_name(String locator, String text)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public static void click_element(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		config.driver.findElement(By.xpath(locator)).click();
	}
	
	
	
	public static void click_element_by_id(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
		config.driver.findElement(By.id(locator)).click();
	}
	
	public static void fileUpload(String locator,String text)
	{
		File file = new File(text);
		config.driver.findElement(By.xpath(locator)).sendKeys(file.getAbsolutePath());
	}
	public static void javascriptscrollintoview(String locator)
	{
		WebElement element=config.driver.findElement(By.xpath(locator));
		((JavascriptExecutor) config.driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	public static void javascriptscrollintoviewcss(String locator)
	{
		WebElement element=config.driver.findElement(By.cssSelector(locator));
		((JavascriptExecutor) config.driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void wait_for_xpath_visibility(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	
	}
	public static void wait_for_xpath_invisibility(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	
	}
	
	public static void visibility_By_Name(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
	}
	public static void visibility_By_css(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	}
	public static void visibility_By_class(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
	}
	
	
	public static void selectByvisibletext(String locator,String text)
	{
		 WebElement ele = config.driver.findElement(By.xpath(locator));
	      Select ele_click = new Select(ele);
	      ele_click.selectByVisibleText(text);
	}
	
	public static void selectByIndex(String locator,int index)
	{
		 WebElement ele = config.driver.findElement(By.xpath(locator));
	      Select ele_click = new Select(ele);
	      ele_click.selectByIndex(index);
	}
	public static void outclick()
	{
		config.driver.findElement(By.xpath("//html")).click();
	}
	public static void click_element_by_name(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
		config.driver.findElement(By.name(locator)).click();
	}
	
	public static void click_element_by_linktext(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
		config.driver.findElement(By.linkText(locator)).click();
	}
	public static void click_element_by_css(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		config.driver.findElement(By.cssSelector(locator)).click();
	}
	
	 public static  WebElement ChildWFblock(String url,String id,String locator) throws InterruptedException 
	    {
	    	
			WebElement div = config.driver.findElement(By.xpath(locator));
			String a=div.getAttribute("id");
			
			WebDriverWait wait = new WebDriverWait(config.driver,60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(a+"_"+url+id)));
			Thread.sleep(2000);
			return config.driver.findElement(By.id(a+"_"+url+id));
		}
	 
		public static void javaScriptExecuterClick(WebElement locator)
		{
			try
			{
				((JavascriptExecutor) config.driver).executeScript("arguments[0].click();", locator);

			}
			catch(NoSuchElementException exception)
			{
				Reporter.log("Element is not Present in UI-"+exception);	
			}

		}
	
	public static void click_element_byAction(String locator){
		Actions act = new Actions(config.driver);
		WebElement ele = config.driver.findElement(By.xpath(locator));
		act.moveToElement(ele).build().perform();
		act.contextClick(ele);
	}
	public static String split_url(String url)
	{
		final String after = url.split("debugger/")[1]; // "After"			
		return after;
	}
	public static void rightclick_action(String locator)
	{	
		Actions action = new Actions(config.driver);
		WebElement link = config.driver.findElement(By.xpath(locator));
		action.contextClick(link).perform();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();	
	}
	
	public static void enterKey()
	{
		Actions action = new Actions(config.driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	public static void backspace(String locator)
	{
		config.driver.findElement(By.xpath(locator)).sendKeys(Keys.BACK_SPACE);
	}
	
	public static void dropclick()
	{
		Actions action = new Actions(config.driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	public static void remove_col_action(String locator)
	{
		Actions action = new Actions(config.driver);
		WebElement link = config.driver.findElement(By.xpath(locator));
		action.contextClick(link).perform();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();	
	}
	
	public static void FindBy_tagname(String locator,String text)
	{
		 WebElement tinymce = config.driver.findElement(By.tagName(locator));
		    tinymce.clear();
		    tinymce.click();
		    tinymce.sendKeys(text);
		    config.driver.switchTo().defaultContent();
	}
	public static void delete_alert()
	{
		config.driver.switchTo().alert().accept();
	}
	
	public static void clear(String locator)
	{
		config.driver.findElement(By.xpath(locator)).clear();
	}
	
	public static void clear_css(String locator)
	{
		config.driver.findElement(By.cssSelector(locator)).clear();
	}
	public static void wait_for_linktext(String locator)
	{
		config.driver.findElement(By.linkText(locator));
	}
	public static void wait_for_css(String locator)
	{
		config.driver.findElement(By.cssSelector(locator));
	}
	public static void wait_for_xpath(String locator) 
	{
		WebDriverWait wait=new WebDriverWait(config.driver,120,2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	public static void wait_for_id(String locator) 
	{
		WebDriverWait wait=new WebDriverWait(config.driver,120,2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		
	}

	
	public static String get_text1(WebElement ele)

	{
		String eleText = null;
		eleText = ele.getText();
		if(eleText.equals(""));
		{
		eleText = ele.getAttribute("innerText");
		if(eleText.equals(""))
		{

			eleText = ele.getAttribute("textContext");
		}
		}
		return eleText;
	}
	
	public static String get_attribute(String locator,String value)

	{
		WebElement element=config.driver.findElement(By.xpath(locator));
		return element.getAttribute(value);
	}

	public static String get_currentURL() 

	{		
		return config.driver.getCurrentUrl();
	}

	public static String get_text(String locator)

	{
		WebElement element=config.driver.findElement(By.xpath(locator));
		return element.getText();
	}
	public static boolean isSelected(String locator)
	{
		WebElement element=config.driver.findElement(By.xpath(locator));
	return element.isSelected();
		
	}
	public static String isSelected(String locator,String attribute)
	{
		WebElement element=config.driver.findElement(By.xpath(locator));
	return element.getAttribute(attribute);
		
	}
	
	public static String get_Css(String locator,String value)

	{
		WebElement element=config.driver.findElement(By.cssSelector(locator));
		return element.getCssValue(value);
	}
	
	
	
	public static void Refresh()

	{
		config.driver.navigate().refresh();
	}
	
	public static void navigate(String url)

	{
		config.driver.navigate().to(url);
	}
	public static void Alert()
	
	{
		config.driver.switchTo().alert().accept();
	}
	
public static void Alertd()
	
	{
		config.driver.switchTo().alert().dismiss();
	}

	public static void dropdown_click(String locator,String locator1,String locator2,String locator3 ) throws InterruptedException

	{
		Thread.sleep(2000);
		config.driver.findElement(By.xpath(locator)).click();
		config.driver.findElement(By.xpath(locator1)).click();
		config.driver.findElement(By.xpath(locator2)).click();
		config.driver.findElement(By.xpath(locator3)).click();
		
	}

	
	public static void EditText(String locator,String text)

	{
		WebElement element=config.driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(text);
	}
	
	public static void javaScriptExecuterClick(String locator)
	{
		try
		{
			WebElement element=config.driver.findElement(By.xpath(locator));
			((JavascriptExecutor) config.driver).executeScript("arguments[0].click();", element);

		}
		catch(NoSuchElementException exception)
		{
			Reporter.log("Element is not Present in UI-"+exception);	
		}

	}
	
	
	
	public static boolean isClickable(String locator)
	{
		try
		{
			if(config.driver.findElement(By.className(locator)).getAttribute("button")==null)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}
	
	
	
	public static void keyboardTab(String locator)
	{
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		config.driver.findElement(By.xpath(locator)).sendKeys(Keys.TAB);
	}
	
	public static void moveToElement(String locator)
	{
		Actions action = new Actions(config.driver);
		WebElement element=config.driver.findElement(By.xpath(locator));
		action.moveToElement(element, 1500, 150).click().build().perform();
	}
	public static void mouseHover(String locator)
	{
			
			Actions action = new Actions(config.driver);
			WebElement element = config.driver.findElement(By.xpath(locator));
			action.moveToElement(element).build().perform();
	
	}
		

	public static void jsExecuteScript(String locator,String scroll, String value)
	{
		JavascriptExecutor js = (JavascriptExecutor) config.driver;
		String Scroll=locator+scroll+value;
		js.executeScript(Scroll);	
	}
	public static void jsExecuteScriptClick(String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor) config.driver;
		String exeClick=locator+".click()";
		js.executeScript(exeClick);	
	}
	public static void jsExecuteScriptSS(String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor) config.driver;
		js.executeScript(locator);	
	}
	
	
	public static void jsExecuteScriptlimit(String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor) config.driver;
		js.executeScript(locator,"");	
	}
	
	public static void waitForAjaxControls(int timeoutInSeconds) {
		//	System.out
		//			.println("Querying active AJAX controls by calling jquery.active");
		
			try {
				
				if (config.driver instanceof JavascriptExecutor) {
					JavascriptExecutor jsDriver = (JavascriptExecutor) config.driver;
					for (int i = 0; i < timeoutInSeconds; i++) {
						Object numberOfAjaxConnections = jsDriver
								.executeScript("return jQuery.active");
						// return should be a number
						if (numberOfAjaxConnections instanceof Long) {
							Long n = (Long) numberOfAjaxConnections;
						//	System.out
						//			.println("Number of active jquery AJAX controls: "
						//					+ n);
							if (n.longValue() == 0L)
								break;
						}
						Thread.sleep(1000);
					}
				} else {
					System.out.println("Web driver: " + config.driver
							+ " can't run javascript.");
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	
	public static String tostring(String locator)
	{
		return config.driver.findElement(By.xpath(locator)).getText().toString();	
		
	}
	
	public static void send_appname(String locator,String text)
	{
		
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		config.driver.findElement(By.xpath(locator)).sendKeys(text);
	}


	public static void tagname_visibility(String tagname) {
		WebDriverWait wait = new WebDriverWait(config.driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagname)));
	}
	
	
	public static void javaScriptExecuterscrollheight()
	{
		try
		{
			((JavascriptExecutor) config.driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
		}
		catch(NoSuchElementException exception)
		{
			Reporter.log("Element is not Present in UI-"+exception);	
		}
	}
	
	public static void javaScriptExecuterScrollBy()
	{
		try
		{
			((JavascriptExecutor) config.driver).executeScript("window.scrollBy(0,500)");
		}
		catch(NoSuchElementException exception)
		{
			Reporter.log("Element is not Present in UI-"+exception);	
		}
	}
	
	
	
	
}

