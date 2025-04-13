package harjoitustyo.levykokoelma;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.levykokoelma.domain.AppUser;
import harjoitustyo.levykokoelma.domain.AppUserRepository;
import harjoitustyo.levykokoelma.domain.Format;
import harjoitustyo.levykokoelma.domain.FormatRepository;
import harjoitustyo.levykokoelma.domain.Genre;
import harjoitustyo.levykokoelma.domain.GenreRepository;
import harjoitustyo.levykokoelma.domain.Release;
import harjoitustyo.levykokoelma.domain.ReleaseRepository;

@SpringBootApplication
public class LevykokoelmaApplication {
	private static final Logger log = LoggerFactory.getLogger(LevykokoelmaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LevykokoelmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ReleaseRepository repository, FormatRepository frepository,
			GenreRepository grepository, AppUserRepository urepository) {

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
			Genre hiphop = new Genre("Hip Hop");
			Genre punk = new Genre("Punk");
			Genre electro = new Genre("Electronic");
			Genre dance = new Genre("Dance");

			grepository.save(rock);
			grepository.save(pop);
			grepository.save(hiphop);
			grepository.save(punk);
			grepository.save(electro);
			grepository.save(dance);

			List<Genre> rocklist = List.of(rock);
			List<Genre> poplist = List.of(pop);

			log.info("fetching available formats");
			for (Format format : frepository.findAll()) {
				log.info(format.toString());
			}

			log.info("some sample releases");

			Release r1 = new Release("Abbey Road", "The Beatles", 1969, 5, cd, poplist);
			Release r2 = new Release("Let It Be", "The Replacements", 1984, 4, lp, rocklist);

			repository.save(r1);
			repository.save(r2);

			log.info("fetching the sample releases");
			for (Release release : repository.findAll()) {

				log.info(release.toString());
			}

			AppUser user1 = new AppUser("user",
					"$2a$12$RTpkDOxp1aAw7UlLiGQ9H.Xd6OCW6DxUY04d7xs8HH4Po.UhVsj1e",
					"ROLE_USER");
			AppUser user2 = new AppUser("admin",
					"$2a$12$QTHarE4Smz.WIuxkcVfEzeP6j0ZLjyZA6wcdgS6LLf8QGxyY39d4e",
					"ROLE_ADMIN");

			urepository.save(user1);
			urepository.save(user2);

		};
	};
}
