/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1_servlet_jsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
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
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    List<Article> listeArticle = ArticleStub.getAll();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*try (PrintWriter out = response.getWriter()) {
            for (Article a : listeArticle) {
                System.out.println(a);
            }
        }*/
        request.setAttribute("listeArticle",  listeArticle);
        System.out.println(listeArticle); 
       RequestDispatcher view =  request.getServletContext().getRequestDispatcher("/article.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Article a = new Article(req.getParameter("id"), req.getParameter("title"), req.getParameter("descrition"));
        listeArticle.add(a);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
        String id = req.getParameter("id");
        for (Article a : listeArticle) {
            if (id.equals(a.getId())){
                listeArticle.remove(a);
            }
        }
        resp.setStatus(204);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        int i = 0;

        for (Article a : listeArticle) {
            if (id.equals(a.getId())) {
                listeArticle.get(i).setName(title);
            }
            i++;
        }
        resp.setStatus(201);
    }

}
