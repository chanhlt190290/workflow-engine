package workflow.engine;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import workflow.engine.model.Action;
import workflow.engine.model.Request;
import workflow.engine.model.State;
import workflow.engine.service.ActionService;
import workflow.engine.service.RequestService;

@SpringBootApplication
//        (exclude = {DataSourceAutoConfiguration.class, 
//            DataSourceTransactionManagerAutoConfiguration.class, 
//            HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories(enableDefaultTransactions = false)
@EnableJpaAuditing
public class Application implements CommandLineRunner {

    @Autowired
    ActionService actionService;

    @Autowired
    RequestService rquestService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        List<Action> actions = this.actionService.getAll();
//        System.out.println("Action list: " + actions.size() + ", " + actions.get(0).getName());
//        Action action = this.actionService.findById(1);
//        System.out.println("Action detail: " + action.getId() + ", " + action.getName());
//        
//        Action action1 = new Action();
//        action1.setName("Test action");
//        action1.setProcess(1);
//        action1.setType(1);
//        action1 = this.actionService.create(action1);
//        
//        System.out.println("Action created: " + action1.getId() + ", " + action1.getName());
//        
//        
//        Request request = new Request();
//        request.setTitle("Test request");
//        request.setProcess(1);
//        request.setUser(1);
//        State state = new State();
//        state.setId(1);
//        request.setState(state);
//        request.setUsername("ChanhLT");
//        request = this.rquestService.create(request);
//
//        System.out.println("Request created: " + request.getId() + ", " + request.getTitle());

//        Request request = this.rquestService.getById(10);
//
//        System.out.println("Request created: " + request.getId() + ", " + request.getTitle());

//        List<Request01> requests = this.actionService.getRequests();
//        System.out.println("requests list: " + requests.size());
    }

}
