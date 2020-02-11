package br.com.desafio.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="status")
public class Status {

	private Integer id;
	private String descricao;
	
	public Status() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
