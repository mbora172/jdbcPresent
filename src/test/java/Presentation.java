import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.Duration;

public class Presentation extends DatabaseUtil {//write query in console see and apply here

    public static void main(String[] args) throws SQLException {


        DatabaseUtil.createConnection();//we connect to VM data. destination ready
        ResultSet resultSet=DatabaseUtil.runQuery("select * from EMPLOYEES where SALARY=(select max(SALARY) from EMPLOYEES)");
        resultSet.next();//show without this next will move inside to table then u can get
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(3));


//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//let say steven stupid why bcse make more money than us and we hate him

//        driver.get("https://login.salesforce.com");
//        driver.findElement(By.id("username")).sendKeys(resultSet.getString(2));
//        driver.findElement(By.id("username")).sendKeys(resultSet.getString(3));
//        driver.findElement(By.id("password")).sendKeys(resultSet.getString(1));
       // driver.findElement(By.id("Login")).click(); // see first whatsapp

                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                //2 million data
        System.out.println(resultSetMetaData.getColumnCount());

        System.out.print(resultSetMetaData.getColumnName(2)+"  ");
        System.out.println(resultSet.getString(2));

        System.out.print(resultSetMetaData.getColumnName(3)+"  ");
        System.out.println(resultSet.getString(3));


    }

}
