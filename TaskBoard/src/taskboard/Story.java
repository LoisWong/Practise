package taskboard;

import java.util.HashMap;
import java.util.Iterator;

public class Story {
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
		Iterator<Integer> taskIterator = taskmap.keySet().iterator();
		while(taskIterator.hasNext()){
			Integer key = taskIterator.next();
			//All the tasks are completed as if no column equals to 4
			//If any task's column is not Done, then return false
			if(taskmap.get(key).getTaskColumn() != 4){
				return false;
			}
		}
		return true;
	}
	
	public void createTask(int tid, String tDes){
		if(taskmap.containsKey(tid)){
			System.out.println("the task is exist");
		}else
			taskmap.put(tid, new Task(tid, tDes));
	}
	
	public void listTask() {
		Iterator<Integer> taskIterator = taskmap.keySet().iterator();
		while(taskIterator.hasNext()){
			Integer key = taskIterator.next();
			System.out.println(taskmap.get(key).getTask());
		}	
	}
	public void deleteTask(int tid) {
		if(taskmap.containsKey(tid)){
			taskmap.remove(tid);
		}else
			System.out.println("No such task to delete");
	}
	public void moveTask(int tid, String col) {
		if(taskmap.containsKey(tid)){
			taskmap.get(tid).moveTask(col);
		}else
			System.out.println("No such task to move");	
	}
	public void updateTask(int tid, String desc) {
		if(taskmap.containsKey(tid)){
			taskmap.get(tid).uodateTask(desc);
		}else
			System.out.println("No such task to move");		
	}
	
}
 