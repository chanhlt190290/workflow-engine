package workflow.engine.service.impl;



import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.model.Action;
import workflow.engine.repository.ActionRepository;
import workflow.engine.service.ActionService;
import workflow.engine.service.RequestService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionRepository actionRepo;

    @Autowired
    RequestService requestService;

    @Override
    public List<Action> getAll() {
        return actionRepo.findAll();
    }

    @Override
    public Action findById(int id) {
        return actionRepo.findById(id).get();
    }
////
////    @Override
////	public List<Request01> getRequests() {
////		return requestService.getRequests();
////	}

//    @Override
//    public List<Action> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Action findById(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Action create(Action action) {
        Action ac = actionRepo.save(action);
        return ac;
    }



}