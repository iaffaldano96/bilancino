/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.Utente;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoggedFilter;
import service.UtenteService;

/**
 *
 * @author tss
 */
@WebServlet(urlPatterns = "/login")
public class UtentiLoginServlet extends HttpServlet {

    @Inject
    UtenteService utenteService;

    @Inject
    LoggedFilter utenteLogged;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("init()...");
    }

    // lo fa quando mandi un'altra richiesta
    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("destroy()...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("usr");
        String pass = req.getParameter("psw");

        if (user.equals("") || pass.equals("")) {
            System.out.println("Dati nulli");           
            resp.sendRedirect("login.jsp");
        } else {

            Utente find = utenteService.findByUserEPsw(user, pass);

            if (find == null) {
                System.out.println("Utente non trovato");               
                resp.sendRedirect("login.jsp");
            } else {

                utenteLogged.setUtenteLogged(find);
                System.out.println("utente va bene...  " + utenteLogged.getUtenteLogged());

                resp.sendRedirect("home.jsp");
                System.out.println("doPostLogin va bene...  " + user + " - " + pass);
            }
        }
    }
}
