package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.RezervareZborFrame;

class TEST_RezervareZborFrame {
	RezervareZborFrame obj = new RezervareZborFrame();
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
	void test_dateValide_toate() {
		int[] data1 = { 2, 2, 2 };
		int[] data2 = { 1, 1, 1 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_an() {
		int[] data1 = { 1, 1, 2 };
		int[] data2 = { 1, 1, 1 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_luna() {
		int[] data1 = { 1, 2, 1 };
		int[] data2 = { 1, 1, 1 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_zi() {
		int[] data1 = { 2, 1, 1 };
		int[] data2 = { 1, 1, 1 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// lungime vectori gresita
	@Test
	void test_dateValide_intLength1() {
		int[] data1 = { 1, 2, 1, 0 };
		int[] data2 = { 1, 1, 1 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_intLength2() {
		int[] data1 = { 1, 2, 1 };
		int[] data2 = { 1, 1, 1, 0 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// zi gresita
	// zi > 31
	@Test
	void test_dateValide_ziGresita1_32() {
		int[] data1 = { 32, 1, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_ziGresita2_32() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 32, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_ziGresita12_32() {
		int[] data1 = { 32, 1, 2022 };
		int[] data2 = { 32, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// zi = 0
	@Test
	void test_dateValide_ziGresita1_0() {
		int[] data1 = { 0, 1, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_ziGresita2_0() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 0, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_ziGresita12_0() {
		int[] data1 = { 0, 1, 2022 };
		int[] data2 = { 0, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// zi < 0
	@Test
	void test_dateValide_ziGresita1_lt0() {
		int[] data1 = { -1, 1, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_ziGresita2_lt0() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { -1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_ziGresita12_lt0() {
		int[] data1 = { -1, 1, 2022 };
		int[] data2 = { -1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// luna gresita
	// luna >12
	@Test
	void test_dateValide_lunaGresita1_13() {
		int[] data1 = { 1, 13, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_lunaGresita2_13() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 1, 13, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_lunaGresita12_13() {
		int[] data1 = { 1, 13, 2022 };
		int[] data2 = { 1, 13, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// luna = 0
	@Test
	void test_dateValide_lunaGresita1_0() {
		int[] data1 = { 1, 0, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_lunaGresita2_0() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 1, 0, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_lunaGresita12_0() {
		int[] data1 = { 1, 0, 2022 };
		int[] data2 = { 1, 0, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// luna < 0
	@Test
	void test_dateValide_lunaGresita1_lt0() {
		int[] data1 = { 1, -1, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_lunaGresita2_lt0() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 1, -1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_lunaGresita12_lt0() {
		int[] data1 = { 1, -1, 2022 };
		int[] data2 = { 1, -1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// an gresit
	// an <2022
	@Test
	void test_dateValide_anGresit1_2021() {
		int[] data1 = { 1, 1, 2021 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_anGresit2_2021() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 1, 1, 2021 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_anGresit12_2021() {
		int[] data1 = { 1, 1, 2021 };
		int[] data2 = { 1, 1, 2021 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// data1 > data2

	@Test
	void test_dateValide_data1_gt_data2_zi() {
		int[] data1 = { 2, 1, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_data1_gt_data2_luna() {
		int[] data1 = { 1, 2, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	@Test
	void test_dateValide_data1_gt_data2_an() {
		int[] data1 = { 1, 1, 2023 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), false);
	}

	// date corecte

	@Test
	void test_dateValide_dateCorecte_1() {
		int[] data1 = { 1, 1, 2022 };
		int[] data2 = { 1, 1, 2022 };

		assertEquals(obj.dateValide(data1, data2), true);
	}

	@Test
	void test_dateValide_dateCorecte_2() {
		int[] data1 = { 2, 1, 2022 };
		int[] data2 = { 1, 2, 2022 };

		assertEquals(obj.dateValide(data1, data2), true);
	}

	@Test
	void test_dateValide_dateCorecte_3() {
		int[] data1 = { 2, 1, 2022 };
		int[] data2 = { 1, 2, 2023 };

		assertEquals(obj.dateValide(data1, data2), true);
	}
}
