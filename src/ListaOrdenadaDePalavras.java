
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

        // Atributos
        private Palavra head;
        private Palavra tail;
        private int count;

        //Construtores

        public Palavra()
        {

        }

        // metodo add para adicionar uma palavra na lista de forma ordenada
        // nao deve receber stopword
        public void add(String palavra, int numPagina) {
            Palavra temp = new Palavra(palavra);
            Palavra aux = head;
            int contador = 0;
            if(aux == null)
            {
                head = temp;
                tail = temp;
            }
            else
            {
                while (contador < count) {
                    if ((aux.s).equals(palavra)) {
                        aux.contaOcorrencias++;
                        this.listaOcorrencias.add(numPagina);
                    } else if (!(aux.s).equals(palavra)) {
                        tail.next = temp;
                        tail = temp;
                    }
                    contador++;
                }
            }
            count++;
        }

        // metodo toString

        public String toString() {
            Palavra aux = head;
            int contador = 0;
            String texto = "";
            while (contador < count) {
                texto += aux.s + "(" + aux.contaOcorrencias + "Ocorrência(s))\n" + aux.listaOcorrencias.toString() + "\n";

            }
            return texto.toString();
        }

        // demais metodos necessarios

        public String getPalavraQueMaisOcorreu()
        {
            Palavra aux = head;
            Palavra maisOcorrida = head;
            int contador = 0;
            while(contador < count)
            {
                if(aux.contaOcorrencias < maisOcorrida.contaOcorrencias)
                {
                    maisOcorrida = aux;
                }
            }
            return maisOcorrida.s;
        }
    }

    Palavra palavra = new Palavra();

    public void addPalavra(String palavra, int numPagina)
    {
        this.palavra.add(palavra, numPagina);
    }
    public String getPalavraQMO()
    {
        return this.palavra.getPalavraQueMaisOcorreu();
    }
}

