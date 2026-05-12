package dev.rodolfo;

// Classe Node: relativa a um nó (node) da estrutura de dados  
// ABB capaz de armazenar dados genéricos
// De qualquer tipo de dado não primitivo.
// Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine.

// Autor 2: Rodolfo Figueiredo Gama | 10742570
// Data da Atualização: 11/05/2026

class Node <E extends Comparable<E>> {  // Nodo, nó ou elemento da árvore
    private E value;  // Valor de classe genérica a ser inserida na árvore
    private Node<E> filhoEsquerdo; // Node esquerdo
    private Node<E> filhoDireito;  // Node direito
    // Node(E valor): Construtor do Node com a inicialização do "valor"    
    public Node(E valor) {
        this.value = valor;
    }
    // getValue(): retorna o valor armazenado no Node.
    public E getValue() {
        return value;
    }
    // setValue(E value): altera o valor armazenado no Node.
    public void setValue(E value) {
        this.value = value;
    }
    // getFilhoEsquerdo(): retorna o Node filho esquerdo do Node atual.
    public Node<E> getFilhoEsquerdo() {
        return filhoEsquerdo;
    }
    // setFilhoEsquerdo(Node<E> filhoEsquerdo): altera o Node filho esquerdo do Node atual.
    public void setFilhoEsquerdo(Node<E> filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }
    // getFilhoDireito(): retorna o Node filho direito do Node atual.
    public Node<E> getFilhoDireito() {
        return filhoDireito;
    }
    // setFilhoDireito(Node<E> filhoDireito): altera o Node filho direito do Node atual.
    public void setFilhoDireito(Node<E> filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
    // toString (): sobrescrita do método to String
    @Override 
    public String toString () {
        return value.toString();
    }
    
}