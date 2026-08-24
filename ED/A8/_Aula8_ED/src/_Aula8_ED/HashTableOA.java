//
// Tabela Hash (Open Addressing) - Exemplo de implementação em Java
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

//Classe HashTableOA: encarregada da construção das operações da estrutura de dados
// Tabela Hash implementando uma Open Address Hashing.
//Autor 1: André Kishimoto.
//Data da Criação: 2023.
//Autor 2: Ivan Carlos Alcântara de Oliveira
//Data da Atualização: 10/10/2024. 15h.
//Autor 3: Rodolfo Figueiredo Gama | 10742570
//Data da Atualização: 24/05/2026. 23h.
public class HashTableOA implements HashTable {
	
	private final static int HASH_TABLE_DEFAULT_SIZE = 127; 
	private HashTableData table[];
	private boolean removed[];
	private int count;
	
	public HashTableOA() {
		this(HASH_TABLE_DEFAULT_SIZE);
	}
	
	public HashTableOA(int size) {
		table = new HashTableData[size];
		removed = new boolean[size];
		count = 0;
	}

	// rehashing(int hashKey, int tamTH): Realiza o ReHashing por Linear Probing
	public int rehashing(int hashKey, int tamTH) {
		return (hashKey + 1) % tamTH;
	}
	
	// rehashing(int hashKey, int i, int tamTH): método a ser desenvolvido que 
	//    realiza o ReHashing por Quadratic Probing
	public int rehashing(int hashKey, int i, int tamTH) {
		return (hashKey + (i * i)) % tamTH;
	}
	
	@Override
	public String search(int key) {
		int originalHashKey = HashFunction.mod(HashFunction.MIDSquare(key), table.length);
		
		int hashKey = originalHashKey;
		
		// Procura pela chave em todas as posições válidas (preenchidas) da tabela hash e ignora/avança
		// as posições que já tenham sido ocupadas em algum momento e que foram removidas.
		int i = 0;
		while (table[hashKey] != null || removed[hashKey]) {
			if (table[hashKey] != null && table[hashKey].getKey() == key) {
				return table[hashKey].getValue();
			}
			// Realiza o ReHashing por Quadratic Probing
			hashKey = rehashing( hashKey, ++i,  table.length );
			
			if (hashKey == originalHashKey) {
				System.out.println("Coincidiu - Search: " + key + ", Hashkey: " + hashKey);
				break;
			}
		}
		
		return null;
	}		

	@Override
	public InsertResult insert(int key, String value) {
		
		int originalHashKey = HashFunction.mod(HashFunction.MIDSquare(key), table.length);

		int hashKey = originalHashKey;
		InsertResult result = table[hashKey] == null ? InsertResult.WithoutCollision : InsertResult.WithCollision;
		System.out.println("insert - hashKey: " + hashKey);

		// Se a chave a ser inserida foi mapeada para uma posição que já tinha sido ocupada previamente
		// (isto é, está marcada como removida), verifica se a chave já existe na tabela hash, mas em
		// outra posição (posição diferente por conta de colisão). Se já existir, atualiza o valor e
		// retorna antecipadamente.
		if (table[hashKey] == null && removed[hashKey]) {
			int i = 0;
			while (table[hashKey] != null || removed[hashKey]) {
				if (table[hashKey] != null && table[hashKey].getKey() == key) {
					table[hashKey].setValue(value);
					return InsertResult.Updated;
				}
				// Realiza o ReHashing por Quadratic Probing
				hashKey = rehashing( hashKey, ++i,  table.length );
				if (hashKey == originalHashKey) {
					System.out.println("Coincidiu -Insert 1: " + key + ", Hashkey: " + hashKey);
					break;
				}
			}
			hashKey = originalHashKey;
		}

		// Houve colisão na inserção da chave; busca pela próxima posição disponível na tabela hash.
		int i = 0;
		while (table[hashKey] != null) {
			if (table[hashKey].getKey() == key) {
				table[hashKey].setValue(value);
				return InsertResult.Updated;
			}

			// Realiza o ReHashing por Quadratic Probing
			hashKey = rehashing( hashKey, ++i,  table.length );
			if (hashKey == originalHashKey) {
				System.out.println("Coincidiu - Insert 2: " + key + ", Hashkey: " + hashKey);
				return InsertResult.NoSlotAvailable;
			}
		}
		
		table[hashKey] = new HashTableData(key, value);
		removed[hashKey] = false;
		++count;
		
		return result;
	}

	@Override
	public boolean remove(int key) {
		int originalHashKey = HashFunction.mod(HashFunction.MIDSquare(key), table.length);

		int hashKey = originalHashKey;
		
		// Procura pela chave em todas as posições válidas (preenchidas) da tabela hash e ignora/avança
		// as posições que já tenham sido ocupadas em algum momento e que foram removidas.
		int i = 0;
		while (table[hashKey] != null || removed[hashKey]) {
			if (table[hashKey] != null && table[hashKey].getKey() == key) {
				table[hashKey] = null;
				removed[hashKey] = true;
				--count;
				return true;
			}

			// Realiza o ReHashing por Quadratic Probing
			hashKey = rehashing( hashKey, ++i,  table.length );
			if (hashKey == originalHashKey) {
				System.out.println("Coincidiu - Remove: " + key + ", Hashkey: " + hashKey);
				break;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("count: " + count + "\n");
		
		int i = 0;
		for (i = 0; i < table.length - 1; ++i) {
			sb.append("[" + i + "] " + (table[i] == null ? "<empty>" : table[i]) + " - " + (removed[i] ? "removed" : "not removed") + "\n");
		}
		sb.append("[" + i + "] " + (table[i] == null ? "<empty>" : table[i]) + " - " + (removed[i] ? "removed" : "not removed"));
		
		return sb.toString();
	}

}
