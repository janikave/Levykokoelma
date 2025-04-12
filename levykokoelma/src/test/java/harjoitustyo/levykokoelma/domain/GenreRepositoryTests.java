package harjoitustyo.levykokoelma.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GenreRepositoryTests {

    @Autowired
    private GenreRepository grepository;

    @Test
    public void findGenreByName() {
        List<Genre> genres = grepository.findByName("Pop");
        assertThat(genres).hasSize(1);
    }

    @Test
    public void newGenreTest() {
        Genre triphop = new Genre("Trip Hop");
        grepository.save(triphop);
        assertThat(triphop.getGenreId()).isNotNull();
    }

    @Test
    public void deleteGenreTest() {
        Genre genre = new Genre("Genre");
        grepository.save(genre);

        List<Genre> genres = grepository.findByGenreId(genre.getGenreId());
        assertThat(genres).isNotNull();

        grepository.deleteById(genre.getGenreId());

        genres = grepository.findByGenreId(genre.getGenreId());
        assertThat(genres).isEmpty();
    }
}
