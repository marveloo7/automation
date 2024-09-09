package PLibrary;


import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import Common.GenericKeywords;
import Common.config;

public class App_Add_passengers 
{
public static void First()
{
	try
	{
		System.out.println("spicejet tickets !!");
		System.out.println("----------");
		Thread.sleep(5000);
		System.out.println("Trip - one way trip");
		GenericKeywords.wait_for_xpath(Locators.Locators.from);
		GenericKeywords.click_element(Locators.Locators.from);
		System.out.println("from option clicked");
		GenericKeywords.enter_text(Locators.Locators.from,Inputs.Input_data.from);
		System.out.println("from COK (kochi) selected");
		Thread.sleep(4000);
		
//		Select dropdown = new Select(driver.findElement(By.id("dropdownId")));
//		String selectedOption = dropdown.getFirstSelectedOption().getText();
//		
//	System.out.println(GenericKeywords.get_text1(config.driver.findElement(By.xpath("//input[@value='Kochi (COK)']"))));
//		
//		String F = GenericKeywords.get_text(Locators.Locators.bording);
//		System.out.println(GenericKeywords.get_text(Locators.Locators.bording));
//		
		
		
//		Assert.assertEquals(s, true);
		GenericKeywords.wait_for_xpath(Locators.Locators.to);
		GenericKeywords.click_element(Locators.Locators.to);
		System.out.println("to option clicked");
		Thread.sleep(1000);
		GenericKeywords.enter_text(Locators.Locators.to,Inputs.Input_data.to);
		System.out.println("to DXB(dubai) selected");
		GenericKeywords.wait_for_xpath(Locators.Locators.calender);
		System.out.println("calender pop up is opened");
		GenericKeywords.wait_for_xpath(Locators.Locators.dateon);
		System.out.println("date found");
		GenericKeywords.click_element(Locators.Locators.dateon);
		Thread.sleep(2000);
		GenericKeywords.dropdown_click(Locators.Locators.add_passengers, Locators.Locators.add_adult, Locators.Locators.add_child, Locators.Locators.add_infant);
		System.out.println("dropdown selected");
		GenericKeywords.click_element(Locators.Locators.add_passengers);
		
		System.out.println("dropdown closed");
		
		String A = GenericKeywords.get_text(Locators.Locators.selected_passengers);
		System.out.println(GenericKeywords.get_text(Locators.Locators.selected_passengers));
		System.out.println("text fetched");
		Assert.assertEquals(Inputs.Input_data.c5,A);
		GenericKeywords.wait_for_xpath(Locators.Locators.search);
		System.out.println("search found");
		GenericKeywords.click_element(Locators.Locators.search);
		Thread.sleep(2000);
		//GenericKeywords.click_element_by_name(Locators.Locators.search);
		System.out.println("search clicked");
		
//		GenericKeywords.click_element(locators.Locator_add_Chartelements.frstchart);
//		System.out.println("First chart selected");
//		GenericKeywords.wait_for_xpath_visibility(locators.Locator_add_Chartelements.valid1);
//		
		

	}
	
	catch(Exception	e) {
		System.out.println("Exception in  adding first_chart "+ e.getMessage());
			assertTrue(false);
	}
}
	public static void Second()
	{
		try
		{
			System.out.println("Spicejet flights !!");
			System.out.println("----------");
			Thread.sleep(2000);
		Assert.assertEquals(Inputs.Input_data.urlch, config.driver.getCurrentUrl());
		System.out.println("URL validated");
		Thread.sleep(2000);
		String A = GenericKeywords.get_text(Locators.Locators.gett);
		System.out.println(GenericKeywords.get_text(Locators.Locators.gett));
		System.out.println(" text fetched");
		Assert.assertEquals(Inputs.Input_data.c3,A);
		
		String B = GenericKeywords.get_text(Locators.Locators.gett2);
		System.out.println(GenericKeywords.get_text(Locators.Locators.gett2));
		System.out.println(" text fetched");
		Assert.assertEquals(Inputs.Input_data.c6,B);
		
//		String C = GenericKeywords.get_text(Locators.Locators.gett3);
//		System.out.println(C);
//		System.out.println(" text fetched");
//		Assert.assertEquals(Inputs.Input_data.c7,C);
		
		
		
		System.out.println(" passed");
		
		GenericKeywords.wait_for_xpath(Locators.Locators.flight_details);
		GenericKeywords.click_element(Locators.Locators.flight_details);
		System.out.println("Flight details clicked");
		
		String F = GenericKeywords.get_text(Locators.Locators.fdetails);
		System.out.println(GenericKeywords.get_text(Locators.Locators.fdetails));
		System.out.println(" text fetched");
		Assert.assertEquals(Inputs.Input_data.c8,F);
		System.out.println(GenericKeywords.get_text(Locators.Locators.fdetails2));
		
		System.out.println("flight details fetched");
		

}
	catch(Exception	e) {
		System.out.println("Exception in  adding chart2  "+ e.getMessage());
		assertTrue(false);
	}
}}
		
	
	