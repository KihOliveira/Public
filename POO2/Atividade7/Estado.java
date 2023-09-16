package Atividade7;

public interface Estado {
	public AtaqueStrategy getA();
	
	public Corrida getC();
	
	Estado perdeVida(int life);
	
	Estado ganhaVida(int life);
	
}
