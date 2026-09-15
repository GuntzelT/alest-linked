/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour, Gabriel Fonseca Silva
 */
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private int count;

     private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer; // liga o header ao trailer
        trailer.prev = header; // liga o trailer ao header
        count = 0;
    }

    /**
     * Retorna a referencia para o nodo da posicao index.
     * Método utilitário
     * @param index
     * @return 
     */
    private Node getNodeIndex(int index) { // O(n)
        Node aux = null;

        if(index == count){
            return trailer;
        }
        
        if (index < count/2) { // caminha do inicio para o meio
            aux = header.next;
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // caminha do fim para o meio
            aux = trailer.prev;
            for (int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(1)
        Node n = new Node(element);
        n.next = trailer;
        n.prev = trailer.prev;
        trailer.prev = n;
        n.prev.next =n;
        count++;
    }
    
    /**
     * Insere um elemento em uma determinada posição da lista
     * @param index a posição da lista onde o elemento será inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void addByIndex(int index, Integer element) { // O(n)
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Inválido");
        }
        Node n = new Node(element);
        Node aux = getNodeIndex(index);
        n.next = aux; 
        n.prev = aux.prev;
        aux.prev.next = n;
        aux.prev = n;
        count++;
    }
    
    /**
     * Remove a primeira ocorrência do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contém o elemento especificado
     */
    public boolean remove(Integer element) { // O(n)
        Node aux = header.next;
        for(int i = 0; i < size(); i++){
            if(aux.element.equals(element)){
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Remove o elemento de uma determinada posição da lista
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) { // O(n)
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Inválido");
        }
        Node n = getNodeIndex(index);
        Integer r;
        
            r = n.element;
            n.prev.next = n.next;
            n.next.prev = n.prev;
            count--;
            return r;
    }

    /**
     * Retorna o elemento de uma determinada posição da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(n)
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Inválido");
        }
        return getNodeIndex(index).element;
    }

    
 /**
    * Substitui o elemento armazenado em uma determinada posição da lista pelo elemento indicado
    * @param index a posição da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posição da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) { // O(n)
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Inválido");
        }
        Integer n = getNodeIndex(index).element;
        getNodeIndex(index).element = element;
        return n;
    }
    /*   Node n = new Node(element);
        Node aux = getNodeIndex(index);
        n.prev = aux.prev;
        n.next = aux.next;
        n.prev.next = n;
        n.next.prev = n;
        Integer num = aux.element;
        return num;
    }*/

    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) { // O(???)


        return null;
    }
        
    /**
     * Retorna true se a lista contém o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) { // O(???)
        return false;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element){ // O(n)
        Node aux = header.next;
        int c = 0;
        for(int i = 0; i < count; i++){
            if(aux.element.equals(element)){
                return c;
            }
            c++;
            aux = aux.next;
        }
        return -1;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() { // O(???)
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }
        
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node aux = header.next;

        while (aux != trailer) {
            s.append(aux.element.toString());
            s.append(",");
            aux = aux.next;
        }
        if (s.length() > 1)
            s.deleteCharAt(s.length()-1); // Deleta a última vírgula
        s.append("]");
        return s.toString();
    } 
    
    /**
     * Retorna a representação em String da lista, do final para o início
     * @return
     */
    public String toStringBackToFront() { // O(???)
        return null;
    } 
    
    /**
     * Inverte a ordem dos elementos da lista
     */
    public void reverse() { // O(???)
        return;
    }
    
    /**
     * Remove os elementos duplicados da lista, mantendo a primeira ocorrência
     * de cada elemento.
     */
    public void unique() { // O(???)
        }
}
