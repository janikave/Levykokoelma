package harjoitustyo.levykokoelma.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.levykokoelma.domain.FormatRepository;

@SpringBootTest
public class FormatControllerTests {

    @Autowired
    private FormatRepository repository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(repository).isNotNull();
    }

}
