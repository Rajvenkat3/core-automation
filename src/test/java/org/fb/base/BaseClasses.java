package org.fb.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClasses {

	public static WebDriver driver;
	public static Actions ac;
	public static TakesScreenshot ts;
	public static JavascriptExecutor js;
	public static Select s;
	public static Alert alert;
	public static WebElement element;

	public static WebDriver launchBrowser(String driverName, String path) {
		System.setProperty(driverName, path);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		return driver = new ChromeDriver(options);
	}
	
public static void lanuchBrowser1(String browserName) {
		
		 driver = null;
		if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		
		}
		
//		else if (browserName.equals("chrome")) {
//			System.setProperty(drivername, path);
//			
//			driver = new ChromeDriver();
//			
//	
//	}
	
		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		
		}
	
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxbrowser() {
		driver.manage().window().maximize();
	}

	public static String tittle() {
		String s=driver.getTitle();
		return s;
	}

	public static void pageUrl() {
		String s = driver.getCurrentUrl();
		System.out.println(s);
	}

	public static WebElement findElementBy(By by) {
		element = driver.findElement(by);
		return element;
	}

	public static WebElement findElementByid(String id) {
		element = driver.findElement(By.id(id));
		return element;
	}

	public static WebElement findElementByname(String name) {
		element = driver.findElement(By.name(name));
		return element;
	}

	public static WebElement findElementByclassName(String classsname) {
		element = driver.findElement(By.className(classsname));
		return element;
	}

	public static WebElement findElementByxpath(String xpathvalue) {
		element = driver.findElement(By.xpath(xpathvalue));
		return element;
	}

	public static WebElement findElementBycssSelector(String cssselectvalue) {
		element = driver.findElement(By.cssSelector(cssselectvalue));
		return element;
	}

	public static WebElement findElementBylinkTest(String LinkTextValue) {
		element = driver.findElement(By.linkText(LinkTextValue));
		return element;
	}

	public static WebElement findElementBypartialLinkText(String partialLinkTextvalue) {
		element = driver.findElement(By.partialLinkText(partialLinkTextvalue));
		return element;
	}

	public static void enterText(String keys) {
		element.sendKeys(keys);

	}

	public static void clickopt(WebElement element) {
		element.click();

	}

	public static WebElement scrollDown(String scroll) {
		js = (JavascriptExecutor) driver;
		js.executeScript(scroll, element);
		return element;
	}

	public static String readprop(String key) {
		String value = null;
		try {
			FileReader read = new FileReader(
					"C:\\Users\\hp\\eclipse-workspace\\SelProj\\src\\FileReadProperties\\data.property");
			Properties prop = new Properties();
			try {
				prop.load(read);
				value = prop.getProperty(key);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String readValueForExcel(String sh, int r, int c) {
		String value = null;
		try {

			String path = "C:\\Users\\hp\\eclipse-workspace\\AdactinHotelProj\\ExcelSheet\\Adacitin Hotel.xlsx";
			File f = new File(path);

			FileInputStream fls = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fls);
			Sheet sht = wb.getSheet(sh);
			Row rr = sht.getRow(r);
			Cell cc = rr.getCell(c);
			int cellType = cc.getCellType();
			if (cellType == 1) {
				value = cc.getStringCellValue();
			} else {
				double num = cc.getNumericCellValue();
				long a = (long) num;
				value = String.valueOf(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;

	}

	public static void excelWriteValue(String sh, int r, int c, String val) {
		try {
			String path = "C:\\Users\\hp\\eclipse-workspace\\AdactinHotelProj\\ExcelSheet\\Adacitin Hotel.xlsx                                                                                                                                                                                                                                                                                             ";
			File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sht = wb.createSheet(sh);
			Row rr = sht.createRow(r);
			Cell cc = rr.createCell(c);
			cc.setCellValue(val);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object[][] excelreadalldataformat() throws IOException {
		Object value = null;
		Object[][] twoDimArray = null;
		File f = new File("C:\\Users\\hp\\eclipse-workspace\\HotelProjectWithTestNg\\src\\test\\resources\\logindetails.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		int physicalNumberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		twoDimArray = new Object[physicalNumberOfRows - 1][physicalNumberOfCells];
		for (int i = 1; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType == 1) {
					value = cell.getStringCellValue();
				} else if (cellType == 0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat s = new SimpleDateFormat("MMM/dd/yyyy");
						value = s.format(dateCellValue);							
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long l = (long) numericCellValue;
						value=String.valueOf(l);							
					}						
				}		
				System.out.println(value);
				twoDimArray[i - 1][j] = value;
			}

			for (int p = 0; p < twoDimArray.length; p++) {
				for (int q = 0; q < twoDimArray[p].length; q++) {
					// System.out.print(twoDimArray[p][q]);

				}
				// System.out.println();
			}

		}
		return twoDimArray;
	}

	public static void main(String[] args) {
		try {
			excelreadalldataformat();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public static void waitIMP(long a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}

	public static String getAttribute(String id) {
		WebElement textData = driver.findElement(By.id(id));
		return textData.getAttribute("value");
	}

	public static void selectIndex(WebElement element, int i) {
		s = new Select(element);
		s.selectByIndex(i);
	}

	public static void selectText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void typedata(WebElement element, String data) {
		element.sendKeys(data);
	}

}
