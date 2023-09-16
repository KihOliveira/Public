package Atividade8;

public abstract class AtaqueStrategy {

	private String descricao;
	private int valor;
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor){
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
