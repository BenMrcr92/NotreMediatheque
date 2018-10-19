package nous2.mediatheque;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("classpath:*-context.xml")
@ComponentScan(basePackages = { "nous2.mediatheque.repositories",
	"nous2.mediatheque.services" })
@EnableJpaRepositories("nous2.mediatheque.repositories")
@EnableTransactionManagement
public class AppConfig {
    // Empty class
}
