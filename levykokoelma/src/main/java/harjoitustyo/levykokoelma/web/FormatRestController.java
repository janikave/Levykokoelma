package harjoitustyo.levykokoelma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitustyo.levykokoelma.domain.Format;
import harjoitustyo.levykokoelma.domain.FormatRepository;

@Controller
public class FormatRestController {

    @Autowired
    private FormatRepository frepository;

    @GetMapping("/formats")
    public @ResponseBody List<Format> getAllFormatsRest() {
        return (List<Format>) frepository.findAll();
    }

    @GetMapping("/formats/{formatId}")
    public @ResponseBody Optional<Format> getFormatByIdRest(@PathVariable("formatId") Long formatId) {
        return frepository.findById(formatId);
    }
}
