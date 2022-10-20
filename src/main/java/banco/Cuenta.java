package banco;

public class Cuenta {

	private String nombre;
	private Integer saldo;
	
	public Cuenta() {
	}

	public Cuenta(String nombre, Integer saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	public void retirar(Integer dineroRetirar) throws Exception {
		if(this.saldo.compareTo(dineroRetirar) < 0) {
			throw new Exception("Saldo insuficiente");
		}
		else {
			this.saldo -= dineroRetirar;
		}
	}
}
