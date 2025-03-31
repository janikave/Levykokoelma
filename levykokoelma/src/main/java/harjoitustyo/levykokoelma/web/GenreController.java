package harjoitustyo.levykokoelma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import harjoitustyo.levykokoelma.domain.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository grepository;
}
