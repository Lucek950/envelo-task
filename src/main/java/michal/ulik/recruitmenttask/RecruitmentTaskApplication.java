package michal.ulik.recruitmenttask;

import lombok.RequiredArgsConstructor;
import michal.ulik.recruitmenttask.services.NbpTableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class RecruitmentTaskApplication {
	private final NbpTableService nbpTableService;

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentTaskApplication.class, args);
	}

	@Bean
	public void initializeDb(){
		nbpTableService.createNbpTable();
	}
}
