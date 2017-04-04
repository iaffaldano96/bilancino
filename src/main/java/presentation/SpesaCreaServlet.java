/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.Categoria;
import entity.Spesa;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoggedFilter;
import service.SpesaService;

/**
 *
 * @author tss
 */
@WebServlet(urlPatterns = "/crea")
public class SpesaCreaServlet extends HttpServlet {

    @Inject
    SpesaService spesaService;
    
    @Inject
    LoggedFilter utenteLogged;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("init().. crea..");
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("destroy().. crea..");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String imp = req.getParameter("importo");
        double importo = Double.parseDouble(imp);

        String descri = req.getParameter("descri");

        String cate = req.getParameter("cate");

        if (imp.equals("") || cate.equals("")) {
            System.out.println("Dati vuoti");
            resp.sendRedirect("creaSpesa.jsp");
        } else {
            if(descri.equals(""))
                descri="-";
            Categoria catte =new Categoria(cate);
            Spesa spe = new Spesa(importo, catte,utenteLogged.getUtenteLogged(),descri);
            spesaService.save(spe);
            System.out.println("doPostRegistrazione va bene...  " + importo + " - " + cate + " - "+ utenteLogged.getUtenteLogged()+ " - "+descri);
            resp.sendRedirect("creaSpesa.jsp");            
        }

    }

}
