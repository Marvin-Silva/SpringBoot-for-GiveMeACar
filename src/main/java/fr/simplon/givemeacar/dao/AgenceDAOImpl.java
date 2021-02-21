package fr.simplon.givemeacar.dao;

import fr.simplon.givemeacar.model.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

@Repository
public class AgenceDAOImpl implements AgenceDao{

    private DataSource datasource;

    @Autowired
    public AgenceDAOImpl(JdbcTemplate jdbcTemplate){
        this.datasource = jdbcTemplate.getDataSource();
    }

    @Override
    public List<Agence> getAllAgences() throws Exception {
        Agence agence;
        Connection connexion = datasource.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultset;
        String sql;
        ArrayList<Agence> listOfAgences = new ArrayList<Agence>();

        try {
            sql = "SELECT * FROM Agence";
            pstmt = connexion.prepareStatement(sql);

            resultset = pstmt.executeQuery();

            while (resultset.next()){
                agence = getAgenceFromResutSet(resultset);
                listOfAgences.add(agence);
            }
            } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            pstmt.close();
            connexion.close();
        }

        return listOfAgences;
    }

    private Agence getAgenceFromResutSet(ResultSet resultset) throws SQLException {
        Agence agence = new Agence();
        agence.setIdAgence(resultset.getLong("idAgence"));
        agence.setVille(resultset.getString("ville"));

        return agence;
    }
}
