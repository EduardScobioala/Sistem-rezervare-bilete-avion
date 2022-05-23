package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import functionalities.CursaZbor;
import functionalities.RezervareZbor;

class TEST_RezervareZbor {

	RezervareZbor obj = new RezervareZbor("AAA","BBB",new Date(),1,"Adult","Econom",false,new Date());
	//test meetRequirements
	//incorrect
	@Test
	void test_null() {

		assertEquals(obj.meetRequirements(null),false);

	}
	
	@Test
	void test_nullAirline() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor(null, "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullAirport1() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", null,"BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);


	}
	
	@Test
	void test_nullAirport2() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA",null,"11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullTime1() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB",null,"12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullTime2() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00",null,zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullZileOperare() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",null,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullPretClase() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,null,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullLocuriDisponibile() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,null,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullLocuriRezervate() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,null, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_nullCodCursa() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate,null,"AT X134",true,true)),false);

	}
	
	@Test
	void test_nullTipAvion() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		

		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty",null,true,true)),false);

	}
	
	@Test
	void test_wrongOra1() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
 		obj.setClasa("clasa_gresita");
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","25:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_wrongOra2() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
 		obj.setClasa("clasa_gresita");
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","25:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_wrongClass() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
		
 		obj.setClasa("clasa_gresita");
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_wrongLocuri1() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {0,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		

		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);
			

	}
	
	@Test
	void test_wrongLocuri2() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,0,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		obj.setClasa("Business");
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	
	@Test
	void test_wrongLocuri3() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		obj.setClasa("Premium");
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

		
	}
	
	@Test
	void test_wrongClasa() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		obj.setClasa("clasa_gresita");
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

		
	}
	
	@Test
	void test_wrongDataPlecare() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,3};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		obj.setDataPlecare(new Date());
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),true);
		
	}
	
	@Test
	void test_wrongAeroport1() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "aeroport_gresit","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

	}
	@Test
	void test_wrongAeroport2() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
		assertEquals(obj.meetRequirements(new CursaZbor("AAA Airlines", "AAA","aeroport_gresit","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true)),false);

		
	}
	
	//test  gotCursaLaData()
	//incorrect
	
	@Test
	void test_dataBefore() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		Date data_test = new Date(1000);
 		
		assertEquals(obj.gotCursaLaData(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true),data_test),false);

		
	}
	
	//correct
	@Test
	void test_dataNow() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		Date data_test = new Date();
 		
		assertEquals(obj.gotCursaLaData(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true),data_test),true);
		
	}
	
	
	//needs to be tested for the Date(int) constructor
	@Test
	void test_dataAfter() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		Date data_test = new Date(java.lang.System.currentTimeMillis()+10);
 		
		assertEquals(obj.gotCursaLaData(new CursaZbor("AAA Airlines", "AAA","BBB","11:00","12:00",zileOperare,pretClase,locuriDisponibile,locuriRezervate, "qwerty","AT X134",true,true),data_test),true);

	}
	
	//test readFile()
	//incorect
	@Test
	void test_throwIOException_null() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		try {
		assert (obj.readFile(null)) == null;
		fail();
		}catch(IOException e)
 		{
			System.out.println("Path = null; IOException thrown");
 		}
	}
	
	@Test
	void test_throwIOException_empty() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
 		try {
		assert (obj.readFile("")) == null;
		fail();
		}catch(IOException e)
 		{
			System.out.println("Path = '' (empty string); IOException thrown");
 		}
	}
	
	//test getData()
	//incorrect
	@Test
	void test_getData_null() {
		int[] zileOperare = {1,1,1,1,1,0,0};
		int[] locuriDisponibile = {10,15,0};
		int[] locuriRezervate = {0,0,0};
 		float[] pretClase = {100.0f,250.0f, 500.0f};
 		
		assertEquals(obj.getData(null),null);
	}

}
