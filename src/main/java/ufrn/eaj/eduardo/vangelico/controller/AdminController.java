package ufrn.eaj.eduardo.vangelico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.eaj.eduardo.vangelico.DAO.JoiaDAO;
import ufrn.eaj.eduardo.vangelico.model.Joia;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping


public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public void formCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println("<body>");
        response.getWriter().println("<form method =\"post\" action=\"/adicionar\">\n" +
                "     valor: <input type=\"number\" name=\"valor\">\n" +
                "     peso: <input type=\"number\" name=\"peso\">\n" +
                "     quilate: <input type=\"number\" name=\"quilate\">\n" +
                "    Tipo: <input type=\"text\" name=\"tipo\">\n" +
                "     descricao: <input type=\"text\" name=\"descricao\">\n" +
                "    <button type=\"submit\">Adcionar Item</button>\n" +
                "</form>");
        response.getWriter().println("</body>");
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public void adicionarJoia(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println(request.getParameter("valor"));
        response.getWriter().println(request.getParameter("peso"));
        response.getWriter().println(request.getParameter("quilate"));
        response.getWriter().println(request.getParameter("tipo"));
        response.getWriter().println(request.getParameter("descricao"));

        float valor = Float.parseFloat(request.getParameter("valor"));

        float peso = Float.parseFloat(request.getParameter("peso"));
        float Quilate = Float.parseFloat(request.getParameter("quilate"));
        String Tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");

        Joia j = new Joia();
        JoiaDAO jDAO = new JoiaDAO();
        j.setValor(valor);
        j.setPeso(peso);
        j.setQuilate(Quilate);
        j.setTipo(Tipo);
        j.setDescricao(descricao);
        jDAO.adicionarJoia(j);
        response.sendRedirect("/admin");


    }


}
