package com.derso.controlesessao.persistencia;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Sessao {
	
	public static final int DURACAO_MINUTOS = 10;
	
	@Id
	@Column(length = 36)
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	
	@Column(columnDefinition = "TIMESTAMP")
	private Instant expiracao;
	
	@Enumerated(EnumType.STRING)
	private EstadoSessao estado;
	
	public Sessao() {
		uuid = UUID.randomUUID().toString();
		expiracao = Instant.now().plusSeconds(DURACAO_MINUTOS * 60);
		estado = EstadoSessao.CORRENDO;
	}

}
