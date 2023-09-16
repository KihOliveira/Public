package Atividade4;

public interface Estado {
	public Ataque getA();
	
	public Corrida getC();
	
	Estado perdeVida(int life);
	
	Estado ganhaVida(int life);
	
}
