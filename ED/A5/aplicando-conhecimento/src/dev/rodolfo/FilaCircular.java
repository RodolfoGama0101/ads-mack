package dev.rodolfo;

//Classe relativa à estrutura de dados Fila
//Circular capaz de armazenar dados genéricos
//De qualquer tipo de dado não primitivo.
//Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine.

public class FilaCircular <T>{
	// Constante e Atributos Privados
	private static final int TAM_DEFAULT = 100;
	private int inicio, fim; // ponteiro de início e fim de fila
	private int qtde; // qtde de elementos armazenados na fila
	private T e[ ]; // array de tipo genérico correspondente a Fila
	
	// Construtor 1
    // Cria uma Fila com o tamanho passado como parâmetro
	public FilaCircular(int tamanho) {// construtor 1 (com tamanho)
		  this.inicio = this.fim = this.qtde = 0;
		  e = (T[]) new Object[tamanho];
	}
    
	// Construtor 2
   	// Cria uma Fila com o tamanho padrão "TAM_DEFAULT"
	public FilaCircular() {  // construtor 2 (sem parâmetros).
		this(TAM_DEFAULT);
	}
	
	// verifica se a fila está vazia
	// retorna verdadeiro se vazia, caso contrário, falso
	public boolean isEmpty() {
		return (qtde == 0);
	}
	
	// Verifica se a fila está cheia
	// retorna verdadeiro se cheia, caso contrário, falso
    public boolean isFull() {
    	return (qtde == e.length); 	
    }
    
	// insere um elemento "e" no final da fila
	public void enqueue(T e) throws Exception {
		if (!isFull()){
			    this.e[this.fim++] = e;
			    this.fim = this.fim % this.e.length;
			    this.qtde++;
		}
		else 
			throw new Exception("Oveflow - Estouro de Fila");	
	}
	
	// remove um elemento do final da fila
    public T dequeue() throws Exception {
    	  T aux;
    	  if (! isEmpty( )){
    	   aux =  this.e[ this.inicio];
    	   this.inicio = ++this.inicio % this.e.length;
    	   this.qtde--;
    	   return aux;
    	  }else{
    		  throw new Exception("underflow - Esvaziamento de Fila");
    	  }
    }
    
	// retorna quem está no início da fila
    // caso a fila não esteja vazia
	public T front() throws Exception {
		if (! isEmpty())
			return e[inicio];
		else{
			throw new Exception("underflow - Esvaziamento de Fila");
		}			
	}
	
	// retorna quem está no final da fila, caso ela não esteja vazia
	public T rear() throws Exception {
		if (! isEmpty()){
			  int pfinal;
			  if (this.fim != 0) pfinal = this.fim - 1;
			  else pfinal = this.e.length - 1;
			  return this.e[pfinal];
		}else{
			  throw new Exception("underflow - Esvaziamento de Fila");
		}			
	}
	
	// Retorna o total de elementos armazenados na fila
	public	int size(){
		return qtde;
	}
	
	// Sobrescrita/sobreposição (override) do método toString(), que veio da superclasse Object.
	// O retorno do método toString() é a representação de um objeto em formato string, e toString()
	// geralmente é executado (de forma implícita) quando passamos um objeto ao System.out.print*().
	@Override
	public String toString()  {
		try {
			int indiceNovo = (inicio + qtde) % e.length;		
			StringBuilder sb = new StringBuilder();
			sb.append("[Fila] quantidade: ")
				.append(qtde)
				.append(", capacidade: ")
				.append(e.length);
			if (qtde != 0) {
				sb.append(", primeiro: ")
					.append(front())
					.append(", último: ")
					.append(rear());
			} 	
			sb.append("\nConteudo da Fila: [ ");
			if (qtde != 0) {
				if (indiceNovo <= inicio) {
					for (int i = inicio; i < e.length; ++i)
						sb.append("\n[" + e[i] + "]");
					for (int i = 0; i < indiceNovo; ++i)
						sb.append("\n[" + e[i] + "]");
				} else {
					for (int i = inicio; i < indiceNovo; ++i)
						sb.append("\n[" + e[i] + "]");
				}
			}
			sb.append(" ]");
			return sb.toString();
		}catch(Exception e) {
			return ("Erro: " + e.getMessage());
		} 
	}
}
