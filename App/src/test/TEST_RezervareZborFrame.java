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
	
	/*
	// teste pentru functia numeOrasValid()

	// nume gresite
	// nume = "" (empty string)
	@Test
	void test_numeOrasValid_null() {
		assertEquals(obj.numeOrasValid(""), false);
	}

	// nume inexistent
	@Test
	void test_numeOrasValid_inexistent() {
		assertEquals(obj.numeOrasValid("Hogwarts"), false);
	}

	// nume scris gresit: initiala litera mica
	@Test
	void test_numeOrasValid_scrisGresitInitiala() {
		assertEquals(obj.numeOrasValid("tImisoara"), false);
	}

	// nume scris gresit: alte litere scrise gresit
	@Test
	void test_numeOrasValid_alteLitere() {
		assertEquals(obj.numeOrasValid("BucuRestI"), false);
	}

	// nume scris gresit: cifre
	@Test
	void test_numeOrasValid_cifreLast() {
		assertEquals(obj.numeOrasValid("Oradea1"), false);
	}

	@Test
	void test_numeOrasValid_cifreFirst() {
		assertEquals(obj.numeOrasValid("2Iasi"), false);
	}

	@Test
	void test_numeOrasValid_cifreSecond() {
		assertEquals(obj.numeOrasValid("C3onstanta"), false);
	}

	@Test
	void test_numeOrasValid_cifreMiddle() {
		assertEquals(obj.numeOrasValid("Chis4ineu"), false);
	}

	// nume scris gresit: alte caractere
	@Test
	void test_numeOrasValid_alteCaractereFirst() {
		assertEquals(obj.numeOrasValid("#Oradea"), false);
	}

	@Test
	void test_numeOrasValid_alteCaractereLast() {
		assertEquals(obj.numeOrasValid("Craiova@"), false);
	}

	@Test
	void test_numeOrasValid_alteCaractereMiddle() {
		assertEquals(obj.numeOrasValid("Galat!i"), false);
	}

	@Test
	void test_numeOrasValid_alteCaractereSecond() {
		assertEquals(obj.numeOrasValid("T%argoviste"), false);
	}

	// nume scris gresit
	@Test
	void test_numeOrasValid_all() {
		assertEquals(obj.numeOrasValid("1Cl#uj-Napoca3"), false);
	}

	// nume corecte
	@Test
	void test_numeOrasValid_Arad() {
		assertEquals(obj.numeOrasValid("Arad"), true);
	}

	@Test
	void test_numeOrasValid_Cluj_Napoca() {
		assertEquals(obj.numeOrasValid("Cluj-Napoca"), true);
	}

	@Test
	void test_numeOrasValid_Constanta() {
		assertEquals(obj.numeOrasValid("Constanța"), true);
	}
	*/
	// teste pentru functia dateValide()
	// date gresite
	@Test
	void test_dateValide_toate1() {
		assertEquals(obj.dateValide(new Date(), new Date(1000), false), true);
	}

	@Test
	void test_dateValide2() {
		assertEquals(obj.dateValide(new Date(), new Date(1000), true), false);
	}

	@Test
	void test_dateValide3() {
		assertEquals(obj.dateValide(new Date(System.currentTimeMillis()+1), new Date(), false), true);
	}
	
	@Test
	void test_dateValide4() {
		assertEquals(obj.dateValide(new Date(), new Date(System.currentTimeMillis()+1), true), true);
	}
}
