package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.VizualizareZborFrame;

class TEST_VizualizareZborFrameTest {
	VizualizareZborFrame obj = new VizualizareZborFrame();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	// teste pentru functia numeValid
	// nume gresite
	@Test
	void test_numeValid_null() {
		assertEquals(obj.numeValid(null), false);
	}

	@Test
	void test_numeValid_emptyString() {
		assertEquals(obj.numeValid(""), false);
	}

	@Test
	void test_numeValid_firstSmallLetter() {
		assertEquals(obj.numeValid("dEian"), false);
	}

	@Test
	void test_numeValid_firstLetter1() {
		assertEquals(obj.numeValid("1Eian"), false);
	}

	@Test
	void test_numeValid_firstMiddle1() {
		assertEquals(obj.numeValid("De{an"), false);
	}

	@Test
	void test_numeValid_allCAPS() {
		assertEquals(obj.numeValid("PAUL"), false);
	}

	@Test
	void test_numeValid_allSmallLetters() {
		assertEquals(obj.numeValid("trif"), false);
	}

	@Test
	void test_numeValid_spaces() {
		assertEquals(obj.numeValid("Paul Deian"), false);
	}

	@Test
	void test_numeValid_spacesAndSmallLetters1() {
		assertEquals(obj.numeValid("paul Deian"), false);
	}

	@Test
	void test_numeValid_spacesAndSmallLetters2() {
		assertEquals(obj.numeValid("Paul deian"), false);
	}

	@Test
	void test_numeValid_spacesAndAllCAPS() {
		assertEquals(obj.numeValid("TRIF DEIAN"), false);
	}

	@Test
	void test_numeValid_spacesAndAllSmallLetters() {
		assertEquals(obj.numeValid("trif paul"), false);
	}

	@Test
	void test_numeValid_spacesNumbersAndSymbols1() {
		assertEquals(obj.numeValid("Tri1f P#aul De	ian"), false);
	}

	@Test
	void test_numeValid_spacesNumbersAndSymbols2() {
		assertEquals(obj.numeValid("tr3if #paul de4ian"), false);
	}

	@Test
	void test_numeValid_Numbers() {
		assertEquals(obj.numeValid("Tri1f"), false);
	}

	@Test
	void test_numeValid_Symbols() {
		assertEquals(obj.numeValid("Tr#if"), false);
	}

	@Test
	void test_numeValid_smallLettersNumbersAndSymbols() {
		assertEquals(obj.numeValid("de1ian@"), false);
	}

	// nume corecte
	@Test
	void test_numeValid_valid1() {
		assertEquals(obj.numeValid("Trif"), true);
	}

	@Test
	void test_numeValid_valid2() {
		assertEquals(obj.numeValid("Paul"), true);
	}

	// teste pentru functia emailValid
	// e-mail incorect
	@Test
	void test_emailValid_noAT() {
		assertEquals(obj.emailValid("emailserver.com"), false);
	}

	@Test
	void test_emailValid_space1() {
		assertEquals(obj.emailValid("ema il@server.com"), false);
	}

	@Test
	void test_emailValid_space2() {
		assertEquals(obj.emailValid("email@server .com"), false);
	}

	@Test
	void test_emailValid_noDOT() {
		assertEquals(obj.emailValid("email@servercom"), false);
	}

	@Test
	void test_emailValid_null() {
		assertEquals(obj.emailValid(null), false);
	}

	@Test
	void test_emailValid_empty() {
		assertEquals(obj.emailValid(""), false);
	}

	// e-mail corect
	@Test
	void test_emailValid_valid() {
		assertEquals(obj.emailValid("email@server.com"), true);
	}

	// teste pentru functia CVCValid
	// CVC incorect
	@Test
	void test_CVCValid_allLetters() {
		assertEquals(obj.CVCValid("abc"), false);
	}

	@Test
	void test_CVCValid_allLettersCAPS() {
		assertEquals(obj.CVCValid("ABC"), false);
	}

	@Test
	void test_CVCValid_lettersFirst() {
		assertEquals(obj.CVCValid("a23"), false);
	}

	@Test
	void test_CVCValid_lettersLast() {
		assertEquals(obj.CVCValid("12a"), false);
	}

	@Test
	void test_CVCValid_lettersCAPSLast() {
		assertEquals(obj.CVCValid("12c"), false);
	}

	@Test
	void test_CVCValid_lettersCAPSFirst() {
		assertEquals(obj.CVCValid("a23"), false);
	}

	@Test
	void test_CVCValid_symbolsLast() {
		assertEquals(obj.CVCValid("12#"), false);
	}

