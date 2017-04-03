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
import service.UtenteService;

/**
 *
 * @author tss
 */
@WebServlet(urlPatterns = "/registrazione")
public class UtentiRegistrazioneServlet extends HttpServlet {

    @Inject
    UtenteService utenteService;

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
        String email = req.getParameter("email");
        System.out.println("...  " + user + " - " + pass + " - " + email);
        if (user == null || pass == null || email == null) {
            System.out.println("Utente nullo");
            resp.sendRedirect("registrazione.jsp");
        } else {
            Utente ute = new Utente(user, pass, email);
            utenteService.save(ute);
            System.out.println("doPostRegistrazione va bene...  " + user + " - " + pass + " - " + email);
            resp.sendRedirect("login.jsp");
        }
    }

}