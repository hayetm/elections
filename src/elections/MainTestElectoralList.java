package elections;

import elections.ElectoralList;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTestElectoralList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<ElectoralList> listTable = new ArrayList<ElectoralList>();

			System.out.println("Nombre de sièges à pourvoir: ");
			Scanner sc = new Scanner(System.in);
			int seats = sc.nextInt();
			sc.nextLine();

			int i = 1;
			String name = "";

			while (!(name.equals("*"))) {
				ElectoralList list = new ElectoralList();
				list.setSeats(seats);
				list.setId(i);
				System.out.println("Nom de la liste " + i + " : ");
				name = sc.nextLine();
				list.setName(name);
				if (name.equals("*"))
					break;
				System.out.println("Voix de la liste [" + name + "]: ");
				int voice = sc.nextInt();
				sc.nextLine();
				list.setVoice(voice);
				i++;
				listTable.add(list);
			}
			int total = 0;
			int quotient = 0;
			int listVoices = 0;
			int restSeats = 0;
			int listSeats = 0;
			int seatsNumber = 0;
			int seatsNumber2 = 0;
			int barreMin = 0;
			int siegesObtenus = 0;
			int somme = 0;
			for (int index = 0; index < listTable.size(); index++) {
				listVoices = listTable.get(index).getVoice();
				total += listVoices;
			}
			barreMin = (total * 5) / 100;
			for (int index = 0; index < listTable.size(); index++) {
				if (listVoices < barreMin) {
					listTable.get(index).setExcluded(true);
				}
			}
			quotient = total / listTable.get(0).getSeats();
			System.out.println(quotient);
			for (int count = 0; count < listTable.size(); count++) {
				listVoices = listTable.get(count).getVoice();
				seatsNumber = listVoices / quotient;
				listTable.get(count).setSeats(seatsNumber);
			}
			for (int count = 0; count < listTable.size(); count++) {
				siegesObtenus = listTable.get(count).getSeats();
				somme = siegesObtenus + somme;
			}
			restSeats = seats - somme;
			for (int count = 0; count < listTable.size(); count++) {
				listSeats = listTable.get(count).getSeats();
				if (restSeats > 0 && listSeats < restSeats) {
					listVoices = listTable.get(count).getVoice();
					seatsNumber2 = listVoices / quotient;
					listTable.get(count).setSeats(seatsNumber2 + seatsNumber);				}
				System.out.println("La liste [" + listTable.get(count).getName() + "] a obtenu ["
						+ listTable.get(count).getSeats() + "] siège(s)");
			}
		} catch (ElectionsExceptions ex) {
			System.err.println("L'exception suivante s'est produite : [" + ex.toString() + "]");
		}

	}

}
