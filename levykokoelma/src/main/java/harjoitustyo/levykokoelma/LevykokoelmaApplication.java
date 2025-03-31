package harjoitustyo.levykokoelma;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.levykokoelma.domain.Format;
import harjoitustyo.levykokoelma.domain.FormatRepository;
import harjoitustyo.levykokoelma.domain.Genre;
import harjoitustyo.levykokoelma.domain.Release;
import harjoitustyo.levykokoelma.domain.ReleaseRepository;

@SpringBootApplication
public class LevykokoelmaApplication {
	private static final Logger log = LoggerFactory.getLogger(LevykokoelmaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LevykokoelmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ReleaseRepository repository, FormatRepository frepository) {

		return (args) -> {

			Format cd = new Format("CD");
			Format lp = new Format("Vinyl");
			Format cas = new Format("Cassette");
			Format dig = new Format("Digital");

			frepository.save(cd);
			frepository.save(lp);
			frepository.save(cas);
			frepository.save(dig);

			Genre rock = new Genre("Rock");
			Genre pop = new Genre("Pop");

			log.info("fetching available formats");
			for (Format format : frepository.findAll()) {
				log.info(format.toString());

				log.info("some sample releases");

				Release r1 = new Release("Abbey Road", "The Beatles", (long) 1969, 5, cd, pop);
				Release r2 = new Release("Let It Be", "The Replacements", (long) 1984, 4, lp, rock);

				repository.save(r1);
				repository.save(r2);

				log.info("fetching the sample releases");
				for (Release release : repository.findAll()) {

					log.info(release.toString());
				}

			}
		};
	}

}
