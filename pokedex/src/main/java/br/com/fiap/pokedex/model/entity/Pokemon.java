package br.com.fiap.pokedex.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Pokemon {
	private Long numero;
	@NotBlank
	private String nome;
	@NotNull
	private Double altura;
	@NotNull
	private Double peso;
	@NotBlank
	private String categoria;
	@PastOrPresent
	private LocalDate dataDaCaptura;
	//construtores sem passagem de parâmetro
	public Pokemon() {		
	}
	
	//construtores com passagem de parâmetro
	public Pokemon(Long numero, @NotBlank String nome, @NotNull Double altura, @NotNull Double peso,
			@NotBlank String categoria, @PastOrPresent LocalDate dataDaCaptura) {
		this.numero = numero;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.dataDaCaptura = dataDaCaptura;
	}

	//gets e sets
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getDataDaCaptura() {
		return dataDaCaptura;
	}
	public void setDataDaCaptura(LocalDate dataDaCaptura) {
		this.dataDaCaptura = dataDaCaptura;
	}
	
}//end
