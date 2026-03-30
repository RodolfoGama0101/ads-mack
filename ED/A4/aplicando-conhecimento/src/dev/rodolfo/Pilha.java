package dev.rodolfo;

// Classe relativa a estrutura de dados Pilha 
// sequencial capaz de armazenar dados inteiros
// Autor1: Ivan Carlos Alcântara de Oliveira.
// Modificado por: Jean Marcos Laine
// Autor2: <Rodolfo Figueiredo Gama | 10742570>

public class Pilha  {
	private static final int TAM_DEFAULT = 100;// Capacidade padrão da pilha
	private int topo; // Índice do elemento no topo (-1 = pilha vazia)
	private int e[]; // array de inteiros correspondente a Pilha

	/**
	 * Construtor com tamanho personalizado
	 * @param tamanho Capacidade inicial da pilha (deve ser > 0)
	 */
	public Pilha(int tamanho) {
		this.e = new int[tamanho];
		this.topo = -1;
	}

	/**
	 * Construtor padrão que usa capacidade definida por TAM_DEFAULT
	 */
	public Pilha() {
		this(TAM_DEFAULT);
	}

	/**
	 * Verifica se a pilha está vazia
	 * @return true se não há elementos, false caso contrário
	 */
	public boolean isEmpty() {
		return this.topo == -1;
	}

	/**
	 * Verifica se a pilha está cheia
	 * @return true se a capacidade máxima foi atingida
	 */
	public boolean isFull() {
		return this.topo == this.e.length-1;
	}

	/**
	 * Esvazia completamente a pilha
	 * @throws Exception Se ocorrer erro durante a operação
	 */
	public void clear() throws Exception{
		while (!isEmpty()) {
			pop();
		}
	}

	/**
	 * Insere um elemento no topo da pilha
	 * @param e Elemento a ser inserido
	 * @throws Exception Se a pilha estiver cheia (Stack Overflow)
	 */
	public void push(int e) throws Exception{
		if (! this.isFull( ))
			this.e[++this.topo] = e;
		else
			throw new Exception("Stack Overflow");
	}

	/**
	 * Remove e retorna o elemento do topo
	 * @return Elemento removido
	 */
	public int pop() throws Exception{
		if (! this.isEmpty( ))
			return this.e[this.topo--];
		else{
			throw new Exception("Stack Underflow");
		}
	}

	/**
	 * Retorna o elemento do topo sem remover
	 * @return Elemento no topo
	 * @throws Exception Se a pilha estiver vazia
	 */
	public int peek() throws Exception{
		if ( ! this.isEmpty( ))
			return this.e[this.topo];
		else{
			throw new Exception("Stack Underflow");
		}
	}

	/**
	 * Retorna a quantidade de elementos armazenados
	 * @return Número de elementos na pilha
	 */
	public int size() {
		return topo+1;
	}

	/**
	 * Busca a primeira ocorrência de um elemento a partir do topo
	 * @param e Elemento a ser buscado
	 * @return Distância do topo (0-based) ou -1 se não encontrado
	 */
	public int search(int e) {
		// Procura a partir do topo até a base [cite: 213]
		for (int i = this.topo; i >= 0; i--) {
			if (this.e[i] == e) {
				return this.topo - i; // Retorna a distância baseada em zero
			}
		}
		return -1; // Retorna -1 se não existir [cite: 214]
	}

	/**
	 * Inverte completamente a ordem dos elementos da pilha
	 * @throws Exception Se ocorrer erro durante a operação
	 */
	public void inverts() throws Exception {
		if (this.isEmpty()) return;

		int esq = 0; // Aponta para a base
		int dir = this.topo; // Aponta para o topo [cite: 216, 217]

		// Realiza a troca (swap) dos elementos das extremidades até o meio
		while (esq < dir) {
			int temp = this.e[esq];
			this.e[esq] = this.e[dir];
			this.e[dir] = temp;
			esq++;
			dir--;
		}
	}

	/**
	 * Remove elementos pares ou ímpares mantendo a ordem original
	 * @param type 1 para remover ímpares, 2 para pares
	 * @throws Exception Se type for inválido ou pilha vazia
	 */
	public void popEvenOdd(int type) throws Exception {
		// Validação exigida pela atividade [cite: 223, 224]
		if (type != 1 && type != 2) {
			throw new Exception("The parameter to the popEvenOdd method must be 1 for odd and 2 for even");
		}

		if (this.isEmpty()) return;

		int novoTopo = -1;
		for (int i = 0; i <= this.topo; i++) {
			boolean isPar = (this.e[i] % 2 == 0);

			// Se o tipo for 1 (remover ímpares), preservamos os pares [cite: 221]
			// Se o tipo for 2 (remover pares), preservamos os ímpares [cite: 221]
			if ((type == 1 && isPar) || (type == 2 && !isPar)) {
				this.e[++novoTopo] = this.e[i]; // Realoca o elemento e mantém a ordem [cite: 222]
			}
		}
		this.topo = novoTopo; // Atualiza o topo oficial da pilha
	}

	/**
	 * Remove elementos múltiplos do número especificado
	 * @param nro Divisor para identificação de múltiplos
	 * @throws Exception Se nro for inválido (ex: zero)
	 */
	public void popMultiple(int nro) throws Exception {
		if (nro == 0) {
			throw new Exception("Divisor inválido (zero)");
		}

		if (this.isEmpty()) return;

		int novoTopo = -1;
		for (int i = 0; i <= this.topo; i++) {
			// Se o elemento NÃO for múltiplo de nro, nós o preservamos [cite: 226]
			if (this.e[i] % nro != 0) {
				this.e[++novoTopo] = this.e[i];
			}
		}
		this.topo = novoTopo; // Atualiza o topo para a nova quantidade de elementos
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  [Stack] top: ")
				.append(this.topo)
				.append(", capacity: ")
				.append(e.length)
				.append(", size: ")
				.append(size());
		if (this.topo != -1) {
			sb.append(", Top value: ")
					.append(this.e[this.topo]);
		}else sb.append(", \r\n" + "Top value: EMPTY STACK");

		sb.append("\n  Stack Contents: [ ");

		for (int i = this.topo; i >= 0; --i)
			if (i != 0) sb.append( e[i] + ", ");
			else sb.append( e[i] );
		sb.append( " ]");
		return sb.toString();
	}

}