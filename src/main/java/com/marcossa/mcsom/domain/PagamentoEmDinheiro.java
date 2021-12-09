package com.marcossa.mcsom.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.marcossa.mcsom.domain.enums.EstadoPagamento;

@Entity
public class PagamentoEmDinheiro extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataPagamento;
	
	public PagamentoEmDinheiro() {
		
	}

	public PagamentoEmDinheiro(Integer id, EstadoPagamento estado, Servico servico, Date dataPagamento) {
		super(id, estado, servico);
		this.setDataPagamento(dataPagamento);
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
