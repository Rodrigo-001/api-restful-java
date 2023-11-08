package br.com.fiap.megafarma.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.com.fiap.megafarma.model.entity.Remedio;

public class RemedioRepository extends Repository{
	
	/*
	 * Método para criar consulta buscando informações no banco de dados*/
	public static ArrayList<Remedio> findAll(){
		ArrayList<Remedio> remedios = new ArrayList<Remedio>();
		String sql = "select * from tb_remedios";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Remedio remedio = new Remedio();
					//setando valores do banco nos atributos da classe Remedio
					remedio.setId(rs.getLong("id"));
					remedio.setNome(rs.getString("nome"));
					remedio.setPreco(rs.getDouble("preco"));
					remedio.setDataDeFabricacao(rs.getDate("data_de_fabricacao").toLocalDate());
					remedio.setDataDeValidade(rs.getDate("data_de_validade").toLocalDate());
					remedios.add(remedio);
				}
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar: "+e.getMessage());
		}finally {
			closeConnnection();
		}		
		return remedios;
	}
}
