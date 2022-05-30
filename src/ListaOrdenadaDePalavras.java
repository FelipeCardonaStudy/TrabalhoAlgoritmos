import java.util.ArrayList;

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

        // Construtores

	    // metodo add para adicionar uma palavra na lista de forma ordenada
        // nao deve receber stopword
        public void add(String palavra, int numPagina) {
            // percorre a lista e verifica se a palavra ja esta na lista
            // se ja estiver
            //      incrementa contaOcorrencias
            //      adiciona o numPagina na listaOcorrencias
            // se nao estiver
            //      cria o nodo
            //      insere ordenado
            //      incrementa contaOcorrencias
            //      adiciona o numPagina na listaOcorrencias
        }


        // metodo toString
        
        // demais metodos necessarios
    }
    
}
