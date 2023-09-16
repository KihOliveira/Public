package Atividade9;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controle{
	 private Comando slot[] = new Comando[10];
	 private ArrayList<Comando> log = new ArrayList<Comando>();
	 private Macro mac = new Macro();
	 
	 public void executa(Comando c) {
		 c.execute();
		 log.add(c);
	 }
	 
	 public void pressionar(int i){
	        this.slot[i].execute();
	        log.add(slot[i]);
	    }
	
	 public void setCommand(Comando c, int i){
	        this.slot[i] = c;
	    }
	 
	 public void showLog(){
	        for (Comando c : log)
	            System.out.println(c.toString());
	    }
}
