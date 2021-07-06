package ufrn.eaj.eduardo.vangelico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ufrn.eaj.eduardo.vangelico.DAO.JoiaDAO;
import ufrn.eaj.eduardo.vangelico.model.Joia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @GetMapping
    public void listarJoias(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JoiaDAO jDAO = new JoiaDAO();
        response.getWriter().println("<table>");
        response.getWriter().println("<th>valor</th>");
        response.getWriter().println("<th>peso</th>");
        response.getWriter().println("<th>quilate</th>");
        response.getWriter().println("<th>tipo</th>");
        response.getWriter().println("<th>descricao</th>");
        int i=0;
        for (Joia j : jDAO.listarJoias() ) {
            response.getWriter().println("<tr>");
            response.getWriter().println("<th>" + j.getValor());
            response.getWriter().println("<th>" + j.getPeso());
            response.getWriter().println("<th>" + j.getQuilate());
            response.getWriter().println("<th>" + j.getTipo() );
            response.getWriter().println("<th>" + j.getDescricao());



            response.getWriter().println("<th> <a href=\"adicionarcarrinho?id=" + jDAO.listarJoias().get(i).getId() + " \" >Adicionar<a/></th>");


            i++;


        }

        response.getWriter().println("</table>");

        response.getWriter().println("<a href=\"/vercarrinho\">Ver Carrinho</a>");


    }
}