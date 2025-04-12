package harjoitustyo.levykokoelma.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FormatRepositoryTest {

    @Autowired
    private FormatRepository frepository;

    @Test
    public void findFormatByNameTest() {
        List<Format> formats = frepository.findByType("Digital");
        assertThat(formats).hasSize(1);
    }

    @Test
    public void newFormatTest() {
        Format format = new Format("formaatti");
        frepository.save(format);
        assertThat(format.getFormatId()).isNotNull();
    }
}
