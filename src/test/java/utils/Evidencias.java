package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Evidencias {

    public  void print(WebDriver driver) throws IOException {
        //pegando o seleniun e colocando uma camera nele, pegamos o print e guardamos em foto
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //pegando o arquivo "foto" e copiamos para a pasta "prints"
        FileUtils.copyFile(foto, new File("target/prints/print1.png"));

    }

}
