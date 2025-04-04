package harjoitustyo.levykokoelma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import harjoitustyo.levykokoelma.domain.ReleaseRepository;
import harjoitustyo.levykokoelma.domain.FormatRepository;
import harjoitustyo.levykokoelma.domain.GenreRepository;
import harjoitustyo.levykokoelma.domain.Release;

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
    public String addNewRelease(@ModelAttribute Release release) {
        repository.save(release);

        return "redirect:/collection";
    }

    @GetMapping("/deleterelease/{releaseId}")
    public String deleteRelease(@PathVariable("releaseId") Long releaseId) {
        repository.deleteById(releaseId);

        return "redirect:/collection";
    }
}
