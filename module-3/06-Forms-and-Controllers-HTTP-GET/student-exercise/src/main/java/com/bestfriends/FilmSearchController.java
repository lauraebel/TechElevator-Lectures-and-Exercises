package com.techelevator;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Film;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/filmSearch")
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping("/filmSearchResult")
    public String searchFilms(HttpServletRequest request) {
    	int maxLength = Integer.parseInt(request.getParameter("maxLength"));
    	int minLength = Integer.parseInt(request.getParameter("minLength"));
    	String genre = request.getParameter("genre");
    	List<Film> filmList = filmDao.getFilmsBetween(genre, minLength, maxLength);
    	request.setAttribute("films", filmList);
        return "filmList";
    }

}