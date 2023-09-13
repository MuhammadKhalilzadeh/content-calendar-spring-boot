package com.mmdsb1.contentcalendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mmdsb1.contentcalendar.model.Content;
import com.mmdsb1.contentcalendar.model.Status;
import com.mmdsb1.contentcalendar.model.Type;
import com.mmdsb1.contentcalendar.repository.ContentRepository;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repo) {
		return args -> {
			Content content = new Content(null, "My CommandLineRunner Content Object", "This is a test object",
					Status.COMPLETE,
					Type.ARTICLE, LocalDateTime.now(), null, "");

			repo.save(content);

		};
	}

}
