package ufrn.eaj.eduardo.vangelico.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/config")
public class ConfigController {
    @GetMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConectaBanco.getConnection();
            pstm = con.prepareStatement("create table tJoias(id SERIAL PRIMARY KEY ,valor float,peso float,quilate int,tipo varchar (71),descricao varchar (71))");
            pstm.execute();
            pstm = con.prepareStatement("INSERT INTO tJoias(valor,peso,quilate,tipo,descricao)");
            pstm.execute();
            response.getWriter().println("OK");

        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("FAIL");
        }


    }
}