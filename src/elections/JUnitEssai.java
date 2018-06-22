package elections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitEssai {

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("tearUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	void test1() {
		System.out.println("test1");
		Assert.assertEquals(1, 1);
	}
	
	@Test
	void test2() {
		System.out.println("test2");
		Assert.assertEquals(2, 3);
	}

}
