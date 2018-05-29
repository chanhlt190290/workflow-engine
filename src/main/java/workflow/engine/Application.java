package workflow.engine;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import workflow.engine.model.Action;
import workflow.engine.service.ActionService;

@SpringBootApplication
//@EnableJpaAuditing
public class Application implements CommandLineRunner {

    @Autowired
    ActionService actionService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		List<Action> actions = this.actionService.getAll();
        System.out.println("Action list: " + actions.size() + ", " + actions.get(0).getName());
	}

    // @Bean
    // public SessionFactory sessionFactory(EntityManagerFactory emf) {
    //     if (emf.unwrap(SessionFactory.class) == null) {
    //         throw new NullPointerException("factory is not a hibernate factory");
    //     }
    //     return emf.unwrap(SessionFactory.class);
    // }

}
