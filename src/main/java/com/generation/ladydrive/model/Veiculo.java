package com.generation.ladydrive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_veiculos")	
public class Veiculo {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank(message = "O tributo modelo é obrigatório")
	@Size(min = 3, max = 100, message = "O modelo tem que ser maior que 5 e menor que 100")
	private String modelo;
	
	@NotBlank(message = "O tributo placa é obrigatório")
	@Size(min = 5, max = 100, message = "A placa tem que ser maior que 5 e menor que 100")
	private String placa;
	
	@NotBlank(message = "O tributo cor é obrigatório")
	@Size(min = 5, max = 100, message = "A cor tem que ser maior que 5 e menor que 100")
	private String cor;
	
	@NotBlank(message = "O tributo motorista é obrigatório")
	@Size(min = 5, max = 100, message = "O motorista tem que ser maior que 5 e menor que 100")
	private String motorista;
	
	@ManyToOne
	@JsonIgnoreProperties("veiculo")
	private Viagem viagem;
	
	@ManyToOne
	@JsonIgnoreProperties("veiculo")
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

}
