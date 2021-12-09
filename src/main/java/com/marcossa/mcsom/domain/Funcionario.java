package com.marcossa.mcsom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	private String cpfOuCnpj;
	
	@ElementCollection
	@CollectionTable(name="TEL_FUNCIONARIOS")
	private Set<String> telefones = new HashSet<>();
	
	@OneToMany(mappedBy = "funcionarios")
	private List<Vales> vales = new ArrayList<>();
	
	@OneToMany(mappedBy = "funcionario")
	private List<Comissoes> comissoes = new ArrayList<>();
	
	public Funcionario() {
		
	}
	
	public Funcionario(Integer id, String nome, String email, String cpfOuCnpj) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Vales> getVales() {
		return vales;
	}

	public void setVales(List<Vales> vales) {
		this.vales = vales;
	}

	public List<Comissoes> getComissoes() {
		return comissoes;
	}

	public void setComissoes(List<Comissoes> comissoes) {
		this.comissoes = comissoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

}
