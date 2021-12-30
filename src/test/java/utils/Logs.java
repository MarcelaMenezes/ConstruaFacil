package utils;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    public void registrarCSV(String dataHoraLog, String casoDeTeste, String mensagem) throws IOException {
        String[]cabecalho = {"data e hora","caso de teste","mensagem"};
        List<String[]> Linhas = new ArrayList<>();
        Linhas.add(new String[]{"2021-07-14 20-36-05", "Consultar Curso Mantis", "Iniciou o teste"});

        Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log1.csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);
        escritorCSV.writeAll(Linhas);

        escritorCSV.flush();
        escritorCSV.close();


    }
}
