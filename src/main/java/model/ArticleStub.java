/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ViJAN
 */
public class ArticleStub {
    
    public static List<Article> getAll(){
        List<Article> liste = new ArrayList<>();
        liste.add(new Article("1", "Article 1", "C'est l'article 1"));
        liste.add(new Article("2", "Article 2", "C'est l'article 2"));
        liste.add(new Article("3", "Article 3", "C'est l'article 3"));
        liste.add(new Article("4", "Article 4", "C'est l'article 4"));
        return liste;
    }
    
}
