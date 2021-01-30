/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet_jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.ArticleStub;

/**
 *
 * @author ancoutard
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    List<Article> listeArticle = ArticleStub.getAll();

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            List<Article> liste = ArticleStub.getAll();
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CartServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Mon Panier</h1>");
//            List<String> l = (List<String>) request.getSession().getAttribute("liste");
//            if (l != null) {
//                for (String article : l) {
//                    out.println(article);
//                    out.println("<br/>");
//                }
//            }
//            out.println("<form action=\"\" method=\"post\" >");
//            for (Article a : liste) {
//                out.println("<input type='checkbox' id=\"" + a.id + "\" name=\"selectedValue\" value=\"" + a.name + "\"/>");
//                out.println(a.id + ": " + a.name);
//                out.println("<br/>");
//            }
//            out.println("<input type=\"submit\" value=\"Ajouter\">");
//            out.println("</form>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listeArticle", listeArticle);
        System.out.println(listeArticle);
        RequestDispatcher view = request.getServletContext().getRequestDispatcher("/article.jsp");
        view.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Article> liste = new ArrayList<>();
        String[] values = request.getParameterValues("selectedValue");

        for (String v : values) {
            liste.add(new Article(v, v, v));
        }
        request.getSession().setAttribute("listePanier", liste);
        RequestDispatcher view = request.getServletContext().getRequestDispatcher("/article.jsp");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
