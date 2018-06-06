package workflow.engine.model.mybatis;

/**
 *
 * @author chanhlt
 */
public class Request {

    /**
     * @return the process
     */
    public int getProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(int process) {
        this.process = process;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the user
     */
    public int getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(int user) {
        this.user = user;
    }

    private int id;

    private int process;

    private String title;

    private int user;

    private int state;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

}
