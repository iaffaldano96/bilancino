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
@WebServlet(urlPatterns = "/registrazione")
public class UtentiRegistrazioneServlet extends HttpServlet {

    @Inject
    UtenteService utenteService;

    @Inject
    LoggedFilter filtro;
    
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

        if (user.equals("") || pass.equals("") || email.equals("")) {
            System.out.println("Dati vuoti");
            resp.sendRedirect("registrazione.jsp");
        } else {

            Utente find = utenteService.findUser(user);

            if (find != null) {
                System.out.println("Username già esistente...");                
                resp.sendRedirect("registrazione.jsp");
            }

            Utente ute = new Utente(user, pass, email);
            utenteService.save(ute);
            filtro.setUtenteLogged(ute);
            System.out.println("doPostRegistrazione va bene...  " + user + " - " + pass + " - " + email);
            resp.sendRedirect("home.jsp");
        }
    }

}
