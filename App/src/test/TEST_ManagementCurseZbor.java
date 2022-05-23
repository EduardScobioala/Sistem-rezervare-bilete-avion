package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import functionalities.ManagementCurseZbor;

class TEST_ManagementCurseZbor {
	ManagementCurseZbor obj = new ManagementCurseZbor();
	
	//test saveCursaZbor()
	@Test
	void test_saveCursaZbor() {
		
		try {
		obj.saveCursaZbor();
		}catch(IOException e)
		{
			System.out.println(e+"IOException thrown - saveCursaZbor");
			fail();
		}
	}
	
	//test findCursa()
	@Test
	void test_findCursa_null() {
		assertEquals(obj.findCursa(null),null);
	}
	
	@Test
	void test_findCursa_empty() {
		assertEquals(obj.findCursa(""),null);
	}
}
