package taskboard;

public class Task {
	private int tid;
	private String tDescription;
	private int column;
	
	public Task(int id, String tDes) {
		this.tid = id;
		this.tDescription = tDes;
		this.column = 1;
	}
	
	public int getTaskId(){
		return this.tid;
	}
	
	public String getTask(){
		return this.tDescription;
	}

	public int getTaskColumn(){
		return this.column;
	}
	
/*	//In case need to show task's column
    public String showColumn(){
		switch (this.column){
		case 1:return "To Do";
		case 2:return "In Process";
		case 3:return "To Verify";
		case 4:return "Done";
		default:return "To Do";
		}
	}*/

	public void moveTask(String col) {
		/*Indicate the moving algorithm: 
		--------------------------------------------------------------
		--Each task has to go through the “To Do”, “In Process”, 
		“To Verify”, and “Done” columns
		--------------------------------------------------------------
		--Each task that is not in the “Done” column can be moved back 
		to “To Do” or “In Process” column if necessary
		------------------------------------------------------------*/
		int nowCol = this.column;
		//If the task is done, then it cannot be moved
		if (nowCol == 4){
			System.out.println("This task is done");
		}else{
			//If the task is now in verification, it can move to "to do" or "in process"
			if (nowCol == 3 && col.equalsIgnoreCase("to do")){
				this.column = 1;
			}
			else if (nowCol == 3 && col.equalsIgnoreCase("in process")){
				this.column = 2;
			}
			//If the task is now in process, then it could be moved to "to do" or "to verify"
			else if (nowCol == 2 && col.equalsIgnoreCase("to do")){
				this.column = 1;
			}
			else if (nowCol == 2 && col.equalsIgnoreCase("to verify")){
				this.column = 3;
			}
			//If the task is in to do list, then it can only be moved to "in process"
			else if (nowCol == 1 && col.equalsIgnoreCase("in process")){
				this.column = 2;
			}
			else System.out.println("Illegal task moving");
		}
	}

	public void uodateTask(String desc) {
		this.tDescription = desc;
	}
}
