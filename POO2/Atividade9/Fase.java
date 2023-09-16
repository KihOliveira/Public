package Atividade9;

public class Fase implements Component{
	
	private int nInimigos;
	private int velInimigos;
	private String nomeFase;
	private Component caminho1;
	private Component caminho2;
	
	public Fase(int nInimigos, int vel, String nome, Component cam1, Component cam2) {
		this.nInimigos = nInimigos;
		this.velInimigos = vel;
		this.nomeFase = nome;
		this.caminho1 = cam1;
		this.caminho2 = cam2;
	}
	
	@Override
	public void explorar(Personagem p) {
		try{
	          Thread.sleep(2000);
	        }
	        catch(Exception e){
	        }    
	    System.out.println("Personagem "+p.getNome()+" entrou na sala "+this.nomeFase);

	    double valor = Math.random();


	    if (valor < 0.5) {
	        System.out.println("Personagem "+p.getNome()+" pegou caminho 1"); 
	        caminho1.explorar(p);
	            }
	    else {

	        System.out.println("Personagem "+p.getNome()+" pegou caminho 2");   
	        caminho2.explorar(p);

	            }
		
	}

	public int getnInimigos() {
		return nInimigos;
	}

	public void setnInimigos(int nInimigos) {
		this.nInimigos = nInimigos;
	}

	public int getVelInimigos() {
		return velInimigos;
	}

	public void setVelInimigos(int velInimigos) {
		this.velInimigos = velInimigos;
	}

	public String getNomeFase() {
		return nomeFase;
	}

	public void setNomeFase(String nomeFase) {
		this.nomeFase = nomeFase;
	}

	public Component getCaminho1() {
		return caminho1;
	}

	public void setCaminho1(Component caminho1) {
		this.caminho1 = caminho1;
	}

	public Component getCaminho2() {
		return caminho2;
	}

	public void setCaminho2(Component caminho2) {
		this.caminho2 = caminho2;
	}
	

	
	
}
