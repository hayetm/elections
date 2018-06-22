package elections;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTestElections {

	@Test
	public void t1() {
		// création liste électorale
		ElectoralList liste = new ElectoralList(1, "a", 32000, 0, false);
		// vérifications
		Assert.assertEquals("a", liste.getName());
		Assert.assertEquals(32000, liste.getVoice());
		Assert.assertEquals(false, liste.isExcluded());
		Assert.assertEquals(0, liste.getSeats());
		// vérification validité id
		boolean erreur = false;
		try {
			liste.setId(-4);
		} catch (ElectionsExceptions e) {
			erreur = true;
		}
		Assert.assertEquals(true, erreur);
		// vérification validité nom
		erreur = false;
		try {
			liste.setName("");
		} catch (ElectionsExceptions e) {
			erreur = true;
		}
		Assert.assertEquals(true, erreur);
		// vérification validité voix
		erreur = false;
		try {
			liste.setVoice(-4);
		} catch (ElectionsExceptions e) {
			erreur = true;
		}
		Assert.assertEquals(true, erreur);
		// vérification validité sièges
		erreur = false;
		try {
			liste.setSeats(-4);
		} catch (ElectionsExceptions e) {
			erreur = true;
		}
		Assert.assertEquals(true, erreur);
	}

}
