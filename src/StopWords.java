import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StopWords
{
    ArquivoTexto arquivo = new ArquivoTexto();
    LinkedListOfString stopWords = new LinkedListOfString();
    private int countStopWords = 0;

    public void importaStopWords(String nomeArquivo)
    {
        arquivo.open(nomeArquivo + ".txt");
        String linha = "";
        StringBuilder s = new StringBuilder();

        while((linha = arquivo.getNextLine()) != null)
        {
            stopWords.add(linha.toLowerCase());
            countStopWords++;
        }
    }

    public boolean testaStopWord(String palavra)
    {
        return stopWords.contains(palavra.toLowerCase());
    }

    public int getCountStopWords()
    {
        return countStopWords;
    }
}
