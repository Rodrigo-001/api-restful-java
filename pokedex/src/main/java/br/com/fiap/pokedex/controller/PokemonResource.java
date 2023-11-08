package br.com.fiap.pokedex.controller;

import java.util.ArrayList;

import br.com.fiap.pokedex.model.entity.Pokemon;
import br.com.fiap.pokedex.model.repository.PokemonRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

/*
 * Classe que responde requisições para o endpoint "/pokedex"
 * */
@Path("/pokedex")
public class PokemonResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		
		//obtém e guarda lista de objetos pokemons em resposta
		ArrayList<Pokemon> resposta = PokemonRepository.findAll();
		
		/*Uma instância de ResponseBuilder é criada usando o método estático ok() da classe Response. 
		Isso prepara a resposta HTTP com um status de sucesso (código 200 OK) e nenhum conteúdo definido ainda.*/
		ResponseBuilder response = Response.ok();
		
		//o corpo da resposta HTTP é configurado com os dados contidos na variável resposta
		response.entity(resposta);
		
		/*a resposta HTTP é construída a partir do objeto response configurado anteriormente, 
		 * e o método build() é chamado para gerar a resposta HTTP completa.*/
		return response.build();
	}

}
