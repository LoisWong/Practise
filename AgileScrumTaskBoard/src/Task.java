
public class Task {
	private int tid;
	private String tDescription;
	private String column;
	
	public Task(int id, String des){
		this.tid = id;
		this.tDescription = des;
		this.column = "To Do";
	}
	
	public void setTaskDesc(String des){
		this.tDescription = des;
	}
	
	public void setTaskColumn(String col){
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
