package harjoitustyo.levykokoelma;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.levykokoelma.domain.Release;
import harjoitustyo.levykokoelma.domain.ReleaseRepository;

@SpringBootApplication
public class LevykokoelmaApplication {
	private static final Logger log = LoggerFactory.getLogger(LevykokoelmaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LevykokoelmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ReleaseRepository repository) {

		return (args) -> {
			log.info("some sample releases");

			Release r1 = new Release("Abbey Road", "Beatles", (long) 1969, 5);
			Release r2 = new Release("Let It Be", "The Replacements", (long) 1984, 4);

			repository.save(r1);
			repository.save(r2);

			log.info("fetching the sample releases");
			for (Release release : repository.findAll()) {

				log.info(release.toString());
			}
		};
	}

}
