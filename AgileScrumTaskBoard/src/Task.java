
public class Task {
	//A basic task contains a task id, description and its position(column)
	private int tid;
	private String tDescription;
	private String column;
	
	public Task(int id, String des){
		//Constructor of task
		this.tid = id;
		this.tDescription = des;
		this.column = "To Do";
	}
	
	public void setTaskDesc(String des){
		//In order to do modification(Update)
		this.tDescription = des;
	}
	
	public void setTaskColumn(String col){
		//In order to do modification(Move)
		this.column = col;
	}
	
	public int getTaskid(){
		return tid;
	}
	
	public String getTask(){
		return tDescription;
	}
	
	public String getTaskColumn(){
		return column;
	}
}
