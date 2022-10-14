package br.com.bancodigital.modelo;

import java.math.BigDecimal;

public class Conta {

	private Long id;
	private Long agencia;
	
	private String numero;
	private String cliente;
	
	private BigDecimal saldo;
	
	public Conta(Long agencia, String numero, String cliente, BigDecimal saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", agencia=" + agencia + ", numero=" + numero + ", cliente=" + cliente + ", saldo="
				+ saldo + "]";
	}

	public void deposita(BigDecimal valor) {
		this.saldo = this.saldo.add(valor);
	}
	
	public void saca(BigDecimal valor) {
		this.saldo = this.saldo.subtract(valor);
	}
	
}
