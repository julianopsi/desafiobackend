package br.com.desafio.repository;

import java.util.List;

import br.com.desafio.model.Tarefa;

public interface TarefaDao{
	
	public void gravar(Tarefa tarefa);
	
	public Tarefa buscarTarefa(Long id);
	
	public void removerTarefa(Tarefa tarefa);
	
	public void atualizarTarefa(Tarefa tarefa);
	
	public List<Tarefa> listarTarefas();
} 