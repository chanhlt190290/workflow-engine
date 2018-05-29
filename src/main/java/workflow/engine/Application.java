package workflow.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import workflow.engine.model.Action;
import workflow.engine.model.Request01;
import workflow.engine.service.ActionService;

@SpringBootApplication
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
        Action action = this.actionService.findById(1);
        System.out.println("Action detail: " + action.getId() + ", " + action.getName());
        List<Request01> requests = this.actionService.getRequests();
        System.out.println("requests list: " + requests.size());
    }

}
