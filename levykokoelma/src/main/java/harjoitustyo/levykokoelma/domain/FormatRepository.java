package harjoitustyo.levykokoelma.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FormatRepository extends CrudRepository<Format, Long> {

    List<Format> findAll();

    List<Format> findByFormatId(Long formatId);

    List<Format> findByType(String type);
}
