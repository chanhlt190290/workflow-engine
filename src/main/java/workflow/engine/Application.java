package workflow.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import workflow.engine.model.RequestAction;
import workflow.engine.service.RequestActionService;
import workflow.engine.service.RequestService;

@SpringBootApplication
@EnableJpaAuditing
public class Application implements CommandLineRunner {

    @Autowired
    RequestService rquestService;

    @Autowired
    RequestActionService rquestActionService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
//          #########################
//        Request request = new Request();
//        request.setTitle("Test request 3");
//        request.setProcess(1);
//        request.setUser(1);
//        State state = new State();
//        state.setId(1);
//        request.setState(state);
//        request.setUsername("ChanhLT 2");
//        request = this.rquestService.create(request);
//        System.out.println("Request created: " + mapper.writeValueAsString(request));
//          #########################
        RequestAction ra = this.rquestActionService.performAction(51);
        System.out.println("requests action: " + mapper.writeValueAsString(ra));
    }

}
