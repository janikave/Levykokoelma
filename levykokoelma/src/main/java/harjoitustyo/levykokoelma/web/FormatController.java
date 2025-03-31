package harjoitustyo.levykokoelma.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import harjoitustyo.levykokoelma.domain.Format;
import harjoitustyo.levykokoelma.domain.FormatRepository;

@Controller
public class FormatController {

    @Autowired
    private FormatRepository frepository;

    @GetMapping("/formatlist")
    public String getFormats(Model model) {

        List<Format> formats = (List<Format>) frepository.findAll();
        model.addAttribute("formats", formats);

        return "formatlist";
    }
}
