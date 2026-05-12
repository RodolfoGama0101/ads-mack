package dev.rodolfo;
// Autores: Ivan Carlos Alcântara de Oliveira e Jean Marcos Laine.

// Autor 2: Rodolfo Figueiredo Gama | 10742570
// Data da Atualização: 11/05/2026

public class Veiculo implements Comparable<Veiculo> {
    private String placa; 
    private int ano; 
    private float preco;
    // Os tipos de carro são: passeio, carga, suv e "pick_up".
    // detalhes em: 
    // https://www.fullpneus.com.br/qual-a-diferenca-entre-carros-de-passeio-carga-suv-
    //ou-pick-up?srsltid=AfmBOoqXvOlQl-BYqV_d5vmNWClT7h1eRu1HnEH8bMeWAnzim5_KHVWV
    
    private String tipo; 

    public Veiculo () {
        placa="-";
        ano=0; preco=0.0f; tipo="-";
    }    
    public Veiculo (String placa, int ano, float preco, String tipo)
    {
        setPlaca(placa); // ou usar:  this.placa = placa;
        setAno(ano); 
        setPreco(preco); 
        setTipo(tipo);
    }  
    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }
    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = 0;
        if(ano>1900)this.ano = ano;
    }
    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }
    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = 0.0f;
        if(preco>0)this.preco = preco;
    }
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public int compareTo(Veiculo outro) {  // comparamos as Placas
        if(placa.compareTo(outro.getPlaca()) < 0) return -1;
        else if(placa.compareTo(outro.getPlaca()) == 0) return 0;
        else return  1;
    }   
    @Override   
    public String toString() {
        return ("[Veículo] "+ getPlaca()  
                + ",  " + getAno() 
                + ",  R$" + getPreco()  
                + ",  " + getTipo() + ".\n" );
    }    
}
