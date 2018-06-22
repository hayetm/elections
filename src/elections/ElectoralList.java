package elections;

import java.util.ArrayList;
import java.util.List;

public class ElectoralList {
	
	private int id;
	private String name;
	private int voice;
	private int seats;
	private boolean excluded;
	
	public ElectoralList() {
		ArrayList list = new ArrayList();
	}
		
	public ElectoralList(int id, String name, int voice, int seats, boolean excluded) {
		this.id = id;
		this.name = name;
		this.voice = voice;
		this.seats = seats;
		this.excluded = excluded;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		if(this.id < 0) {

			throw new ElectionsExceptions("la valeur de id est incorrecte");

		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		if(this.name.length() == 0) {

			throw new ElectionsExceptions("la valeur de name est incorrecte");

		}
	}
	
	public int getVoice() {
		return voice;
	}
	
	public void setVoice(int voice) {
		this.voice = voice;
		if(this.voice < 0) {

			throw new ElectionsExceptions("la valeur de voice est incorrecte");

		}
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
		if(this.seats < 0) {

			throw new ElectionsExceptions("la valeur de seats est incorrecte");

		}
	}
	
	public boolean isExcluded() {
		return excluded;
	}
	
	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}
	
	public String toString() {

		return "ElectoralList [id=" + id + ", name=" + name + ", voice=" + voice + ", seats=" + seats + ", excluded="
		+ excluded + "]";

	}

}
