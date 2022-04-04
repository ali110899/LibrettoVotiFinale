package it.polito.tdp.librettovoti.mio;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto(); //creo il libretto
		lib.add(new Voto("Analisi 1", 30));  //con il metodo add aggiungo un nuovo voto
		lib.add(new Voto("Fisica 1", 25));
		lib.add(new Voto("Informatica ", 27));
		lib.add(new Voto("Chimica", 22));
		lib.add(new Voto("AlgebraLineare", 25));
		
		System.out.println(lib);
		System.out.print("\n");
		
		System.out.println("Voti pari a 25");
		Libretto lib25 = lib.FiltraPunteggio(25);
		System.out.println(lib25);
		System.out.print("\n");
		
		//Libretto libcorso = lib.PunteggioEsame("Analisi 1"));
		//System.out.printl("Il punteggio ottenuto è:" +)
		
		
	}
	
	
}
