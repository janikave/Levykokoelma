package harjoitustyo.levykokoelma.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    List<Genre> findAll();

}

