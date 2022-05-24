package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.RezervareZborFrame;

class TEST_RezervareZborFrame {
	RezervareZborFrame obj = new RezervareZborFrame(false);
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	// TESTE pentru functia numeOrasValid
	
	// nume oras null
	@Test
	void test_numeOrasValid1() {
		assertEquals(obj.numeOrasValid(null), false);
	}
	
	// nume oras gol
	@Test
	void test_numeOrasValid2() {
		assertEquals(obj.numeOrasValid(""), false);
	}
	
	// nume oras corect
	@Test
	void test_numeOrasValid3() {
		assertEquals(obj.numeOrasValid("Iasi"), true);
	}

	// TESTE pentru functia dateValide()
	
	// date1 = prezent, tur
	@Test
	void test_dateValide_toate1() {
		assertEquals(obj.dateValide(new Date(), new Date(1000), false), true);
	}

	
	// date1 = prezent, date2 = trecut, tur-retur
	@Test
	void test_dateValide2() {
		assertEquals(obj.dateValide(new Date(), new Date(1000), true), false);
	}

	// date1 = viitor, tur
	@Test
	void test_dateValide3() {
		assertEquals(obj.dateValide(new Date(System.currentTimeMillis()+1), new Date(), false), true);
	}
	
	// date1 = prezent, date2 = viitor, tur-retur
	@Test
	void test_dateValide4() {
		assertEquals(obj.dateValide(new Date(), new Date(System.currentTimeMillis()+1), true), true);
	}
}
