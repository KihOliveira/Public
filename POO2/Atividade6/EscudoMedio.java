package Atividade6;

public class EscudoMedio extends Escudo{
		
	@Override
	public int reduzDano(int dano) {
		int resto = dano - 10;
		
		if(resto <=0) {
			System.out.println("O dano foi completamente reduzido pelo escudo!");
		}else {
			if(this.getSucessor() != null) {
				this.getSucessor().reduzDano(resto);
			}
		}
		return resto;
	}
		
}
