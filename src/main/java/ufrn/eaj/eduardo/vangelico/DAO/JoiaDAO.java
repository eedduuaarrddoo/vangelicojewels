package ufrn.eaj.eduardo.vangelico.DAO;

import ufrn.eaj.eduardo.vangelico.controller.ConectaBanco;
import ufrn.eaj.eduardo.vangelico.model.Joia;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoiaDAO {

    public List<Joia> listarJoias() {


        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Joia> listaDeJoias = new ArrayList<>();


        try {
            connection = ConectaBanco.getConnection();

            stmt = connection.prepareStatement("select * from tjoias");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Joia j = new Joia();

                j.setId(rs.getInt("id"));
                j.setDescricao(rs.getString("descricao"));
                j.setTipo(rs.getString("tipo"));
                j.setPeso(rs.getFloat("peso"));
                j.setValor(rs.getFloat("valor"));
                j.setQuilate(rs.getFloat("quilate"));

                listaDeJoias.add(j);
            }

        } catch (SQLException | URISyntaxException ex) {
            System.out.println(ex);
        }


        return listaDeJoias;


    }

    public void adicionarJoia(Joia j) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConectaBanco.getConnection();

            stmt = connection.prepareStatement("insert into Tjoias (valor, peso, quilate, tipo, descricao) values (?,?,?,?,?)");

            stmt.setFloat(1, j.getValor());
            stmt.setFloat(2, j.getPeso());
            stmt.setFloat(3, j.getQuilate());
            stmt.setString(4, j.getTipo());
            stmt.setString(5, j.getDescricao());
            stmt.executeUpdate();


        } catch (SQLException | URISyntaxException ex) {
            //response.getWriter().append("Connection Failed! Check output console");
        }


    }

    public  List<Joia> listarJoiasPorId(int id) {

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Joia> listadeJoias = new ArrayList<>();

        try {
            connection = ConectaBanco.getConnection();

            stmt = connection.prepareStatement("select * from Tjoias where id=?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Joia j = new Joia();

                j.setId(rs.getInt("id"));
                j.setValor(rs.getFloat("valor"));
                j.setPeso(rs.getFloat("peso"));
                j.setQuilate(rs.getInt("quilate"));
                j.setTipo(rs.getString("tipo"));
                j.setDescricao(rs.getString("descricao"));

                listadeJoias.add(j);

            }

        } catch (SQLException | URISyntaxException ex) {
            //response.getWriter().append("Connection Failed! Check output console");
        }

        return listadeJoias;
    }


}
