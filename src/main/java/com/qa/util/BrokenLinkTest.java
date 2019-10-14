package com.qa.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrokenLinkTest {

    public static WebDriver driver;
    public static Properties prop;
    public static final Double NANO_TO_MILLIS = 1000000.0;
    private static String[] columns = {"Name", "Message", "Time"};
    private static List<Urls> urls = new ArrayList<Urls>();

    public static void main(String[] args) throws IOException {


        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");

            prop.load(fis);

        } catch (IOException e) {
            e.getMessage();
        }
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/com/qa/config/resources/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        // driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));


        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        linkList.addAll(driver.findElements(By.tagName("img")));


        System.out.println("Size of full links and images : " + linkList.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();

        for (WebElement i : linkList) {


            try {
                System.out.println(i.getAttribute("href"));  //javascipt


                if (i.getAttribute("href") != null && (!i.getAttribute("href").contains("javascript"))) {

                    activeLinks.add(i);
                }
            } catch (Exception e) {
                System.out.println("faced some problems");
            }


        }


        System.out.println("Size of active links : " + activeLinks.size());


        for (WebElement i : activeLinks) {


            setResponseTime(i);


        }

        excellWriter();

        driver.close();

        System.out.println("closed the browser");
        driver.quit();

    }


    public static void setResponseTime(WebElement i) throws IOException {

        // start timer
        long nanoStart = System.nanoTime();
        long milliStart = System.currentTimeMillis();


        HttpURLConnection connection = (HttpURLConnection) new URL(i.getAttribute("href")).openConnection();
        connection.connect();
        String response = connection.getResponseMessage();
        connection.disconnect();

        // stop timer
        long nanoEnd = System.nanoTime();
        long milliEnd = System.currentTimeMillis();

        // report response times
        long nanoTime = nanoEnd - nanoStart;
        long milliTime = milliEnd - milliStart;


        System.out.println(i.getAttribute("href") + "-------------" + response + "------------- sure ------------" + reportResponseTimes(nanoTime, milliTime));


        urls.add(new Urls(i.getAttribute("href"), response, reportResponseTimes(nanoTime, milliTime)));

    }


    public static String reportResponseTimes(long nanoTime, long milliTime) {
        // convert nanoseconds to milliseconds and display both times with three digits of precision (microsecond)
        String nanoFormatted = String.format("%,.3f", nanoTime / NANO_TO_MILLIS);
        String milliFormatted = String.format("%,.3f", milliTime / 1.0);

        System.out.println("Milliseconds using nanoTime(): " + nanoFormatted);
        System.out.println("Milliseconds using currentTimeMillis: " + milliFormatted);

        return milliFormatted;
    }


    public static void excellWriter() throws IOException {


        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Sonuc");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }


        int rowNum = 1;
        for (Urls url : urls) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(url.getName());

            row.createCell(1)
                    .setCellValue(url.getMessage());


            row.createCell(2)
                    .setCellValue(url.getTime());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("urlSonuc.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }


}
