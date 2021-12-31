package utils;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logs {
    String dataHora;

    //Criar o arquivo de log no inicio da execução
    public void IniciarCSV(String dataHora) throws IOException {
        String[]cabecalho = {"data e hora","caso de teste","mensagem"};
        this.dataHora = dataHora;

        List<String[]> Linhas = new ArrayList<>();
        Linhas.add(new String[]{"2021-07-14 20-36-05", "Consultar Curso Mantis", "Iniciou o teste"});

        Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log" + dataHora +".csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);

        escritorCSV.flush();
        escritorCSV.close();
    }

    //Gravar cada linha no Log
    public void registrarCSV(String casoDeTeste, String mensagem) throws IOException {

        String dataHoraLog = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss:SSS] ").format(Calendar.getInstance().getTime());
        String[] linha = new String[]{dataHoraLog, casoDeTeste, mensagem};

        FileWriter escritor = new FileWriter("target/logs/log - "+ dataHora +".csv", true);
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(linha);

        escritorCSV.flush();
        escritorCSV.close();


    }
}
