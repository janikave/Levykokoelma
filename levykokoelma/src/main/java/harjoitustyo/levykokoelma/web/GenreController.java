package harjoitustyo.levykokoelma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;

import harjoitustyo.levykokoelma.domain.Genre;
import harjoitustyo.levykokoelma.domain.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository grepository;

    @GetMapping("/genres")
    public String getGenres(Model model) {

        List<Genre> genres = (List<Genre>) grepository.findAll();
        model.addAttribute("genres", genres);

        return "genres";
    }

    @GetMapping("/addgenre")
    public String getNewGenre(Model model) {

        model.addAttribute("genre", new Genre());

        return "addgenre";
    }

    @PostMapping("/savegenre")
    public String addNewGenre(@ModelAttribute Genre genre) {
        grepository.save(genre);

        return "redirect:/genres";
    }
}
