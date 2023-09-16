package Atividade6;

public class Inimigo implements Observador{
	//Posicao
	private int x;
	private int y;
	
	//Status
	private String nome;
	private int life;
	private int dano;
	
	//Construtor
	public Inimigo(int x, int y, String nome) {
		this.x = x;
		this.y = y;
		this.nome = nome;
	}
	
	
	public void perdeVida(int dano) {
		this.life = life - dano;
	}
	
	//Getters Setters
	public int getDano() {
		return dano;
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

	public String getNome() {
		return nome;
	}

	public int getLife() {
		return life;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	
	
	@Override
	public void update(Sujeito s) {
		
		Personagem personagem = (Personagem)s; //Coercao de tipo
		
		if(this.x - personagem.getX() == 0 && this.y - personagem.getY() == 0) { //Se estiver perto do personagem
			System.out.println("Inimigo: "+this.nome+ "ataca "+personagem.getNome());
			personagem.perderVida(this.getDano());
			
			if(Math.random() < 0.5) {
				personagem.setPos(personagem.getX()+5, personagem.getY()-5);
			}else {
				personagem.setPos(personagem.getX()-5, personagem.getY()+5);
			}
		}else {
			if(personagem.getX() > this.x) {
				this.x = this.x+2;
			}else {
				this.x = this.x-2;
			}
			if(personagem.getY()>this.y) {
				this.y = this.y+2;
			}else {
				this.y = this.y-2;
			}
		}
		
		
	}

}
