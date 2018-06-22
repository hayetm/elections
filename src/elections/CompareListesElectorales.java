package elections;
import elections.ElectoralList;
import java.util.Comparator;

class CompareListesElectorales implements Comparator<ElectoralList> {
	
	public int compare(ElectoralList electoralList1,
			ElectoralList electoralList2) {
		if(electoralList1 < electoralList2) {
			return 1;
		} else if (electoralList1 > electoralList2) {
			return -1;
		} else {
			return 0;
		}
	}

}
