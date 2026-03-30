package dev.rodolfo;

// Classe __Aula4_ED: encarregada de executar alguns testes
// com a estrutura de dados Pilha.
// Autor1: Ivan Carlos Alcântara de Oliveira.
// Modificado por: Jean Marcos Laine

public class __Aula4_ED {
	public static void main(String[] args) {
		try {
			Pilha p = new Pilha();
		    
			p.push(4);
			p.push(5);		
			p.push(10);
			p.push(9);
			p.push(8);
            
			System.out.println("Pilha inicial (após algumas inserções):");
			System.out.println(p);
			System.out.println("Distância do 5 em relação ao topo: " + p.search(5));
			System.out.println("Distância do 6 em relação ao topo: " + p.search(6));
			
			p.inverts();
			System.out.println("Pilha após a inversão:");
			System.out.println(p);		
			System.out.println("Distância do 5 em relação ao topo: " + p.search(5));
			
			p.popEvenOdd(1);
			System.out.println("Estado da Pilha depois de removidos os ímpares:");
			System.out.println(p);	
			
			p.push(12);
			p.push(8);
			p.push(22);
			p.push(34);
			System.out.println("Pilha (após mais inserções):");
			System.out.println(p);
			
			p.popMultiple(4);
			System.out.println("Estado da Pilha depois de removidos os múltiplos de 4:");
			System.out.println(p);	
			
			p.push(15);
			p.push(6);
			p.push(17);
			p.push(33);
			System.out.println("Pilha (após mais algumas inserções):");
			System.out.println(p);
			
			p.popEvenOdd(2);
			System.out.println("Estado da Pilha depois de removidos os pares:");
			System.out.println(p);
		
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
