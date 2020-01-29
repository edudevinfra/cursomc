package com.eduardo.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.eduardo.cursomc.domain.enums.EstadoPagamento;

// Sub Class não precisa de inserir o {implements Serializable}, mas tem que inserir [serialVersionUID = 1L].
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;

	public PagamentoComBoleto() {

	}

	// Construtor da Sub Classe Pagamento adicionar o parametro dentro do construtor
		// [Integer dataVencimento], [Integer dataPagamento] e no corpo do metodo acresçenta a atribuição
		// this.dataVencimento = dataVencimento; 
	    //this.dataPagamento = dataPagamento;
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
