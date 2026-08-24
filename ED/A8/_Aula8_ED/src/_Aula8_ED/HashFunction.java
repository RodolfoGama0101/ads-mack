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

//Classe HashFunction: encarregada da construção das funções hash da estrutura de dados
//Tabela Hash.
//Autor 1: André Kishimoto.
//Data da Criação: 2023.
//Autor 2: Ivan Carlos Alcântara de Oliveira
//Data da Atualização: 10/10/2024. 15h.
//Autor 3: Rodolfo Figueiredo Gama | 10742570
//Data da Atualização: 24/05/2026. 23h.
public class HashFunction {

	/*
	 * mod(int k, int m): função hash modular ou da divisão inteira. Passa a chave k e o
	 *   tamanho (m) da tabela hash. Retorna o resto da divisão inteira de k por m.
	 */
	public static int mod(int k, int m) {
		return k % m;
	}
	/*
	 * MIDSquare(int k): esta função hash determina a posição da chave (k) na Tabela Hash.
	 * Para isso, eleva ao quadrado o valor a ser armazenado e toma duas posições do cálculo, 
	 * a segunda e a terceira posições, partindo-se da direita. Logo, retorna um valor qu varia
	 * de 0 a 99.
	 *  Método a ser desenvolvido por você.
	 */
	public static int MIDSquare(int k) {
		long squared = (long) k * k;

		int result = (int) ((squared / 10) % 100);

		return Math.abs(result);
	}
}
