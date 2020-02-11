package br.com.desafio.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.desafio.model.Tarefa;
import br.com.desafio.repository.TarefaDao;
import br.com.desafio.repository.TarefaDaoImpl;

@Path("/tarefa")
public class TasksService {

	private TarefaDao tarefaDao = new TarefaDaoImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{taskId}")
	@POST
	public Tarefa getTask(@PathParam("taskId") long id) {

		Tarefa result = tarefaDao.buscarTarefa(id);

		if (result == null) {
			throw new WebApplicationException(404);
		}

		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	@POST
	public List<Tarefa> list() {

		List<Tarefa> tarefas = tarefaDao.listarTarefas();

		if (tarefas == null) {
			throw new WebApplicationException(404);
		}
		return tarefas;
	}

	@GET
	@Path("/find/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public List<Tarefa> findByName(@PathParam("name") String name) {

		List<Tarefa> result = new ArrayList<Tarefa>();

		return result;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Tarefa add(Tarefa tarefa) {
		
		Tarefa result = tarefaDao.buscarTarefa(tarefa.getId());
		
		
		if (result == null) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Tarefa não encontrada").build());
		}

		return result;
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public void update(@PathParam("id") int id, Tarefa task) {

	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") long id) {
		Tarefa tarefa = tarefaDao.buscarTarefa(id);
		tarefaDao.removerTarefa(tarefa);
	}
}