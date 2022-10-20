package banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CuentaTest {
	
	Cuenta cuenta;
	
	@BeforeEach
	public void setup() {
		cuenta = new Cuenta("Sebastian", 980000);
	}
	
	@Test
	@DisplayName("debe existir un nombre de cuenta")
	public void testNombreCuenta() {
		
		assertTrue(cuenta.getNombre() != null);
	}
	
	@Test
	@DisplayName("el nombre no debe cambiar cuando se crea la cuenta")
	public void testNombreUnicoCuenta() {
		String esperado = "Sebastian";
		String actual = cuenta.getNombre();
		assertEquals(esperado, actual);
	}
	
	@Test
	@DisplayName("el saldo de la cuenta debe existir, no debe ser nulo")
	public void testearSaldoExistente() {
		assertTrue(cuenta.getSaldo() != null);
	}
	
	@Test
	public void retirarSaldoInsuficiente() {
		Exception exception = assertThrows(Exception.class, ()->{
			cuenta.retirar(990000);
		});
		String actual = exception.getMessage();
		String esperado = "Saldo insuficiente";
		assertEquals(esperado, actual);
	}
	
	@Test
	public void retirarSaldoIgualAlSaldoActual() throws Exception {
		cuenta.retirar(980000);
		Integer actual = cuenta.getSaldo();
		Integer esperado = 0;
		assertEquals(esperado, actual);
	}
	
	@Test
	public void retirarSaldoInferiorAlSaldoActual() throws Exception {
		cuenta.retirar(100000);
		Integer esperado = 980000-100000;
		Integer actual = cuenta.getSaldo();
		assertEquals(esperado, actual);
	}
}
