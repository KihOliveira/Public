package Atividade8;

public interface Sujeito {

	public void addObserver(Observador o);
	
	public void removeObserver(Observador o);
	
	public void notifyObservers();
	
}
