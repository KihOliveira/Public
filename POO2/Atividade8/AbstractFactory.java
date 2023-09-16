package Atividade8;

public abstract class AbstractFactory { //Fabrica abstrata a ser herdada
	
	public abstract Personagem criaPersonagem();
	public abstract Inimigo criaInimigo();
	public abstract Escudo criaDefesa(); //Defesa do personagem == escudo
}
