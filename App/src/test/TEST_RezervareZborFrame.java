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
	void test_numeOrasValid_null() {
		assertEquals(obj.numeOrasValid(null), false);
	}
	
	// nume oras gol
	@Test
	void test_numeOrasValid_empty() {
		assertEquals(obj.numeOrasValid(""), false);
	}
	
	// nume oras corect
	@Test
	void test_numeOrasValid_correct() {
		assertEquals(obj.numeOrasValid("Iasi"), true);
	}

	// TESTE pentru functia dateValide()
	
	// date1 = prezent, date2 = trecut tur
	@Test
	void test_dateValide_prezent_trecut_tur() {
		assertEquals(obj.dateValide(new Date(), new Date(1000), false), true);
	}

	
	// date1 = prezent, date2 = trecut, tur-retur
	@Test
	void test_dateValide_prezent_trecut_turRetur() {
		assertEquals(obj.dateValide(new Date(), new Date(1000), true), false);
	}

	// date1 = viitor, date2 = prezent, tur
	@Test
	void test_dateValide_viitor_prezent_tur() {
		assertEquals(obj.dateValide(new Date(System.currentTimeMillis()+1), new Date(), false), true);
	}
	
	// date1 = prezent, date2 = viitor, tur-retur
	@Test
	void test_dateValide_prezent_viitor_turRetur() {
		assertEquals(obj.dateValide(new Date(), new Date(System.currentTimeMillis()+1), true), true);
	}
}
