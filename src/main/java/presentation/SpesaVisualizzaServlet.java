/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entity.Categoria;
import entity.Spesa;
import entity.Utente;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategoriaService;
import service.LoggedFilter;
import service.SpesaService;

/**
 *ta (categ)..Salute
 * @author tssta (categ)..Salute
 */
@WebServlet(urlPatterns = "/visualizza")
public class SpesaVisualizzaServlet extends HttpServlet {

    @Inject
    SpesaService spesaService;
    
    @Inject
    CategoriaService categoriaService;

    @Inject
    LoggedFilter filtro;
      
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String cate=req.getParameter("categ");
        
        Categoria ca=categoriaService.findById(cate);
        
        filtro.setCategoriaScelta(ca);
        System.out.println("categoriaScelta..."+filtro.getCategoriaScelta().getCategoria());
        
        System.out.println("Utente Loggato..."+filtro.getUtenteLogged());
        
        List<Spesa> spese=spesaService.findByCategoria();                
        System.out.println("doPost() Visualizza lista spese..."+spese);
        
        resp.sendRedirect("visualizzaCategorie.jsp");                      
        
    }
        

}
