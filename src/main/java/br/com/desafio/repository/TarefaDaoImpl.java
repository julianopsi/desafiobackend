package br.com.desafio.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.desafio.model.Tarefa;

public class TarefaDaoImpl implements TarefaDao {

	public void gravar(Tarefa tarefa) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();

		System.out.println("ID da tarefa: " + tarefa.getId());

		manager.close();
	}

	public Tarefa buscarTarefa(Long id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		Tarefa encontrada = manager.find(Tarefa.class, id);

		System.out.println(encontrada.getDescricao());
		return encontrada;
	}

	public void removerTarefa(Tarefa tarefa) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		Tarefa encontrada = manager.find(Tarefa.class, tarefa.getId());

		manager.getTransaction().begin();
		manager.remove(encontrada);
		manager.getTransaction().commit();
	}

	public void atualizarTarefa(Tarefa tarefa) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
	}

	public List<Tarefa> listarTarefas() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select t from Tarefa as t " + "where t.finalizado = :paramFinalizado");

		List<Tarefa> lista = query.getResultList();
		return lista;
	}
}
