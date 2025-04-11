package harjoitustyo.levykokoelma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import harjoitustyo.levykokoelma.domain.ReleaseRepository;
import harjoitustyo.levykokoelma.domain.FormatRepository;
import harjoitustyo.levykokoelma.domain.Genre;
import harjoitustyo.levykokoelma.domain.GenreRepository;
import harjoitustyo.levykokoelma.domain.Release;

import jakarta.validation.Valid;

@Controller
public class ReleaseController {

    @Autowired
    private ReleaseRepository repository;

    @Autowired
    private FormatRepository frepository;

    @Autowired
    private GenreRepository grepository;

    @GetMapping("/collection")
    public String getAllRecords(Model model) {

        List<Release> records = (List<Release>) repository.findAll();
        model.addAttribute("records", records);
        return "collection";
    }

    @GetMapping("/addrelease")
    public String getNewRelease(Model model) {
        model.addAttribute("release", new Release());
        model.addAttribute("formats", frepository.findAll());
        model.addAttribute("genres", grepository.findAll());

        return "addrelease";
    }

    @PostMapping("/saverelease")
    public String addNewRelease(@Valid @ModelAttribute("release") Release release, BindingResult bindingResult,
            @RequestParam("genres") List<Long> genreIds, Model model) {
        List<Genre> selectedGenres = (List<Genre>) grepository.findAllById(genreIds);
        release.setGenres(selectedGenres);

        if (bindingResult.hasErrors()) {
            model.addAttribute("formats", frepository.findAll());
            model.addAttribute("genres", grepository.findAll());
            return "addrelease";
        } else {
            repository.save(release);

            return "redirect:/collection";
        }
    }

    @GetMapping("/editrelease/{releaseId}")
    public String editRelease(@Valid @PathVariable("releaseId") Long releaseId, Model model) {
        Release release = repository.findById(releaseId).orElse(null);

        model.addAttribute("release", release);
        model.addAttribute("formats", frepository.findAll());
        model.addAttribute("genres", grepository.findAll());

        return "addrelease";
    }

    @PostMapping("/updaterelease")
    public String updateRelease(@ModelAttribute Release release, @RequestParam("genres") List<Long> genreIds) {
        List<Genre> selectedGenres = (List<Genre>) grepository.findAllById(genreIds);
        release.setGenres(selectedGenres);
        repository.save(release);

        return "redirect:/collection";
    }

    @GetMapping("/deleterelease/{releaseId}")
    public String deleteRelease(@PathVariable("releaseId") Long releaseId) {
        repository.deleteById(releaseId);

        return "redirect:/collection";
    }
}
