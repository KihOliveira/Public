package Atividade6;

public abstract class AtaqueDecorador extends AtaqueStrategy{

	private AtaqueStrategy ataqueDecorado;
	
	public AtaqueDecorador(AtaqueStrategy atDecorado) {
		this.ataqueDecorado = atDecorado;
	}
	
	public String getDescricao() {
		return ataqueDecorado.getDescricao()+","+super.getDescricao();
	}
}
