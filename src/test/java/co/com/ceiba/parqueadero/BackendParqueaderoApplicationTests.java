package co.com.ceiba.parqueadero;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendParqueaderoApplicationTests {

	@Test
	public void contextLoads() {
		int a = 2, b = 3;
		int sumaEsperada = 5;
		assertTrue(a+b==sumaEsperada);
		
	}

}