	@Test
	void test_CVCValid_symbolsFirst() {
		assertEquals(obj.CVCValid("@23"), false);
	}

	@Test
	void test_CVCValid_spacesFirst() {
		assertEquals(obj.CVCValid(" 123"), false);
	}

	@Test
	void test_CVCValid_spacesLast() {
		assertEquals(obj.CVCValid("123 "), false);
	}

	@Test
	void test_CVCValid_spacesMiddle() {
		assertEquals(obj.CVCValid("1 23"), false);
	}

	@Test
	void test_CVCValid_wrongLengthShort() {
		assertEquals(obj.CVCValid("12"), false);
	}

	@Test
	void test_CVCValid_wrongLengthLong() {
		assertEquals(obj.CVCValid("1234"), false);
	}

	@Test
	void test_CVCValid_null() {
		assertEquals(obj.CVCValid(null), false);
	}

	@Test
	void test_CVCValid_empty() {
		assertEquals(obj.CVCValid(""), false);
	}

	// CVC corect
	@Test
	void test_CVCValid_valid() {
		assertEquals(obj.CVCValid("123"), true);
	}

	// teste pentru functia nrCardContValid
	// NrCardCont incorect
	@Test
	void test_nrCardContValid_nrCard_wrongLengthShort() {
		assertEquals(obj.nrCardContValid("123", true), false);
	}

	@Test
	void test_nrCardContValid_nrCard_wrongLengthLong() {
		assertEquals(obj.nrCardContValid("12345678901234567", true), false);
	}

