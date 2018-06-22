package elections;

import elections.ElectoralList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainTestElectoralList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

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
			int moyenne;

			ArrayList<ElectoralList> listTable = new ArrayList<ElectoralList>();
			CompareListesElectorales comparator = new CompareListesElectorales();

			System.out.println("Nombre de sièges à pourvoir: ");
			Scanner sc = new Scanner(System.in);
			int seats = sc.nextInt();
			sc.nextLine();

			int i = 1;
			String name = "";

			while (!(name.equals("*"))) {
				ElectoralList list = new ElectoralList();
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
			quotient = total / seats;
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
//			for (int count = 0; count < listTable.size(); count++) {
//				listSeats = listTable.get(count).getSeats();
//				listVoices = listTable.get(count).getVoice();
//				if (restSeats > 0) {
//					moyenne = listVoices / (listSeats + 1);
//					if (count > 0) {
//						listTable.get(count).setVoice(moyenne);
//						int res = comparator.compare(listTable.get(count - 1), listTable.get(count));
//						System.out.println(res);
//						if (res == 1 || res == 0) {
//							listTable.set(0, listTable.get(count));
//							for (int j = 0; j < restSeats; j++) {
//								listTable.get(count).setSeats(seatsNumber2 + 1);
//							}
//						}
//					}
//				}
//			}
			listTable.sort(comparator);
			for (int count = 0; count < listTable.size(); count++) {
				System.out.println("La liste [" + listTable.get(count).getName() + "] a obtenu ["
						+ listTable.get(count).getSeats() + "] siège(s)");
			}
		} catch (ElectionsExceptions ex) {
			System.err.println("L'exception suivante s'est produite : [" + ex.toString() + "]");
		}

	}

}

class CompareListesElectorales implements Comparator {

	public int compare(Object obj1, Object obj2) {
		ElectoralList electoralList1 = (ElectoralList) obj1;
		ElectoralList electoralList2 = (ElectoralList) obj2;
		int voice1 = electoralList1.getVoice();
		int voice2 = electoralList2.getVoice();
		return voice2 - voice1;
	}

}
