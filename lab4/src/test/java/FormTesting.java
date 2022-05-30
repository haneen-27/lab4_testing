import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;
public class FormTesting {

    static WebDriver driver;
    static final String Website = "https://formy-project.herokuapp.com/form";

    @BeforeAll
    public static void init(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
    @BeforeEach
    public void BE(){
        driver.get(Website);
    }

    @Test
    public void FORM_TEST(){
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement jobTitle = driver.findElement(By.id("job-title"));
        WebElement educationLevel = driver.findElement(By.id("radio-button-2"));

        firstName.sendKeys("Haneen");
        lastName.sendKeys("Ibrahim");
        jobTitle.sendKeys("Software Engineering Student");
        educationLevel.click();

        assertEquals(firstName.getAttribute("value"),"Haneen");
        assertEquals(lastName.getAttribute("value"),"Ibrahim");
        assertEquals(jobTitle.getAttribute("value"),"Software Engineering Student");
        assertTrue(educationLevel.isSelected());

        WebElement submit = driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a"));
        submit.click();
    }


}




















