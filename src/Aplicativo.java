import java.util.Scanner;

public class Aplicativo
{
    ArquivoTexto arquivo = new ArquivoTexto(); // objeto que gerencia o arquivo
    LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    ListaOrdenadaDePalavras lista = new ListaOrdenadaDePalavras();

    public void inicializa()
    {

        int nLinha = 0;
        int nPagina = 0;

        String l;

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
            System.out.println("Linha " + nLinha + ":");

            linha.setLine(l); // define o texto da linha
            do // laco que passa em cada palavra de uma linha
            {
                String palavra = linha.getNextWord(); // obtem a proxima palavra da linha

                if (palavra == null)// acabou a linha
                {
                    break;
                }
                lista.addPalavra(palavra, nPagina);
                System.out.println("-" + palavra + "-");
            } while (true);

        } while (true);
        arquivo.close();
    }

    public void exe()
    {
        Scanner teclado = new Scanner(System.in);
        boolean sair = false;
        do{
            menu();
            String input = teclado.nextLine();
            switch (input)
            {
                case "1":
                {
                    break;
                }
                case "2":
                {
                    double porcentagem = linha.getContStopWords() * 100 / (linha.getContStopWords() + linha.getContPalavrasTotal());
                    System.out.println("A porcentagem de StopWords no texto lido é de: " + porcentagem + "%");
                    break;
                }
                case "3":
                {
                    System.out.println("A palavra que mais ocorreu foi a: '" + lista.getPalavraQMO());
                    break;
                }
                case "4":
                {
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

    public void menu()
    {
        System.out.println("(1) Exibir todo o índice remissivo.");
        System.out.println("(2) Exibir o percentual de stopwords do texto.");
        System.out.println("(3) Encontrar a palavra mais frequente, isto é, com maior número de ocorrências.");
        System.out.println("(4) Pesquisar palavras, isto é, o usuário informa uma palavra e o programa lista os números das páginas em que a palavra ocorre.");
        System.out.println("(5) Encerrar o programa.");
    }
}
