package com.generation.ladydrive.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_viagens") //tema
public class Viagem {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank(message = "O tributo origem é obrigatório")
	@Size(min = 5, max = 1000, message = "O origem tem que ser maior que 5 e menor que 100")
	private String origem;
	
	@NotBlank(message = "O tributo destino é obrigatório")
	@Size(min = 5, max = 1000, message = "O destino tem que ser maior que 5 e menor que 100")
	private String destino;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy ="viagem"
			, cascade = CascadeType.REMOVE )
	
	@JsonIgnoreProperties("viagem")
	private  List<Veiculo> veiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
		
	
}
