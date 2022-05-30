/**
 *
 * @author Isabel H. Manssour
 */
public class LinhaTexto {
    private String linha;
    private String palavras[];
    private int contPalavras;
    private int contPalavrasTotal;
    private int contStopWords;
    
    /**
     * Recebe a string da linha que sera armazenada.
     * @param lin com a linha de texto
     */

    ArquivoTexto arquivo = new ArquivoTexto();

    public void setLine(String lin) {
            linha = lin;
            linha = linha.replaceAll("\\t"," "); // substitui tab por espaco em branco
            linha = linha.replaceAll(",",""); // para remover vírgulas
            linha = linha.replaceAll("\\.",""); // para remover ponto final
            linha = linha.replaceAll("\\?",""); // para remover ponto interrogacao
            linha = linha.replaceAll("\\!",""); // para remover ponto exclamacao
            palavras = linha.split(" "); // divide a string pelo espaco em branco
        contPalavras = 0;
    }
    
    /**
     * Retorna uma palavra da linha.
     * @return a palavra, ou null caso nao tenha mais palavras.
     */
    public String getNextWord() {
        arquivo.open("java.txt");
        String pal = null;
        do {
            String stopword = arquivo.getNextLine();
            if (contPalavras < palavras.length) {
                pal = palavras[contPalavras];
                if(pal.equals(stopword))
                {
                    pal = " ";
                    return pal;
                }
                    contPalavras++;
                contPalavrasTotal++;
            }
        }
        while(contPalavras < palavras.length);
      return pal;
    }
    public int getContStopWords()
    {
        return contStopWords;
    }

    public int getContPalavrasTotal()
    {
        return contPalavrasTotal;
    }
}
