package Atividade3;
import java.util.Observable;
import java.util.ArrayList;

public class Personagem implements Sujeito {
	//Posiçao do personagem no jogo
	private int x;
	private int y;
	//Atributos
	private Ataque a;
	private int ValorAtaque;
	private Corrida c;
	private int life;
	private String nome;
	//Estado atual
	private Estado e;
	//Lista de inimigos observando
	private ArrayList <Observador> lista = new ArrayList <Observador>(); 
	
	public Personagem(int x, int y, String nome) { //Construtor
		this.x = x;
		this.y = y;
		this.life = 70;
		this.nome = nome;
		this.e = new EstadoNormal(new AtaqueMedio(),new CorridaMedia());
		setEstado(e);
	}
	
	public int tamArray() {
		return this.lista.size();
	}
	
	@Override
	public void addObserver(Observador o) {
		lista.add(o);
		
	}

	@Override
	public void removeObserver(Observador o) {
		lista.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for(Observador o : lista) {
			o.update(this);
		}
		
	}
	
	public void mostraEstado() { //Funçao para mostrar o estado atual
		System.out.println("Estado atual: "+this.getE());
		System.out.println("Ataque atual: "+e.getA());
		System.out.println("Corrida atual: "+e.getC());
	}
	
	public void perderVida(int life) { //Funcao responsavel por diminuir a life e alterar o estado de acordo
		this.life = this.life - life;
		  setEstado(e.perdeVida(this.life));
	}
	
	public void ganharVida(int life) { //Funcao responsavel por aumentar a life e alterar o estado de acordo
		this.life = this.life + life;
		setEstado(e.ganhaVida(this.life));
	}
	
	public void setEstado(Estado e) { //Funcao responsavel por setar o estado e os atributos relaciconados a ele
		setE(e);
		setA(e.getA());
		setC(e.getC());
		setValorAtaque(e.getA().atacar());
	}
	
	public Ataque getA() {
		return this.a;
	}

	public void setA(Ataque a) {
		this.a = a;
	}

	public Corrida getC() {
		return this.c;
	}

	public void setC(Corrida c) {
		this.c = c;
	}
	
	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getValorAtaque() {
		return ValorAtaque;
	}

	public void setValorAtaque(int valorAtaque) {
		ValorAtaque = valorAtaque;
	}

	public void show() {
		notifyObservers();
	}
	
	public void atacar() {
		for(Observador o : lista) {
			Inimigo inimigo = (Inimigo)o;
			if(this.x - inimigo.getX() == 0 && this.y - inimigo.getY() == 0) {
				inimigo.perdeVida(getValorAtaque());
				if(inimigo.getLife()<=0) {
					removeObserver(o);
					
				}
			}
		}
		
		}
	
	/*public void movimentar() {
		c.correr();
	}*/

}
