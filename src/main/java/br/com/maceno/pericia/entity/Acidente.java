package br.com.maceno.pericia.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.maceno.pericia.constants.MensagemConstants;

@Entity
public class Acidente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer markerId;
	
	@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO)
	private Double latitude;
	
	@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO)
	private Double longitude;
	
	@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO)
	private LocalDate data;
	
	@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO)
	private LocalTime hora;
	
	public Acidente() {
		super();
	}

	public Acidente(Integer markerId, @NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO) Double latitude,
			@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO) Double longitude,
			@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO) LocalDate data,
			@NotNull(message=MensagemConstants.CAMPO_OBRIGATORIO) LocalTime hora) {
		super();
		this.markerId = markerId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.data = data;
		this.hora = hora;
	}

	public Integer getMarkerId() {
		return markerId;
	}

	public void setMarkerId(Integer markerId) {
		this.markerId = markerId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

}
