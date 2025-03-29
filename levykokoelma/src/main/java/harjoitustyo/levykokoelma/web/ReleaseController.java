package harjoitustyo.levykokoelma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import harjoitustyo.levykokoelma.domain.ReleaseRepository;
import harjoitustyo.levykokoelma.domain.Release;

@Controller
public class ReleaseController {

    @Autowired
    private ReleaseRepository repository;

    @GetMapping("/releaselist")
    public String getAllRecords(Model model) {

        List<Release> records = (List<Release>) repository.findAll();
        model.addAttribute("records", records);
        return "prööt";
    }

}
