package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.VizualizareZborFrame;

class TEST_VizualizareZborFrameTest extends VizualizareZborFrame {

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
		assertEquals(this.numeValid(null), false);
	}

	@Test
	void test_numeValid_emptyString() {
		assertEquals(this.numeValid(""), false);
	}

	@Test
	void test_numeValid_firstSmallLetter() {
		assertEquals(this.numeValid("dEian"), false);
	}

	@Test
	void test_numeValid_firstLetter1() {
		assertEquals(this.numeValid("1Eian"), false);
	}

	@Test
	void test_numeValid_firstMiddle1() {
		assertEquals(this.numeValid("De{an"), false);
	}

	@Test
	void test_numeValid_allCAPS() {
		assertEquals(this.numeValid("PAUL"), false);
	}

	@Test
	void test_numeValid_allSmallLetters() {
		assertEquals(this.numeValid("trif"), false);
	}

	@Test
	void test_numeValid_spaces() {
		assertEquals(this.numeValid("Paul Deian"), false);
	}

	@Test
	void test_numeValid_spacesAndSmallLetters1() {
		assertEquals(this.numeValid("paul Deian"), false);
	}

	@Test
	void test_numeValid_spacesAndSmallLetters2() {
		assertEquals(this.numeValid("Paul deian"), false);
	}

	@Test
	void test_numeValid_spacesAndAllCAPS() {
		assertEquals(this.numeValid("TRIF DEIAN"), false);
	}

	@Test
	void test_numeValid_spacesAndAllSmallLetters() {
		assertEquals(this.numeValid("trif paul"), false);
	}

	@Test
	void test_numeValid_spacesNumbersAndSymbols1() {
		assertEquals(this.numeValid("Tri1f P#aul De	ian"), false);
	}

	@Test
	void test_numeValid_spacesNumbersAndSymbols2() {
		assertEquals(this.numeValid("tr3if #paul de4ian"), false);
	}

	@Test
	void test_numeValid_Numbers() {
		assertEquals(this.numeValid("Tri1f"), false);
	}

	@Test
	void test_numeValid_Symbols() {
		assertEquals(this.numeValid("Tr#if"), false);
	}

	@Test
	void test_numeValid_smallLettersNumbersAndSymbols() {
		assertEquals(this.numeValid("de1ian@"), false);
	}

	// nume corecte
	@Test
	void test_numeValid_valid1() {
		assertEquals(this.numeValid("Trif"), true);
	}

	@Test
	void test_numeValid_valid2() {
		assertEquals(this.numeValid("Paul"), true);
	}

	// teste pentru functia emailValid
	// e-mail incorect
	@Test
	void test_emailValid_noAT() {
		assertEquals(this.emailValid("emailserver.com"), false);
	}

	@Test
	void test_emailValid_space1() {
		assertEquals(this.emailValid("ema il@server.com"), false);
	}

	@Test
	void test_emailValid_space2() {
		assertEquals(this.emailValid("email@server .com"), false);
	}

	@Test
	void test_emailValid_noDOT() {
		assertEquals(this.emailValid("email@servercom"), false);
	}

	@Test
	void test_emailValid_null() {
		assertEquals(this.emailValid(null), false);
	}

	@Test
	void test_emailValid_empty() {
		assertEquals(this.emailValid(""), false);
	}

	// e-mail corect
	@Test
	void test_emailValid_valid() {
		assertEquals(this.emailValid("email@server.com"), true);
	}

	// teste pentru functia CVCValid
	// CVC incorect
	@Test
	void test_CVCValid_allLetters() {
		assertEquals(this.CVCValid("abc"), false);
	}

	@Test
	void test_CVCValid_allLettersCAPS() {
		assertEquals(this.CVCValid("ABC"), false);
	}

	@Test
	void test_CVCValid_lettersFirst() {
		assertEquals(this.CVCValid("a23"), false);
	}

	@Test
	void test_CVCValid_lettersLast() {
		assertEquals(this.CVCValid("12a"), false);
	}

	@Test
	void test_CVCValid_lettersCAPSLast() {
		assertEquals(this.CVCValid("12c"), false);
	}

	@Test
	void test_CVCValid_lettersCAPSFirst() {
		assertEquals(this.CVCValid("a23"), false);
	}

	@Test
	void test_CVCValid_symbolsLast() {
		assertEquals(this.CVCValid("12#"), false);
	}

	@Test
	void test_CVCValid_symbolsFirst() {
		assertEquals(this.CVCValid("@23"), false);
	}

	@Test
	void test_CVCValid_spacesFirst() {
		assertEquals(this.CVCValid(" 123"), false);
	}

	@Test
	void test_CVCValid_spacesLast() {
		assertEquals(this.CVCValid("123 "), false);
	}

	@Test
	void test_CVCValid_spacesMiddle() {
		assertEquals(this.CVCValid("1 23"), false);
	}

	@Test
	void test_CVCValid_wrongLengthShort() {
		assertEquals(this.CVCValid("12"), false);
	}

	@Test
	void test_CVCValid_wrongLengthLong() {
		assertEquals(this.CVCValid("1234"), false);
	}

	@Test
	void test_CVCValid_null() {
		assertEquals(this.CVCValid(null), false);
	}

	@Test
	void test_CVCValid_empty() {
		assertEquals(this.CVCValid(""), false);
	}

	// CVC corect
	@Test
	void test_CVCValid_valid() {
		assertEquals(this.CVCValid("123"), true);
	}

	// teste pentru functia nrCardContValid
	// NrCardCont incorect
	@Test
	void test_nrCardContValid_nrCard_wrongLengthShort() {
		assertEquals(this.nrCardContValid("123", true), false);
	}

	@Test
	void test_nrCardContValid_nrCard_wrongLengthLong() {
		assertEquals(this.nrCardContValid("12345678901234567", true), false);
	}

	@Test
	void test_nrCardContValid_nrCont_wrongLengthShort() {
		assertEquals(this.nrCardContValid("1234", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_wrongLengthLong() {
		assertEquals(this.nrCardContValid("RO34567890123456789012345", false), false);
	}

	@Test
	void test_nrCardContValid_nrCard_middle_gt_Z() {
		assertEquals(this.nrCardContValid("123456789012345a", true), false);
	}

	@Test
	void test_nrCardContValid_nrCard_symbol() {
		assertEquals(this.nrCardContValid("123456#789012345", true), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letters() {
		assertEquals(this.nrCardContValid("RO34b567890123457890123", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_symbol() {
		assertEquals(this.nrCardContValid("RO3456#789012345", false), false);
	}

	@Test
	void test_nrCardContValid_nrCard_space() {
		assertEquals(this.nrCardContValid("1234 56789012345", true), false);
	}

	@Test
	void test_nrCardContValid_nrCont_space() {
		assertEquals(this.nrCardContValid("RO3456 78901234567890123", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_null() {
		assertEquals(this.nrCardContValid(null, false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_empty() {
		assertEquals(this.nrCardContValid("", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter1_lt_A() {
		assertEquals(this.nrCardContValid("1O1234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter1_gt_Z() {
		assertEquals(this.nrCardContValid("rO1234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter2_lt_A() {
		assertEquals(this.nrCardContValid("R11234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_letter2_gt_Z() {
		assertEquals(this.nrCardContValid("Ro1234567890123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_middle_gt_Z() {
		assertEquals(this.nrCardContValid("RO123456789a123456789012", false), false);
	}

	@Test
	void test_nrCardContValid_nrCont_middle_gt_9_lt_A() {
		assertEquals(this.nrCardContValid("RO1234:67890123456789012", false), false);
	}

	// NrCardCont corect
	@Test
	void test_nrCardContValid_nrCard_valid() {
		assertEquals(this.nrCardContValid("1234567890123456", true), true);
	}

	@Test
	void test_nrCardContValid_nrCont_valid() {
		assertEquals(this.nrCardContValid("RO3456789012345678901234", false), true);
	}

	// teste pentru functia dataExpirareValida
	// data incorecta
	@Test
	void test_dataExpirareValida_ziInvalida_minus1() {
		int[] data = { -1, 1, 2022 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_ziInvalida32() {
		int[] data = { 32, 1, 2022 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_ziInvalida_0() {
		int[] data = { 0, 1, 2022 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_lunaInvalida_minus1() {
		int[] data = { 1, -1, 2022 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_lunaInvalida_13() {
		int[] data = { 1, 13, 2022 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_lunaInvalida_0() {
		int[] data = { 1, 0, 2022 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_anInvalid_minus1() {
		int[] data = { 1, 1, -1 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_anInvalid_0() {
		int[] data = { 1, 1, 0 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_null() {

		assertEquals(this.dataExpirareValida(null), false);
	}

	@Test
	void test_dataExpirareValida_ziInvalida2() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH), aux.get(Calendar.YEAR) - 1 };
		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_zi() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, aux.get(Calendar.MONTH) + 1, aux.get(Calendar.YEAR) };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_luna() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, aux.get(Calendar.MONTH), aux.get(Calendar.YEAR) };

		assertEquals(this.dataExpirareValida(data), false);
	}

	@Test
	void test_dataExpirareValida_an() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, aux.get(Calendar.MONTH) + 1, aux.get(Calendar.YEAR) - 1 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	// data corecta
	@Test
	void test_dataExpirareValida_valid2() {
		Calendar aux = Calendar.getInstance();
		int[] data = { 1, 8, aux.get(Calendar.YEAR) + 1 };

		assertEquals(this.dataExpirareValida(data), true);
	}

	@Test
	void test_dataExpirareValida_valid3() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH) + 1, aux.get(Calendar.YEAR) };

		assertEquals(this.dataExpirareValida(data), true);
	}

	@Test
	void test_dataExpirareValida_valid4() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH) + 2, aux.get(Calendar.YEAR) };

		assertEquals(this.dataExpirareValida(data), true);
	}

	@Test
	void test_dataExpirareValida_valid5() {
		Calendar aux = Calendar.getInstance();
		int[] data = { aux.get(Calendar.DAY_OF_MONTH), aux.get(Calendar.MONTH) + 2, 2019 };

		assertEquals(this.dataExpirareValida(data), false);
	}

	// teste pentru functia sumaCashValida
	// suma incorecta
	@Test
	void test_sumaCashValida_minus1() {
		assertEquals(this.sumaCashValida("-1.00"), false);
	}

	@Test
	void test_sumaCashValida_lettersLast() {
		assertEquals(this.sumaCashValida("123.00a"), false);
	}

	@Test
	void test_sumaCashValida_lettersFirst() {
		assertEquals(this.sumaCashValida("a123.00"), false);
	}

	@Test
	void test_sumaCashValida_lettersMiddle() {
		assertEquals(this.sumaCashValida("1a23.00"), false);
	}

	@Test
	void test_sumaCashValida_sSpaceLast() {
		assertEquals(this.sumaCashValida("123.00 "), false);
	}

	@Test
	void test_sumaCashValida_spaceFirst() {
		assertEquals(this.sumaCashValida(" 123.00"), false);
	}

	@Test
	void test_sumaCashValida_spaceMiddle() {
		assertEquals(this.sumaCashValida("1 23.00"), false);
	}

	@Test
	void test_sumaCashValida_symbolLast() {
		assertEquals(this.sumaCashValida("123.00@"), false);
	}

	@Test
	void test_sumaCashValida_symbolFirst() {
		assertEquals(this.sumaCashValida("#123.00"), false);
	}

	@Test
	void test_sumaCashValida_symbolMiddle() {
		assertEquals(this.sumaCashValida("1!23.00"), false);
	}

	@Test
	void test_sumaCashValida_null() {
		assertEquals(this.sumaCashValida(null), false);
	}

	@Test
	void test_sumaCashValida_empty() {
		assertEquals(this.sumaCashValida(""), false);
	}

	@Test
	void test_sumaCashValida_noDOT() {
		assertEquals(this.sumaCashValida("12345"), false);
	}

	// suma corecta
	@Test
	void test_sumaCashValida_valid() {
		assertEquals(this.sumaCashValida("123.00"), true);
	}

	// teste pentru functia nrTelValid
	// nrTelValid incorect
	@Test
	void test_nrTelValid_LengthShort() {
		assertEquals(this.nrTelValid("123"), false);
	}

	@Test
	void test_nrTelValid_LengthLong() {
		assertEquals(this.nrTelValid("12345678901"), false);
	}

	@Test
	void test_nrTelValid_letter() {
		assertEquals(this.nrTelValid("123456789a"), false);
	}

	@Test
	void test_nrTelValid_symbol() {
		assertEquals(this.nrTelValid("1@23456789"), false);
	}

	@Test
	void test_nrTelValid_space() {
		assertEquals(this.nrTelValid("12 3456789"), false);
	}

	@Test
	void test_nrTelValid_null() {
		assertEquals(this.nrTelValid(null), false);
	}

	@Test
	void test_nrTelValid_empty() {
		assertEquals(this.nrTelValid(""), false);
	}

	@Test
	void test_nrTelValid_letters() {
		assertEquals(this.nrTelValid("abc"), false);
	}

	@Test
	void test_nrTelValid_symbols() {
		assertEquals(this.nrTelValid("!@#"), false);
	}

	@Test
	void test_nrTelValid_spaces() {
		assertEquals(this.nrTelValid("   "), false);
	}

	// nrTelValid corect
	@Test
	void test_nrTelValid_valid() {
		assertEquals(this.nrTelValid("1234567890"), true);
	}
}
