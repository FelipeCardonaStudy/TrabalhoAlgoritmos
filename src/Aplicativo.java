import java.text.DecimalFormat;
import java.util.Scanner;

public class Aplicativo
{
    StopWords stopWords = new StopWords();
    ArquivoTexto arquivo = new ArquivoTexto();
    ListaOrdenadaDePalavras lista = new ListaOrdenadaDePalavras();
    LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    double contadorPalavras = 0;

    public void inicializa()
    {
        int nLinha = 0;
        int nPagina = 0;

        String l;

        stopWords.importaStopWords("stopwords");

        arquivo.open("java.txt");

        do  // laco que passa em cada linha do arquivo
        {
            l = arquivo.getNextLine();
            if (l==null) // acabou o arquivo?
                break;
            nLinha++; // conta mais uma linha lida do arquivo
            if (nLinha == 40) // chegou ao fim da pagina?
            {
                nLinha = 0;
                nPagina++;
            }

            linha.setLine(l); // define o texto da linha
            do // laco que passa em cada palavra de uma linha
            {
                String palavra = linha.getNextWord(); // obtem a proxima palavra da linha
                if (palavra == null)// acabou a linha
                {
                    break;
                }
                contadorPalavras++;
                if(stopWords.testaStopWord(palavra) == false)
                {
                    lista.add(palavra, nPagina);
                }
            } while (true);
        } while (true);
        arquivo.close();
    }

    public void menu()
    {
        System.out.println("-------------------------------------------");
        System.out.println("(1) Exibir todo o índice remissivo em ordem alfabética.");
        System.out.println("(2) Exibir o percentual de stopwords do texto.");
        System.out.println("(3) Encontrar a palavra mais frequente");
        System.out.println("(4) Pesquisar palavras");
        System.out.println("(5) Encerrar o programa.");
        System.out.println("-------------------------------------------");
    }

    public void exe()
    {
        System.out.println("Bem vindo!");
        System.out.println("Para utilizar o programa basta digitar o número que representa a opção que deseja.");
        Scanner teclado = new Scanner(System.in);
        boolean sair = false;
        do{
            menu();
            String input = teclado.nextLine();
            switch (input)
            {
                case "1":
                {
                    System.out.println(lista.toString());
                    break;
                }
                case "2":
                {
                    final DecimalFormat df = new DecimalFormat("0.00");
                    double contadorStopWords = stopWords.getCountStopWords();
                    double porcentagemStopWords = (contadorStopWords/contadorPalavras) * 100.0;
                    System.out.println("O percentual de stop words no texto é de aproximadamente: " + df.format(porcentagemStopWords) + "%.");
                    break;
                }
                case "3":
                {
                    System.out.println("A palavra mais frequente no texto é: " + lista.palavraMaisFrequente() + ".");
                    break;
                }
                case "4":
                {
                    System.out.println("Por favor, digite a palavra que deseja pesquisar.");
                    String pesquisa = teclado.nextLine();
                    System.out.println("As páginas em que a palavra " + pesquisa + " aparece são: " + lista.pesquisaPalavra(pesquisa));
                    break;
                }
                case "5":
                {
                    sair = true;
                    System.out.println("Encerrando o programa...");
                    break;
                }
            }
        }
        while (sair = true);
        System.out.println("Programa encerrado.");
    }
}
