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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;

/**
 *
 * @author ancoutard
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    List<Article> listeArticle = loadList();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            for (Article a : listeArticle) {
                out.println(a);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

//        StringBuffer jb = new StringBuffer();
//        String line = null;
//        try {
//            BufferedReader reader = req.getReader();
//            while ((line = reader.readLine()) != null) {
//                jb.append(line);
//            }
//        } catch (Exception e) {
//            /*report an error*/
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            JSONObject jsonObject = HTTP.toJSONObject(jb.toString());
//        } catch (JSONException e) {
//            // crash and burn
//            throw new IOException("Error parsing JSON request string");
//        }
        Article a = new Article(req.getParameter("id"), req.getParameter("title"));
        listeArticle.add(a);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
        String id = req.getAttribute("id").toString();
        for (Article a : listeArticle) {
            if (a.id == id) {
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
            if (a.id == id) {
                listeArticle.get(i).name = title;
            }
            i++;
        }
        resp.setStatus(201);
    }

    public List<Article> loadList() {
        List<Article> liste = new ArrayList<>();
        liste.add(new Article("1", "un"));
        liste.add(new Article("2", "deux"));
        return liste;
    }
}