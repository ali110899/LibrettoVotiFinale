package it.polito.tdp.librettovoti.mio;

public class Voto {
	
	private String corso;
	private int punteggio;
	
	public Voto(String corso, int punteggio) {
		super();
		this.corso = corso;
		this.punteggio = punteggio;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	@Override
	public String toString() {  //l'oggetto voto accetta la richiesta dal libretto di stamparsi
		return corso+" = "+punteggio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + punteggio;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (punteggio != other.punteggio)
			return false;
		return true;
	}

}
