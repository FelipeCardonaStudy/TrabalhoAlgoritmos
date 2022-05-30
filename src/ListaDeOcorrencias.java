

/**
 * Esta classe guarda os numeros das paginas em que uma palavra ocorre.
 * É uma lista de numeros de pagina.
 * @author Isabel H. Manssour
 */
public class ListaDeOcorrencias {

    // Classe interna Node
    private class Node {
        public int numeroDaPagina;
        public Node next;
        public Node(int n) {
            numeroDaPagina = n;
            next = null;
        }
    }

    // Atributos
    private Node head;
    private Node tail;
    private int count;

    // Metodos
    public ListaDeOcorrencias() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um numero de pagina ao final da lista, caso ele ainda
     * nao tenha sido adicionado.
     * @param numPagina elemento a ser adicionado ao final da lista
     * @return true se adicionou no final da lista o numero de pagina
     * recebido por parametro, e false caso contrario.
     */
    public boolean add(int numPagina)  {
        Node n = new Node(numPagina);
        if (count == 0) { // se lista vazia
            head = n; // inclui
            tail = n;
            count++;
            return true;
        }
        if (contains(numPagina) ) { // se numPagina ja esta na lista
            return false; // nao inclui
        }
        tail.next = n; // se numPagina nao esta na lista,
        tail = n;      // insere no final
        count++;
        return true;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        if((index < 0) || (index >= count))
        {
            throw new IndexOutOfBoundsException();
        }
        if(index == count - 1)
        {
            return tail.numeroDaPagina;
        }
        Node aux = head;
        int contador = 0;
        while(contador < index)
        {
            aux = aux.next;
            contador++;
        }
        return aux.numeroDaPagina;
    }

    /**
     * Retorna true se a lista contem o numero de pagina passado
     * por parametro.
     * @param numPagina o elemento a ser procurado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(int numPagina) {
        Node aux = head;
        while (aux != null) {
            if (aux.numeroDaPagina == numPagina)
                return true;
            aux = aux.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.numeroDaPagina);
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }
}
