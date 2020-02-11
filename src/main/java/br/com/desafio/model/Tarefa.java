package br.com.desafio.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task")
@Entity
@Table(name = "TASK")
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_finalizado", nullable = true)
    private Calendar dataFinalizacao;

	public Tarefa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}