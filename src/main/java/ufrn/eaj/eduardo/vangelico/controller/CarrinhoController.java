package ufrn.eaj.eduardo.vangelico.controller;

import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.eaj.eduardo.vangelico.DAO.JoiaDAO;
import ufrn.eaj.eduardo.vangelico.model.Joia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarrinhoController {
    List<Joia> carrinho = new ArrayList<>();
    @RequestMapping(value = "/adicionarcarrinho", method = RequestMethod.GET)
    public void getAdicionarCarrinho(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        HttpSession s = request.getSession();
        JoiaDAO jDAO = new JoiaDAO();
        if (request.getParameter("id") != null) {

            int id = Integer.parseInt(request.getParameter("id"));


            for (Joia j : jDAO.listarJoiasPorId(id)) {
                carrinho.add(j);
            }
            for (Joia j : carrinho) {
                response.getWriter().println(j.getId() + " - " + j.getId());
            }
        }
        s.setAttribute("carrinho", carrinho);
        RequestDispatcher encaminhar = request.getRequestDispatcher("/cliente");
        encaminhar.forward(request, response);
    }

    @RequestMapping(value = "/vercarrinho", method = RequestMethod.GET)
    public void getVerCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s = request.getSession();
        List<Joia> carrinhoSession = (List<Joia>) s.getAttribute("carrinho");
        if (carrinhoSession != null) {

            // JSONObject myObject = new JSONObject(result);
            for (Joia j : carrinhoSession) {
                response.getWriter().println(j.getId() + " - " + j.getDescricao()+" - $"+j.getValor());
            }
        }
    }
}
