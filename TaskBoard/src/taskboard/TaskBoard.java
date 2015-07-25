package taskboard;

import java.util.HashMap;
import java.util.Iterator;

public class TaskBoard {
	
	private static TaskBoard sInstance = null;
	private HashMap<Integer, Story> storymap;
	
	private TaskBoard(){
		this.storymap = new HashMap<Integer, Story>();
	}
	
	public static TaskBoard getInstance(){
		if(sInstance == null)
			sInstance = new TaskBoard();
		return sInstance;
	}
	
	public void createStory(int sid, String Desc){
		if(storymap.containsKey(sid)){
			System.out.println("the story is exist");
		}else
			storymap.put(sid, new Story(sid, Desc));
	} 
	public void listStory(){
		Iterator<Integer> storyIterator = storymap.keySet().iterator();
		while(storyIterator.hasNext()){
			Integer key = storyIterator.next();
			System.out.println(storymap.get(key).getStory());
		}
	}
	public void completeStory(int sid){
		if(storymap.containsKey(sid)){
			if(storymap.get(sid).checkComplete()){
				//Not clear about the Mark requirement, but operation can be done here!
				//---More operation with the story---//
				System.out.println("Completed");
			}else System.out.println("Not Completed");
		}else
			System.out.println("the story is not exist");
	}
	public void deleteStory(int sid){
		if(storymap.containsKey(sid)){
			storymap.remove(sid);
		}else
			System.out.println("No such story to delete");
	}
	public void createTask(int sid, int tid, String Desc){
		if(storymap.containsKey(sid)){
			storymap.get(sid).createTask(tid, Desc);
		}else
			System.out.println("No such story to create task");
	}
	public void listTask(int sid){
		if(storymap.containsKey(sid)){
			storymap.get(sid).listTask();
		}else
			System.out.println("No such story to list task");
	}
	public void deleteTask(int sid, int tid){
		if(storymap.containsKey(sid)){
			storymap.get(sid).deleteTask(tid);
		}else
			System.out.println("No such story to delete task");
	}
	public void moveTask(int sid, int tid, String col){
		if(storymap.containsKey(sid)){
			storymap.get(sid).moveTask(tid,col);
		}else
			System.out.println("No such story to move task");
	}
	public void updateTask(int sid, int tid, String Desc){
		if(storymap.containsKey(sid)){
			storymap.get(sid).updateTask(tid, Desc);
		}else
			System.out.println("No such story to update task");
	}
}
