package harjoitustyo.levykokoelma.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReleaseRepositoryTests {

    @Autowired
    private ReleaseRepository repository;

    @Test
    public void findReleaseByNameTest() {
        List<Release> records = repository.findByTitle("Let It Be");
        assertThat(records).hasSize(1);
    }

    @Test
    public void newReleaseTest() {
        Release release = new Release();
        repository.save(release);
        assertThat(release.getReleaseId()).isNotNull();
    }

    @Test
    public void editReleaseTest() {
        Release release = new Release();
        release.setTitle("levy");
        release.setArtist("artisti");
        release.setReleaseYear((long) 1999);
        repository.save(release);
        assertThat(release.getReleaseId()).isNotNull();

        release.setTitle("kiekko");
        assertThat(release.getTitle()).contains("kiekko");
    }

    @Test
    public void deleteReleaseTest() {
        Release release = new Release();
        release.setTitle("levy");
        release.setArtist("artisti");
        release.setReleaseYear((long) 1999);
        repository.save(release);

        List<Release> records = repository.findByReleaseId(release.getReleaseId());
        assertThat(records).isNotEmpty();

        repository.deleteById(release.getReleaseId());

        records = repository.findByReleaseId(release.getReleaseId());
        assertThat(records).isEmpty();
    }
}
