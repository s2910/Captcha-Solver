package Test_Captcha;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Test_Captcha_tessract {
    public static void main(String[] args) throws InterruptedException, TesseractException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Opens Browser
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();

        //CLicks Login Button
        driver.findElement(By.xpath("//a[@aria-label='Click here to Login in application']")).click();
        Thread.sleep(3000);

        //Creates a unique File Name for ScreenSHots
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshot_" + timeStamp +".png";

        //Locating Captcha Element
        WebElement imageElement = driver.findElement(By.xpath("//img[@class='captcha-img']"));
        File src = imageElement.getScreenshotAs(OutputType.FILE);

        //Set the Path where Screenshot will be saved
        File targetFile = new File(System.getProperty("user.dir")+ File.separator + "captchaImages"+ File.separator+ fileName);
        targetFile.getParentFile().mkdirs(); //Create Directory if does not exist

        // Save the CAPTCHA image
        FileUtils.copyFile(src, targetFile);
        System.out.println("CAPTCHA image saved at: " + targetFile.getAbsolutePath());

        ITesseract image = new Tesseract();
        image.setDatapath("C:\\Users\\Acer\\IdeaProjects\\Selenium\\Captcha Solver\\tessdata");
        image.setLanguage("eng");

        String imageOCR = image.doOCR(targetFile);
        System.out.println("Extracted CAPTCHA text: " + imageOCR);

        driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(imageOCR);

        Thread.sleep(2000);

        driver.quit();

    }
}
