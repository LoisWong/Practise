package taskboard;

import java.util.HashMap;
import java.util.Iterator;

public class Story {
	//A basic story contains a story id, description and its tasks
	private int sid;
	private String sDescription;
	private HashMap<Integer, Task> taskmap;
	
	public Story(int id, String des){
		//Constructor
		this.sid = id;
		this.sDescription = des;
		this.taskmap = new HashMap<Integer, Task>();
	}
	public int getStoryid(){
		return sid;
	}
	
	public String getStory(){
		return sDescription;
	}
	
	public boolean checkComplete() {
		//Checking if every task is completed
		Iterator<Integer> taskIterator = taskmap.keySet().iterator();
		while(taskIterator.hasNext()){
			Integer key = taskIterator.next();
			
			//If any task's column is not Done, then return false
			if(taskmap.get(key).getTaskColumn() != 4){
				return false;
			}
		}
		//All the tasks are completed as if no column equals to 4
		return true;
	}
	
	public void createTask(int tid, String tDes){
		//Using task id and description to create a task
		if(taskmap.containsKey(tid)){
			System.out.println("the task is exist");
		}else{
			taskmap.put(tid, new Task(tid, tDes));
			System.out.println("Created task");
		}
	}
	
	public void listTask() {
		Iterator<Integer> taskIterator = taskmap.keySet().iterator();
		while(taskIterator.hasNext()){
			Integer key = taskIterator.next();
			System.out.println(taskmap.get(key).getTask());
		}	
	}
	public void deleteTask(int tid) {
		//Using task id to delete a task
		if(taskmap.containsKey(tid)){
			taskmap.remove(tid);
			System.out.println("deleted");
		}else
			System.out.println("No such task to delete");
	}
	public void moveTask(int tid, String col) {
		//Using task id and new column to move a task
		if(taskmap.containsKey(tid)){
			taskmap.get(tid).moveTask(col);
		}else
			System.out.println("No such task to move");	
	}
	public void updateTask(int tid, String desc) {
		//Using task id and description to update a task
		if(taskmap.containsKey(tid)){
			taskmap.get(tid).uodateTask(desc);
			System.out.println("updated");
		}else
			System.out.println("No such task to move");		
	}
	
}
 