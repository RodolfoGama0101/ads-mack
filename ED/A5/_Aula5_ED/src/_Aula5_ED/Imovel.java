package _Aula5_ED;

//Classe relativa a um Imovel 
//contendo os atributos id, ano de contrução, tipo 
//preço e área. Além dos métodos getters, setters, construtor
//e toString.
//Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine.

public class Imovel {
	  private int id, anoDeConstrucao;
	  // tipo = 'C' de casa ou 'A' de apto
	  //        'S' de sítio ou 'F' de fazenda
	  private char tipo; 
	  private float preco;
	  private float area;

	  // Construtor da classe imóvel
	  public Imovel(int id, int anoDeConstrucao, char tipo, float preco, float area){ 
	     this.id = id; 
	     this.anoDeConstrucao = anoDeConstrucao;
	     this.tipo = tipo;
	     this.preco = preco; 
	     this.area = area;
	  }
	  public int getId(){
	    		return id;
	  }
	  public int getAnoDeConstrucao(){
			return anoDeConstrucao;
	    }
		public char getTipo(){
			return tipo;
		}
	  	public float getPreco(){
	    		return preco;
	 	}
	  	public float getArea(){
    		return area;
 	}
	  	public void setId(int id){
	    		this.id = id;
	  	}
	  	public void setAnoDeConstrucao(int anoDeConstrucao){
	  		this.anoDeConstrucao = anoDeConstrucao;
	  	}
	  	public void setTipo(char tipo){
	  		this.tipo = tipo;
	  	}
	  	public void setPreco(float preco){
	    		this.preco = preco;
	  	}
	  	public void setArea(float area){
    		this.area = area;
	  	}
		@Override
		public String toString()  {
				StringBuilder sb = new StringBuilder();
				sb.append("[Imóvel] Id: ")
					.append(id)
					.append(", Ano: ")
					.append(anoDeConstrucao)
					.append(", Tipo: ")
					.append(tipo)
					.append(", Preco: ")
					.append(preco)
					.append(", Area: ")
					.append(area);					
				return sb.toString();
		}
}
