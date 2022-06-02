import java.util.Locale;

/**
 * Esta classe guarda as palavra do indice remissivo em ordem alfabetica.
 * @author Isabel H. Manssour
 */

public class ListaOrdenadaDePalavras {

    // Classe interna 
    private class Palavra {
        public String s;
        public ListaDeOcorrencias listaOcorrencias;
        public int contaOcorrencias;
        public Palavra next;

        public Palavra(String str) {
            s = str;
            next = null;
            listaOcorrencias = new ListaDeOcorrencias();
        }
    }
    // Atributos
    private Palavra head;
    private Palavra tail;
    private int count;

    // Métodos
    public void add(String palavra, int numPagina) {
        if(palavra.equals(""))
        {

        }
        else
        {
            Palavra n = new Palavra(palavra);
            boolean adicionou = false;
            if (head == null)
            {
                head = n;
                n.contaOcorrencias++;
                n.listaOcorrencias.add(numPagina);
                tail = n;
                count++;
            }
            else
            {
                Palavra temp = head;
                for(int i = 0; i < count; i ++)
                {

                    if(temp.s.toLowerCase().equals(palavra.toLowerCase()))
                    {
                        temp.contaOcorrencias++;
                        temp.listaOcorrencias.add(numPagina);
                        adicionou = true;
                        break;
                    }
                    temp = temp.next;
                }
                if(adicionou == false)
                {
                    n.contaOcorrencias++;
                    n.listaOcorrencias.add(numPagina);
                    tail.next = n;
                    tail = n;
                    count++;
                }
            }
        }
    }

    public String palavraMaisFrequente()
    {
        Palavra palavraMaisFrequente = head;
        Palavra temp = head;
        for(int i = 0; i < count; i++)
        {
            if(temp.contaOcorrencias > palavraMaisFrequente.contaOcorrencias)
            {
                palavraMaisFrequente = temp;
            }
            temp = temp.next;
        }
        return palavraMaisFrequente.s;
    }

    public ListaDeOcorrencias pesquisaPalavra(String palavra)
    {
        ListaDeOcorrencias lista = new ListaDeOcorrencias();
        Palavra temp = head;
        for(int i = 0; i < count; i++)
        {
            if(temp.s.toLowerCase().equals(palavra.toLowerCase()))
            {
                lista = temp.listaOcorrencias;
            }
        }
        return lista;
    }



    // metodo toString

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        Palavra aux = head;

        while (aux != null) {
            s.append(aux.s + " (" + aux.contaOcorrencias + " ocorrência(s))");
            s.append("\n");
            s.append("Página(s): " + aux.listaOcorrencias.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }
}
