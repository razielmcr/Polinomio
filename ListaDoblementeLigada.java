package estructuras.lineales;

import java.util.*;
import java.util.NoSuchElementException;
import java.util.Iterator;
import estructuras.*;

public class ListaDoblementeLigada<T> extends ColeccionAbstracta<T> implements List<T>{
	
 	// Clase Nodo doblemente ligado
    private static class NodoDL<T> {

    	// Referencia al nodo anterior de este nodo.
		private NodoDL<T> anterior;

    	// Referencia al nodo siguiente de este nodo.
		private NodoDL<T> siguiente;

		// Dato que almacena el nodo.
		private T dato;

		/** 
		 * Constructor de la clase nodo.
		 * @param d dato que almacenara el nuevo nodo.
		 */
		public NodoDL(T d) {
		    dato = d;
		}

		/** 
		 * Constructor de la clase nodo.
		 * @param d dato que almacenara el nuevo nodo.
		 * @param a nodo anterior.
		 * @param s nodo siguiente.
		 */
		public NodoDL(T d, NodoDL<T> a, NodoDL<T> s) {
		    dato = d;
		    anterior = a;
		    siguiente = s;
		}
    }

    // Clase Iterador, imprementa ListIterator
    public class Iterador implements ListIterator<T> {
		
		// Referencia al Nodo anterior del iterador
		private NodoDL<T> anterior;

		// Referencia al Nodo siguiente del iterador
		private NodoDL<T> siguiente;

		// Referencia al Ultimo Nodo devuelto del iterador
		private NodoDL<T> ultimoDevuelto;

		/* Constructor de la clase Iterador */
		public Iterador() {
		    start();
		}

		/**
		 * Indica si el iterador tiene elemento siguiente.
		 * @return true si el elemento siguiente existe.
		 */
		public boolean hasNext() {
		    return siguiente != null;
		}

		/**
		 * Indica si el iterador tiene elemento anterior.
		 * @return true si el elemento anterior existe.
		 */
		public boolean hasPrevious() {
		    return anterior != null;
		}

		/**
		 * Regresa el elemento siguiente del iterador y avanza al siguiente.
		 * @return elemento siguiente de la lista.
		 */
		public T next() {
            if(siguiente == null)
                throw new NoSuchElementException();
            anterior = siguiente;
            siguiente = siguiente.siguiente;
            return anterior.dato; 
        }

		/**
		 * Regresa el elemento anterior del iterador y avanza al anterior.
		 * @return elemento anterior de la lista.
		 */
        public T previous() {
            if(anterior == null)
                throw new NoSuchElementException();
            siguiente = anterior;
            anterior = anterior.anterior;
            return siguiente.dato;
        }
         /**
          * Inicializa al iterador al inicio de la lista.
          */
        public void start() {
            anterior = null;
            siguiente = head;
        }

        public void add(T t) {

		}

		public void set(T t) {

		}

		public void remove() {

		}

		public int nextIndex() {
		    return 0;
		}

		public int previousIndex() {
		    return 0;
		}

    }

    // Referencia del primer elemento de la lista.
    private NodoDL<T> head;

    // Referencia del ultimo elemento de la lista.
    private NodoDL<T> tail;

    // Tamayo de la lista, numero de elementos.
    private int tam = 0;

    public ListaDoblementeLigada() {}

    public static void main(String[] args) {
    	ListaDoblementeLigada<String> l = new ListaDoblementeLigada<>();
    	for(int i = 0; i < 10; i++) {
    		l.add("hola" + i);
    	}
    	System.out.println(l.toString());
    }


    public String toString() {
		ListIterator it = listIterator();
		String s = "";
		while(it.hasNext()) {
			s = s + " " + it.next().toString();
		}
		return s;
	}
	
	/**
 	 * Dice si la lista esta vacia.
	 * @return true si la lista esta vacia.
	 */
    public boolean isEmpty(){
		return tam == 0;
    }

