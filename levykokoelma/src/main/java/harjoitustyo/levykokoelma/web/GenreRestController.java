package harjoitustyo.levykokoelma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitustyo.levykokoelma.domain.Genre;
import harjoitustyo.levykokoelma.domain.GenreRepository;

@Controller
public class GenreRestController {

    @Autowired
    private GenreRepository grepository;

    @GetMapping("/allgenres")
    public @ResponseBody List<Genre> findAllGenresRest() {
        return (List<Genre>) grepository.findAll();
    }

    @GetMapping("/allgenres/{genreId}")
    public @ResponseBody Optional<Genre> findGenreByIdRest(@PathVariable("genreId") Long genreId) {
        return grepository.findById(genreId);
    }
}
