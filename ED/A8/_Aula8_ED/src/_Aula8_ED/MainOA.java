//
// Tabela Hash (Open Addressing/Chaining) - Exemplo de implementação em Java
// Copyright (C) 2023 André Kishimoto
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.
//

package _Aula8_ED;

//Classe MainOA: encarregada de executar alguns testes/funcionalidades
//com a estrutura de dados Tabela Hash utilizando uma Open Address Hashing.
//Autor 1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
public class MainOA {
	// isEmpty(HashTable hashTable): verifica e mostra se a Tabela Hash está vazia.
	private static void isEmpty(HashTable hashTable) {
		System.out.println("Hash table is" + (hashTable.isEmpty() ? " " : " not ") + "empty.");
	}
	// search(HashTable hashTable, int key): procura por uma dada "key" (chave) na tabela hash
	private static void search(HashTable hashTable, int key) {
		System.out.print("search(" + key + "): ");
		String value = hashTable.search(key);
		System.out.println(value == null ? "Search returned null." : value);
	}
	// insert(HashTable hashTable, int key, String value): insere uma dada key 
	//    na tabela hash com um "value".
	private static void insert(HashTable hashTable, int key, String value) {
		System.out.print("insert(" + key + ", " + value + "): ");
		
		InsertResult result = hashTable.insert(key, value);
		System.out.println(switch (result) {
			case WithCollision -> "InsertResult.WithCollision";
			case WithoutCollision -> "InsertResult.WithoutCollision";
			case Updated -> "InsertResult.Updated";
			case NoSlotAvailable -> "InsertResult.NoSlotAvailable";
		});
	}

	// remove(HashTable hashTable, int key): remove um elemento de chave "key" da tabela hash.
	private static void remove(HashTable hashTable, int key) {
		System.out.print("remove(" + key + "): ");
		boolean result = hashTable.remove(key);
		System.out.println(result ? "Removed!" : "Key not found.");
		
	}

	public static void main(String[] args) {
		System.out.println("***** Hash table - Open addressing *****");
		System.out.println("*********** Disciplinas ADS ************");
		
		HashTable hashTable = new HashTableOA(11);
		isEmpty(hashTable);
		
		int keys[] = { 78, 27, 20, 82, 98, 13, 29, 21, 97, 45, 33 };
		String values[] = {
			"Estrutura de Dados",
			"Comunicação de Dados",
			"Programação de Sistemas I",
			"Programação de Sistemas II",
			"Banco de Dados",
			"Desenvolvimento de Sistemas I",
			"Desenvolvimento de Sistemas II",
			"Princípios de Empreendedorismo",
			"Jogos Digitais",
			"Segurança e Direito Digital",
			"Projetos Empreendedores"
		};
		System.out.println("----------");
		for (int i = 0; i < keys.length; ++i) {
			insert(hashTable, keys[i], values[i]);
		}
		System.out.println("----------");
		System.out.println(hashTable);

		System.out.println("----------");

		System.out.println("----------");
		for (int i = 1; i < 3; ++i) {
			remove(hashTable, keys[i*2]);
		}
		int index = 2;
		int key = keys[index];
		search(hashTable, key);

		System.out.println("----------");
		System.out.println(hashTable);
	}

}