	/**
     * Agrega un elemento a la lista en el indice indicado. 
     * @param index indice en donde se guardara el nuevo elemento.
     * @param elemt elemento a agregar.
     * @return true si es que modificó la lista.
     */
    public void add(int index,T element) {
		if(index < 0 || index > tam) throw new IllegalArgumentException();
		if(index == tam) add(element);
		if(index == 0) addSt(element);
		else {
		    NodoDL<T> n = new NodoDL<T>(element);
		    NodoDL<T> x = getNodo(index);
		    x.anterior.siguiente = n;
		    n.anterior = x.anterior;
		    n.siguiente = x;
		    x.anterior = n;
		    tam++;
		}
    }
	
    /**
     * Agrega un elemento a la lista. 
     * @param elemt elemento a agregar.
     * @return true si es que modificó la lista.
     */
    public boolean add(T element){
		if(element == null) throw new IllegalArgumentException();
		NodoDL<T> n = new NodoDL<T>(element);
		if(isEmpty()) head = tail = n;
		else {
		    tail.siguiente = n;
		    n.anterior = tail;
		    tail = n;
		}
		tam++;
		return element != null;
    }

	/**
	 * Agrega un elemento al inicio de la lista.
	 * @param element elemento a agregar a la lista. 
	 * @return true si es que pudo agregar el elemento exitosamente.
	 */
    private boolean addSt(T element) {
        if(element == null)
            throw new IllegalArgumentException();
        NodoDL<T> n = new NodoDL<T>(element);
        if(isEmpty()) tail = head = n;
		else {
		    n.siguiente = head;
		    n.siguiente.anterior = n;
		    head = n;
		}
        tam++;
        return element != null;
    }
	
	/**
	 * Elimina al elemento que se pasa como parametro de la lista.
	 * @param o elemento a eliminar.
	 * @return true si elimino exitosamente el elemento pasado como parametro.
	 */
    public boolean remove(Object o){
		if(o == null) throw new IllegalArgumentException();
		NodoDL<T> n = buscaNodo(head, (T) o);
		if(n == null) return false;
		if(tam == 1) tail = head = null;
		else if (head == n) {
		    head.siguiente.anterior = null;
		    head = head.siguiente;
		}
		else if(tail == n) {
		    tail.anterior.siguiente = null;
		    tail = tail.anterior;
		} else {
		    n.anterior.siguiente = n.siguiente;
		    n.siguiente.anterior = n.anterior;
		}
		tam--;
		return true;
    }

    public T remove(int index) {
		return null;
    }

	/**
	 * Busca al nodo que tenga como elemento al pasado como parametro-
	 * @param n nodo con el cual se quiere que empiece a buscar.
	 * @param element elemento que debe de tener el nodo que se busca.
	 * @return nodo que contiene ese elemento, o <code>null</code> si es que no hay nodos con ese elemento.
	 */
    private NodoDL<T> buscaNodo(NodoDL<T> n, T element) {
		if(n == null) return null;
		if(n.dato.equals(element)) return n;
		return buscaNodo(n.siguiente, element);
    }

    /**
     * Indica el numero de elementos de la lista.
     * @return tamaño de la lista.
     */
    public int size(){
		return tam;
    }

    /**
     * Regresa el dato que almacena el Nodo en el indice que se pasa por parametro.
     * @param index indice del elemento.
     * @return el dato del nodo en el indice indicado.
     */
    public T get(int index){
		if(index < 0 || index > tam) throw new IllegalArgumentException();
		NodoDL<T> tmp = head;
		return get(tmp, 0, index);
    }

    private T get(NodoDL<T> n, int i, int j) {
		return (i == j) ? n.dato : get(n.siguiente, i + 1, j);
    }

