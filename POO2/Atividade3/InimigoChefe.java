package Atividade3;

public class InimigoChefe extends Inimigo implements Observador {
	private int x;
	private int y;
	private String nome;
	private int life = 60;
	
	public InimigoChefe(int x, int y, String nome) {
		super(x, y, nome);
		this.x = x;
		this.y = y;
		this.nome = nome;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void perdeVida(int dano) {
		this.life = life - dano;
	}
	
	public void atacar(Sujeito s) {
		Personagem personagem = (Personagem)s; //Coercao de tipo
		personagem.perderVida(30);
	}
	
	@Override
	public void update(Sujeito s) {
		
		Personagem personagem = (Personagem)s; //Coercao de tipo
		
		if(this.x - personagem.getX() == 0 && this.y - personagem.getY() == 0) { //Se estiver perto do personagem
			this.atacar(personagem);
			System.out.println("Inimigo: "+this.nome+"ataca o personagem");
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
