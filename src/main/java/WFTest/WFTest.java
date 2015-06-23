package WFTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WFTest {
	private WebDriver dr;
	private WebDriverWait wait;
	public WFTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MiaoXiang\\Desktop\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.manage().window().setSize(new Dimension(1024,768));
		wait=new WebDriverWait(dr,10);
		
		
	}
	@Test
	public void TestCase()
	{
		dr.get("http://www.google.com");
		Assert.assertEquals(dr.getTitle(), "Google");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("q")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("btnK")));
		try{
			WebElement textbox=dr.findElement(By.name("q"));
	        textbox.sendKeys("12345");
	        WebElement ok=dr.findElement(By.name("btnK"));
	        ok.submit();
	      
		wait.until(ExpectedConditions.titleContains("12345"));
		
			Assert.assertTrue(ElementExist(By.xpath("//div[@class='dirs']//img")),"Not Found");
			//{System.out.println("exist");}
			WebElement map=dr.findElement(By.xpath("//div[@class='dirs']//img"));
			System.out.println("Got map");
			//Assert.assertTrue(map.getAttribute("href").startsWith("https://www.google.com/maps/"));
		}
		catch(NoSuchElementException ex)
		{
			System.out.println("Cant locate map");
		}
		finally{
		dr.quit();}
		
	}
	boolean ElementExist (By x )
	{
	try
	{
	dr.findElement( x );
	return true;
	}
	catch(org.openqa.selenium.NoSuchElementException ex)
	{
	return false;
	}
	}
    
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WFTest test=new WFTest();
        test.TestCase();
	}
	

}
