package br.com.fiap.pokedex.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.fiap.pokedex.model.entity.Pokemon;

public class PokemonRepository extends Repository{
	/*
	 * Método para procurar todos os Pokemons existentes.
	 * Desc: Responderá uma requisição do tipo GET
	 * @return: ArrayList<Pokemon> Lista de Pokemons 
	 * */
	public static ArrayList<Pokemon> findAll(){	
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		String sql = "select * from pokemon";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Pokemon pokemon = new Pokemon();
					//setando valores do banco nos atributos da classe Remedio
					pokemon.setNumero(rs.getLong("numero"));
					pokemon.setNome(rs.getString("nome"));
					pokemon.setAltura(rs.getDouble("altura"));
					pokemon.setPeso(rs.getDouble("peso"));
					pokemon.setCategoria(rs.getString("categoria"));
					pokemon.setDataDaCaptura(rs.getDate("dataDaCaptura").toLocalDate());
					pokemons.add(pokemon);
				}
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar: "+e.getMessage());
		}finally {
			closeConnnection();
		}		
		return pokemons;

	}
}
