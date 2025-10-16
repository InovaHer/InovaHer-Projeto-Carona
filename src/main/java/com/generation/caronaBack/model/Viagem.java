package com.generation.caronaBack.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name="tb_viagens")
public class Viagem {
	
	@Id //Primary key (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private Long id;//Id Viagem

	@Column(length = 255)
    @NotBlank(message = "O atributo motorista é obrigatório!")
    @Size(min = 8, message = "O atributo motorista deve conter no mínimo 8 caracteres")
	private String motorista; 
	
	@Column(length = 255)
    @NotBlank(message = "O atributo origem é obrigatório!")
    @Size(min = 2, message = "O atributo origem deve conter no mínimo 2 caracteres")
    private String origem;
	
	@Column(length = 255)
    @NotBlank(message = "O atributo destino é obrigatório!")
    @Size(min = 2, message = "O atributo destino deve conter no mínimo 2 caracteres")
    private String destino;
	
	@NotBlank(message = "O atributo data é obrigatório!")
	@FutureOrPresent(message = "A data não pode estar no passado")
    private LocalDateTime data;
	
	@NotBlank(message = "O atributo número de vagas é obrigatório!")
	private int vagas_disponiveis;
	
	@NotBlank(message = "O atributo valor é obrigatório!")
	private Double valor_sugerido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getVagas_disponiveis() {
		return vagas_disponiveis;
	}

	public void setVagas_disponiveis(int vagas_disponiveis) {
		this.vagas_disponiveis = vagas_disponiveis;
	}

	public Double getValor_sugerido() {
		return valor_sugerido;
	}

	public void setValor_sugerido(Double valor_sugerido) {
		this.valor_sugerido = valor_sugerido;
	}
	
}
