package harjoitustyo.levykokoelma.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReleaseRepository extends CrudRepository<Release, Long> {

    List<Release> findAll();

    List<Release> findByReleaseId(Long releaseId);

    List<Release> findByTitle(String title);

    List<Release> findByArtist(String artist);
}
