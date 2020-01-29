package com.eduardo.cursomc.domain;

import javax.persistence.Entity;

import com.eduardo.cursomc.domain.enums.EstadoPagamento;

//Sub Class não precisa de inserir o {implements Serializable}, mas tem que inserir [serialVersionUID = 1L].
@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {

	}

	// Construtor da Sub Classe Pagamento adicionar o parametro dentro do construtor
	// [Integer numeroDeParcelas] e no corpo do metodo acresçenta a atribuição
	// this.numeroDeParcelas = numeroDeParcelas;
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;

	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
