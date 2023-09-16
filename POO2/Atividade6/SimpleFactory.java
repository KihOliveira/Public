package Atividade6;
import java.math.*;
import java.util.*;

import Atividade7.EstadoPerigo;

public abstract class SimpleFactory {
	
	public static Personagem criaPersonagem() {
		Personagem p = new Personagem(0,0,"Default"); //Personagem base
		if(Math.random() <= 0.2) {
			p.setEstado(new EstadoForte());
			p.setA(p.getE().getA());
			p.setLife(80);
			p.setNome("Knight");
		}
		else if (Math.random() > 0.2 && Math.random() <= 0.4) {
			p.setEstado(new EstadoNormal());
			p.setA(new AtaqueForte());
			p.setLife(50);
			p.setNome("Rogue");
		}
		else if (Math.random() > 0.4 && Math.random() <= 0.6) {
			p.setEstado(new EstadoForte());
			p.setA(new AtaqueFraco());
			p.setLife(90);
			p.setNome("Guardian");
		}
		else if (Math.random() > 0.6 && Math.random() <= 0.8) {
			p.setEstado(new EstadoNormal());
			p.setA(new DecoracaoFogo(new AtaqueForte()));
			p.setLife(40);
			p.setNome("Mage");
		}
		else if (Math.random() > 0.8) {
			p.setEstado(new EstadoNormal());
			p.setA(p.getE().getA());
			p.setLife(30);
			p.setNome("Villager");
		}
		return p;
	}
	
	public static Inimigo criaInimigo() {
		Inimigo i = new Inimigo(50,50,"Default"); //Inimigo base
		if(Math.random() <= 0.4) {
			i.setDano(10);
			i.setLife(20);
			i.setNome("Inimigo Pequeno");
		}
		else if (Math.random() > 0.4 && Math.random() <= 0.9) {
			i.setDano(15);
			i.setLife(40);
			i.setNome("Inimigo Medio");
		}
		else if (Math.random() > 0.9) {
			i.setDano(30);
			i.setLife(60);
			i.setNome("Inimigo Grande");
		}
		return i;
	}
}
