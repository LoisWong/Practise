import java.util.ArrayList;
import java.util.Scanner;


public class TaskBoard {
	
	private static ArrayList<Story> storyList;
	
	public static void main(String[] args){
		try {
			storyList = new ArrayList<Story>();
			Scanner sn = new Scanner(System.in);
			String cm,item;
			
			while (true) {
				sn.useDelimiter("\\s+");
				cm = sn.next();
				item = sn.next();
				if (sn.hasNext() && cm.equalsIgnoreCase("create")) {
					
					/*----If the input command line contain CREATE
					then check what kind of data is going to be created.
					Checking if the input format is correct before execute----*/
					
					if (sn.hasNext() && item.equalsIgnoreCase("story")) {
						//Create story
						int sid = sn.nextInt();
						String sDes = sn.next();
						createStory(sid, sDes);
					} else if (sn.hasNext() && item.equalsIgnoreCase("task")) {
						//create task
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						String tDes = sn.next();
						int i = 0;
						while (i < storyList.size()) {
							// If the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).createTask(tid, tDes);
								break;
							}
							i++;
						}
						/*If the task is not belonging to an story which is exist
						then create a story with default setting */
						if (i == storyList.size()) {
							Story ns = new Story(sid);
							ns.createTask(tid, tDes);
							storyList.add(ns);
						}
					}
				} else if (cm.equalsIgnoreCase("list")) {
					
					/*----If the input command line contain LIST
					then check what kind of data is going to be listed.----*/
					
					if (item.startsWith("stor")){
						// If the command word match story/stories, then list it
						listStory();
					} else if (sn.hasNext() && item.startsWith("task")) {
						// Checking if the input format is correct before execute
						// Command could be task or tasks
						int sid = sn.nextInt();
						for (int i = 0; i < storyList.size(); i++) {
							// Check if the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).listTask();
								break;
							}
						}
					}
				} else if (sn.hasNext() && cm.equalsIgnoreCase("delete")) {
					
					/*----If the input command line contain DELETE
					then check what kind of data is going to be deleted.
					Checking if the input format is correct before execute----*/
					
					if (item.equalsIgnoreCase("story")) {
						int sid = sn.nextInt();
						deleteStory(sid);
					} else if (sn.hasNext() && item.equalsIgnoreCase("task")) {
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						for (int i = 0; i < storyList.size(); i++) {
							// Checking if the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).deleteTask(tid);
								break;
							}
						}
					}
				} else if (sn.hasNext() && cm.equalsIgnoreCase("complete")) {
					
					/*----If the input command line contain COMPLETE
					then turn the story into complete.
					Checking if the input format is correct before execute----*/
					
					if (item.equalsIgnoreCase("story")) {
						int sid = sn.nextInt();
						completeStory(sid);
					}
				} else if (sn.hasNext() && cm.equalsIgnoreCase("move")) {
					
					/*----If the input command line contain MOVE
					then basing on story id and task id to find the task Column.
					Checking if the input format is correct before execute----*/
					
					if (sn.hasNext() && item.equalsIgnoreCase("task")) {
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						String col;
						if (sn.hasNext()){
							//If the input format is legal, then set into new column 
							col = sn.next();
						}else {
							//Otherwise, set the task into To Do list 
							col = "To Do";
						}
						for (int i = 0; i < storyList.size(); i++) {
							// If the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).moveTask(tid, col);
								break;
							}
						}
					}
				} else if (sn.hasNext() && cm.equalsIgnoreCase("update")) {
					
					/*----If the input command line contain UPDATE
					then basing on story id and task id to find the task Description.
					Pattern is checking if the input format is correct----*/
					
					if (sn.hasNext() && item.equalsIgnoreCase("task")) {
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						String des;
						if (sn.hasNext()){
							des = sn.next();
						}else {
							des = "NULL";
						}
						for (int i = 0; i < storyList.size(); i++) {
							// If the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).updateTask(tid, des);
								break;
							}
						}
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Building error");
		}
	}
	
	private static void createStory(int sid, String Description){
		Story s = new Story(sid,Description);
		boolean flag = false;
		for(int i=0; i<storyList.size(); i++){
			//If there is a same item in the story list, replace it
			if(sid == storyList.get(i).getStoryid()){
				storyList.set(i, s);
				flag = true;
			}
		}
		//If it is a new story, add it
		if(flag == false){
			storyList.add(s);
			listStory();
		}
	}
	
	private static void listStory(){
		for(Story s:storyList){
			System.out.println(s.getStory());
		}
	}
	
	private static void completeStory(int sid){
		for(int i=0; i<storyList.size(); i++){
			//If the item is in the story list, modify its tasks
			if(sid == storyList.get(i).getStoryid()){
				storyList.get(i).completeTask();
				/*Story s = storyList.get(i);
				s.completeTask();
				storyList.set(i, s);*/
				break;
			}
		}
	}
	
	private static void deleteStory(int sid){
		for(int i=0; i<storyList.size(); i++){
			//If the item is in the story list, delete it
			if(storyList.get(i).getStoryid() == sid){
				storyList.remove(i);
			}
		}
	}

}
