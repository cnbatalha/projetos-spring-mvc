package gruoup.java;

public class Item {

	private String nome;
	private String tipo;
	private Double valor;

	public Item() {
		super();
	}

	public Item(String nome, String tipo, Double valor) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
