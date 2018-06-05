import java.util.TimerTask;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;

public class NewsFeeder extends TimerTask {
    FileWriter fw;
    FileReader fr;

    String pageName = "News.html";

    @Override
    public void run() {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://Ethsat.net");
        

        WebElement webElement = driver.findElement(By.className("className"));
        dataWriter(webElement.getAttribute("innerHTML") + "$body");
        driver.close();


    }

    public void dataWriter(String elements){

        String htmlLoader = dataReader().replace("$body",elements);

        try {
            fw = new FileWriter(pageName);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(htmlLoader);
            bufferedWriter.close();

        }catch (Exception exception){
            System.out.println("sorry! failed to write to the file: " + pageName);
        }
    }

    public String dataReader(){

        String n_lines = null;
        String htmlLoader = "";

        try {
            fr = new FileReader(pageName);
            BufferedReader bufferedReader = new BufferedReader(fr);

            while ((n_lines = bufferedReader.readLine()) != null){
                htmlLoader += n_lines;
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("Sorry!! Failed to read from the file: " + pageName);
        }
        return htmlLoader;
    }


}
