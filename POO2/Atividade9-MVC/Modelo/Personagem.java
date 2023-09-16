package Modelo;
import java.util.ArrayList;

public class Personagem implements Sujeito {
	
	//Posiçao do personagem no jogo
	private int x;
	private int y;
	
	//Status
	private AtaqueStrategy a;
	private int life;
	private String nome;
	private Corrida c;
	
	//Estado atual
	private Estado e;
	
	//Lista de inimigos observando
	private ArrayList <Observador> lista = new ArrayList <Observador>(); 
	
	//Escudos
	private Escudo escudoLeve;
	private Escudo escudoMedio;
	private Escudo escudoAtual;
	private Escudo escudoZerado;
	
	//Construtor
	public Personagem(int x, int y, String nome) { 
		this.x = x;
		this.y = y;
		this.life = 70;
		this.nome = nome;
		this.e = new EstadoNormal();
		setEstado(e);
		this.escudoLeve = new EscudoLeve();
		this.escudoMedio = new EscudoMedio();
		this.escudoAtual = new EscudoMedio();
		this.escudoZerado = new EscudoZerado();
	}

	//Funcoes de Movimento/Acoes
	public void moverEsq(){
        setX(getX()-10);
    }
    
    public void moverDir(){
        setX(getX()+10);
    }
    
    public void moverCima(){
        setY(getY()-10);
    }

    public void moverBaixo(){
        setY(getY()+10);
    }
	
	public void atacar() {
		for(Observador o : lista) {
			Inimigo inimigo = (Inimigo)o;
			if(this.x - inimigo.getX() == 0 && this.y - inimigo.getY() == 0) {
				inimigo.perdeVida(getA().getValor());
				inimigo.setX(inimigo.getX()-5); //Empurra o inimigo
				inimigo.setY(inimigo.getY()-5);
				}
			}
		}
    
	public void pular() {
		System.out.println("Pula");
	}
	
	public void magia() {
		System.out.println("Solta magia");
	}
	
	public void abaixar() {
		System.out.println("Abaixa");
	}
	
	
	//Funcoes de Observers
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
	
	public void show() {
		notifyObservers();
	}
	
	//Funcoes de Estado
	public void mostraEstado() { //Funçao para mostrar o estado atual
		System.out.println("Estado atual: "+this.getE());
		System.out.println("Ataque atual: "+e.getA());
		System.out.println("Corrida atual: "+e.getC());
	}
	
	public void perderVida(int dano) { //Funcao responsavel por diminuir a life e alterar o estado de acordo
		if(this.escudoAtual != escudoZerado) {
			dano = this.escudoAtual.reduzDano(dano);
			if(this.escudoAtual.getSucessor() != escudoZerado) { //Muda o escudo atual para o proximo que restou
			this.setEscudoAtual(this.escudoAtual.getSucessor());
				}
			}
		if(dano > 0) { //Evitar dano negativo
			this.life = this.life - dano;
			 setEstado(e.perdeVida(this.life));
			}
	}
	
	public void ganharVida(int life) { //Funcao responsavel por aumentar a life e alterar o estado de acordo
		this.life = this.life + life;
		setEstado(e.ganhaVida(this.life));
	}
	
	public void setEstado(Estado e) { //Funcao responsavel por setar o estado e os atributos relaciconados a ele
		setE(e);
		setC(e.getC());
		setA(e.getA());
	}
	
	//Getters/Setters
	public AtaqueStrategy getA() {
		return this.a;
	}

	public void setA(AtaqueStrategy a) {
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
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Escudo getEscudoAtual() {
		return escudoAtual;
	}

	public void setEscudoAtual(Escudo escudo) {
		this.escudoAtual = escudo;
	}

	/*public void movimentar() {
		c.correr();
	}*/

}