	@Test
	void test_nrCardContValid_nrCont_wrongLengthShort() {
		assertEquals(obj.nrCardContValid("1234", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_wrongLengthLong() {
		assertEquals(obj.nrCardContValid("RO34567890123456789012345", false), false);
	}

	@Test
	void test_nrCardContValid_nrCard_middle_gt_Z() {
		assertEquals(obj.nrCardContValid("123456789012345a", true), false);
	}

	@Test
	void test_nrCardContValid_nrCard_symbol() {
		assertEquals(obj.nrCardContValid("123456#789012345", true), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letters() {
		assertEquals(obj.nrCardContValid("RO34b567890123457890123", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_symbol() {
		assertEquals(obj.nrCardContValid("RO3456#789012345", false), false);
	}

	@Test
	void test_nrCardContValid_nrCard_space() {
		assertEquals(obj.nrCardContValid("1234 56789012345", true), false);
	}

	@Test
	void test_nrCardContValid_nrCont_space() {
		assertEquals(obj.nrCardContValid("RO3456 78901234567890123", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_null() {
		assertEquals(obj.nrCardContValid(null, false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_empty() {
		assertEquals(obj.nrCardContValid("", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter1_lt_A() {
		assertEquals(obj.nrCardContValid("1O1234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter1_gt_Z() {
		assertEquals(obj.nrCardContValid("rO1234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter2_lt_A() {
		assertEquals(obj.nrCardContValid("R11234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter2_gt_Z() {
		assertEquals(obj.nrCardContValid("Ro1234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_middle_gt_Z() {
		assertEquals(obj.nrCardContValid("RO123456789a123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_middle_gt_9_lt_A() {
		assertEquals(obj.nrCardContValid("RO1234:67890123456789012", false), false);
	}

	// NrCardCont corect
	@Test
	void test_nrCardContValid_nrCard_valid() {
		assertEquals(obj.nrCardContValid("1234567890123456", true), true);
	}

	@Test
	void test_nrCardContValid_nrCont_valid() {
		assertEquals(obj.nrCardContValid("RO3456789012345678901234", false), true);
	}

	// teste pentru functia dataExpirareValida
	// data incorecta
	@Test
	void test_dataExpirareValida_ziInvalida_minus1() {
		int[] data = { -1, 1, 2022 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_ziInvalida32() {
		int[] data = { 32, 1, 2022 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_ziInvalida_0() {
		int[] data = { 0, 1, 2022 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_lunaInvalida_minus1() {
		int[] data = { 1, -1, 2022 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_lunaInvalida_13() {
		int[] data = { 1, 13, 2022 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_lunaInvalida_0() {
		int[] data = { 1, 0, 2022 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_anInvalid_minus1() {
		int[] data = { 1, 1, -1 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_anInvalid_0() {
		int[] data = { 1, 1, 0 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_null() {

		assertEquals(obj.dataExpirareValida(null), false);
	}

	@Test
	void test_dataExpirareValida_ziInvalida2() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH), aux.get(Calendar.YEAR) - 1 };
		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_zi() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, aux.get(Calendar.MONTH) + 1, aux.get(Calendar.YEAR) };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_luna() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, aux.get(Calendar.MONTH), aux.get(Calendar.YEAR) };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_an() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, aux.get(Calendar.MONTH) + 1, aux.get(Calendar.YEAR) - 1 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	// data corecta
	@Test
	void test_dataExpirareValida_valid2() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, 8, aux.get(Calendar.YEAR) + 1 };

		assertEquals(obj.dataExpirareValida(data), true);
	}

	@Test
	void test_dataExpirareValida_valid3() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH) + 1, aux.get(Calendar.YEAR) };

		assertEquals(obj.dataExpirareValida(data), true);
	}

	@Test
	void test_dataExpirareValida_valid4() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH) + 2, aux.get(Calendar.YEAR) };

		assertEquals(obj.dataExpirareValida(data), true);
	}

	@Test
	void test_dataExpirareValida_valid5() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH) + 2, 2019 };

		assertEquals(obj.dataExpirareValida(data), false);
	}

	// teste pentru functia sumaCashValida
	// suma incorecta
	@Test
	void test_sumaCashValida_minus1() {
		assertEquals(obj.sumaCashValida("-1.00"), false);
	}

	@Test
	void test_sumaCashValida_lettersLast() {
		assertEquals(obj.sumaCashValida("123.00a"), false);
	}

	@Test
	void test_sumaCashValida_lettersFirst() {
		assertEquals(obj.sumaCashValida("a123.00"), false);
	}

	@Test
	void test_sumaCashValida_lettersMiddle() {
		assertEquals(obj.sumaCashValida("1a23.00"), false);
	}

	@Test
	void test_sumaCashValida_sSpaceLast() {
		assertEquals(obj.sumaCashValida("123.00 "), false);
	}

	@Test
	void test_sumaCashValida_spaceFirst() {
		assertEquals(obj.sumaCashValida(" 123.00"), false);
	}

	@Test
	void test_sumaCashValida_spaceMiddle() {
		assertEquals(obj.sumaCashValida("1 23.00"), false);
	}

	@Test
	void test_sumaCashValida_symbolLast() {
		assertEquals(obj.sumaCashValida("123.00@"), false);
	}

	@Test
	void test_sumaCashValida_symbolFirst() {
		assertEquals(obj.sumaCashValida("#123.00"), false);
	}

	@Test
	void test_sumaCashValida_symbolMiddle() {
		assertEquals(obj.sumaCashValida("1!23.00"), false);
	}

	@Test
	void test_sumaCashValida_null() {
		assertEquals(obj.sumaCashValida(null), false);
	}

	@Test
	void test_sumaCashValida_empty() {
		assertEquals(obj.sumaCashValida(""), false);
	}

	@Test
	void test_sumaCashValida_noDOT() {
		assertEquals(obj.sumaCashValida("12345"), false);
	}

	// suma corecta
	@Test
	void test_sumaCashValida_valid() {
		assertEquals(obj.sumaCashValida("123.00"), true);
	}

	// teste pentru functia nrTelValid
	// nrTelValid incorect
	@Test
	void test_nrTelValid_LengthShort() {
		assertEquals(obj.nrTelValid("123"), false);
	}

	@Test
	void test_nrTelValid_LengthLong() {
		assertEquals(obj.nrTelValid("12345678901"), false);
	}

	@Test
	void test_nrTelValid_letter() {
		assertEquals(obj.nrTelValid("123456789a"), false);
	}

	@Test
	void test_nrTelValid_symbol() {
		assertEquals(obj.nrTelValid("1@23456789"), false);
	}

	@Test
	void test_nrTelValid_space() {
		assertEquals(obj.nrTelValid("12 3456789"), false);
	}

	@Test
	void test_nrTelValid_null() {
		assertEquals(obj.nrTelValid(null), false);
	}

	@Test
	void test_nrTelValid_empty() {
		assertEquals(obj.nrTelValid(""), false);
	}

	@Test
	void test_nrTelValid_letters() {
		assertEquals(obj.nrTelValid("abc"), false);
	}

	@Test
	void test_nrTelValid_symbols() {
		assertEquals(obj.nrTelValid("!@#"), false);
	}

	@Test
	void test_nrTelValid_spaces() {
		assertEquals(obj.nrTelValid("   "), false);
	}

	// nrTelValid corect
	@Test
	void test_nrTelValid_valid() {
		assertEquals(obj.nrTelValid("1234567890"), true);
	}
}
