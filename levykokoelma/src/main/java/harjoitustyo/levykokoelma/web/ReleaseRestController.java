package harjoitustyo.levykokoelma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import harjoitustyo.levykokoelma.domain.Release;
import harjoitustyo.levykokoelma.domain.ReleaseRepository;

@Controller
public class ReleaseRestController {

    @Autowired
    private ReleaseRepository repository;

    @GetMapping("/records")
    public @ResponseBody List<Release> getRecordsRest() {

        return (List<Release>) repository.findAll();
    }

    @GetMapping("/records/{releaseId}")
    public @ResponseBody Optional<Release> findRecordByIdRest(@PathVariable("releaseId") Long releaseId) {

        return repository.findById(releaseId);
    }
}
