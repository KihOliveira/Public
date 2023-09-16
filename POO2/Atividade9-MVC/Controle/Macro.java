package Controle;
import java.util.ArrayList;

public class Macro implements Comando{
	
	ArrayList<Comando> macro = new ArrayList<Comando>();
	
	public void addCommand(Comando c){
		 macro.add(c); } 
	
	@Override
	public void execute() {
		for (Comando c: macro) {
			 c.execute();
			 }
		
	}

}