	/**
	 * Busca el nodo en la posicion indicada.
	 * @param index posicion que debede tener el nodo.
	 * @return nodo en la posicion index.
	 */
    private NodoDL<T> getNodo(int index) {
		if(index < 0 || index > tam) throw new IllegalArgumentException();
		NodoDL<T> tmp = head;
		return getNodo(tmp, 0, index);
    }

	/**
	 * Auxiliar para buscar el nodo en la posicion indicada.
	 * @param n nodo en la posicion i.
	 * @param i posicion actual del nodo.
	 * @param j posicion que debede tener el nodo.
	 * @return nodo en la posicion index.
	 */
    private NodoDL<T> getNodo(NodoDL<T> n, int i, int j) {
		return (i == j) ? n : getNodo(n.siguiente, i + 1, j);
    }

    /**
     * Regresa una sublista empezando de un indice y terminando en otro.
     * @param fromIndex indice desde el cual va a empezar la sublista.
     * @param toIndex indice en el cual termina la sublista.
     * @return sublista empezando de fromIndex y terminando en toIndex.
     */
    public List<T> subList(int fromIndex, int toIndex){
		if(fromIndex < 0 || toIndex > tam || fromIndex > toIndex) throw new IndexOutOfBoundsException ();
		ListaDoblementeLigada<T> l = new ListaDoblementeLigada<>();
		NodoDL<T> n = this.getNodo(fromIndex);
		while(fromIndex < toIndex) {
		    l.add(n.dato);
		    n = n.siguiente;
		    fromIndex++;
		}
		return (List<T>) l;
    }

    /**
     * Regresa un iterador en la lista empezando en un indice en especifico.
     * @param index indice en el cual debe de iniciar el iterador.
     * @return iterador empezando en index.
     */
    public ListIterator<T> listIterator(int index){
		if(index < 0 || index > tam) throw new IndexOutOfBoundsException();
		ListIterator<T> it = new Iterador();
		int i = 0;
		while(i < index) {
		    it.next();
		    i++;
		}
		return it;
    }

    /**
     * Regresa un iterador en la lista, empezando en el primer elemento.
     * @return iterador en la lista.
     */
    public ListIterator<T> listIterator(){
		return new Iterador();
    }

    /**
     * Regresa el indice de la ultima vez que aparece el elemento indicado.
     * @param o elemento del cualse quiere saber su indice.
     * @return indice de la ultima apraricion del elemento "o" en la lista-
     */
    public int lastIndexOf(Object o) {
		if(o == null) throw new IllegalArgumentException();
		return lastIndexOf(indexOf(o), indexOf(o, indexOf(o) + 1), o);
    } 

    private int lastIndexOf(int ind, int sigInd, Object o) {
		if(sigInd == -1) return ind;
		return lastIndexOf(sigInd, indexOf(o, sigInd + 1), o);
    }

    public int indexOf(Object o){
		if(o == null) throw new IllegalArgumentException();
		NodoDL<T> tmp = head;
		return indexOf(tmp, 0, (T) o);
    }

    private int indexOf(Object o, int inicio) {
    	if(inicio < 0 || inicio >= tam) throw new IndexOutOfBoundsException();
    	return indexOf(getNodo(inicio), inicio, (T) o);
    }

    private int indexOf(NodoDL<T> n, int i, T element) {
		if(n == null)
		    return -1;
		if(element == n.dato)
		    return i;
		return indexOf(n.siguiente, i + 1, element);
    }

    /**
     * Cambia el elemento de la lista en la posicion indicada.
     * @param index posicion de la cual se quiere cambiar el valor.
     * @param element nuevo valor que va a tener la lista en la posicion index.
     * @return valor que tenia el elemento cambiado.
     */
    public T set(int index,T element){
		T dat = getNodo(index).dato;
		getNodo(index).dato = element;
		return dat;
    }


    public boolean addAll(int index,Collection<? extends T> c){
		return false;
    }

    /**
     * Regresa un iterador iniciando en el primer elemento.
     * @return iterador.
     */
    public Iterator<T> iterator(){
		return new Iterador();
    }

}