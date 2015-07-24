import java.util.ArrayList;


public class Story {
	private int sid;
	private String sDescription;
	private ArrayList<Task> taskList;
	
	public Story(int id, String des){
		this.sid = id;
		this.sDescription = des;
		this.taskList = new ArrayList<Task>();
	}
	
	public int getStoryid(){
		return sid;
	}
	
	public String getStory(){
		return sDescription;
	}
	
	public void createTask(int tid, String Description){
		Task t = new Task(tid,Description);
		boolean flag = false;
		for(int i=0; i<taskList.size(); i++){
			//If there is a same item in the task list, replace it
			if(tid == taskList.get(i).getTaskid()){
				taskList.set(i, t);
				flag = true;
			}
		}
		//If it is a new task, add it
		if(flag == false){
			taskList.add(t);
		}
	}
	
	public void listTask(){
		for(Task t:taskList){
			System.out.println(t.getTask());
		}
	}
	
	public void completeTask(){
		for(Task t:taskList){
			t.setTaskColumn("done");
		}
	}
	
	public void moveTask(int tid, String column){
		looking:
		for(int i=0; i<taskList.size(); i++){
			//If the item is in the task list, change its column
			if(tid == taskList.get(i).getTaskid()){
				//If the task is marked as "done", ignore the change
				if(taskList.get(i).getTaskColumn().equalsIgnoreCase("done")){
					break looking;
				}
				else{
					//---Further design: restrict columns value---
					taskList.get(i).setTaskColumn(column);
				}
			}
			//If there is no such task, ignore command
		}
		
	}
	
	public void updateTask(int tid, String Description){
		for(int i=0; i<taskList.size(); i++){
			//If the item is in the task list, update its description
			if(tid == taskList.get(i).getTaskid()){
				taskList.get(i).setTaskDesc(Description);
			}
		}
	}
	
	public void deleteTask(int tid){
		for(int i=0; i<taskList.size(); i++){
			//If the item is in the task list, delete it
			if(tid == taskList.get(i).getTaskid()){
				taskList.remove(i);
			}
		}
	}
}
