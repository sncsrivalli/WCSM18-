package datePickers;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("datepicker")).click();
		// MM->number MMM->first three letters of month MMMM-> complete month name
		int requiredDate = 15;
		String requiredMonth = "January";
		int requiredMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		String requiredYear = "2015";
		int requiredYearInNum = Integer.parseInt(requiredYear);

		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(actualMonthYear);
		String[] str = actualMonthYear.split(" ");

		String actualMonth = str[0];
		int actualMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		String actualYear = str[1];
		int actualYearInNum = Integer.parseInt(actualYear);

		while (actualMonthInNum < requiredMonthInNum && actualYearInNum < requiredYearInNum) {
			driver.findElement(By.xpath("//span[.='Next']")).click();
			actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualMonthYear.split(" ");
			actualMonth = str[0];
			actualMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualYear = str[1];
			actualYearInNum = Integer.parseInt(actualYear);
		}

		while (actualMonthInNum > requiredMonthInNum && actualYearInNum > requiredYearInNum) {
			driver.findElement(By.xpath("//span[.='Prev']")).click();
			actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			str = actualMonthYear.split(" ");
			actualMonth = str[0];
			actualMonthInNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualYear = str[1];
			actualYearInNum = Integer.parseInt(actualYear);
		}
		driver.findElement(By.xpath("//a[.='" + requiredDate + "']")).click();

	}

}
