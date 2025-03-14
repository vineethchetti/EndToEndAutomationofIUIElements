package Automationpractise;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EndtoEndautomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("india");
		Thread.sleep(2000l);
		//autosuggestive dropdown
		List<WebElement>options=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("india"))
			{
				option.click();
				break;
			}
		}
		//dynamicdropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@text='Delhi (DEL)']")).click();
		Thread.sleep(2000L);
         driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"));
        {
        	System.out.println("isenabled");
        	Assert.assertTrue(true);
        }
     /*  Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
       driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
      Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());*/
      System.out.println( driver.findElements(By.xpath("//input[@type='checkbox']")).size());//checkboxes
      driver.findElement(By.id("familyandfriend")).click();
      Thread.sleep(2000l);
      //updateddropdown
      driver.findElement(By.id("divpaxinfo")).click();
      Thread.sleep(2000l);
      System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
      for(int i=1;i<=4;i++)
      {
    	  driver.findElement(By.id("hrefIncAdt")).click();
      }
    
      driver.findElement(By.id("btnclosepaxoption")).click();
      Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
       System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
      WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));//static dropdown
      Select dropdown = new Select(staticdropdown);
      dropdown.selectByIndex(3);
      System.out.println(dropdown.getFirstSelectedOption().getText());
      dropdown.selectByContainsVisibleText("AED");
      Thread.sleep(1000l);
      System.out.println(dropdown.getFirstSelectedOption().getText());
      dropdown.selectByValue("INR");
      System.out.println(dropdown.getFirstSelectedOption().getText());
      driver.quit();
        
	}

}
