import java.util.ArrayList;
import java.util.Scanner;


public class TaskBoard {
	
	private static ArrayList<Story> storyList;
	
	public static void main(String[] args){
		try {
			storyList = new ArrayList<Story>();
			Scanner sn = new Scanner(System.in);
			
			while (true) {
				sn.useDelimiter("\\s+");
				// String s = sn.next().toString();
				// System.out.println(s);
				if (sn.hasNext() && sn.next().equalsIgnoreCase("create")) {
					// String s = sn.next().toString();
					// System.out.print(s);
					/*----If the input command line contain CREATE
					then check what kind of data is going to be created.
					Pattern is checking if the input format is correct----*/
					if (sn.hasNext() && sn.next().equalsIgnoreCase("story")) {
						// String s = sn.next().toString();
						// System.out.print(s);
						int sid = sn.nextInt();
						String sDes = sn.next();
						createStory(sid, sDes);
					} else if (sn.hasNext() && sn.next().equalsIgnoreCase("task")) {
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
						if (i == storyList.size()) {
							Story ns = new Story(sid);
							ns.createTask(tid, tDes);
							storyList.add(ns);
						}
					}
				} else if (sn.hasNext() && sn.next().equalsIgnoreCase("list")) {
					/*----If the input command line contain LIST
					then check what kind of data is going to be listed.
					Pattern is checking if the input format is correct----*/
					if (sn.next().matches("stor(.*)")) {
						// If the command word match story/stories, then list it
						listStory();
					} else if (sn.hasNext() && sn.next().matches("task(.*)")) {
						// Allow command with task/tasks
						int sid = sn.nextInt();
						for (int i = 0; i < storyList.size(); i++) {
							// Check if the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).listTask();
								break;
							}
						}
					}
				} else if (sn.hasNext() && sn.next().equalsIgnoreCase("delete")) {
					/*----If the input command line contain DELETE
					then check what kind of data is going to be deleted.
					Pattern is checking if the input format is correct----*/
					if (sn.hasNext() && sn.next().equalsIgnoreCase("story")) {
						int sid = sn.nextInt();
						deleteStory(sid);
					} else if (sn.hasNext() && sn.next().equalsIgnoreCase("task")) {
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						for (int i = 0; i < storyList.size(); i++) {
							// If the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).deleteTask(tid);
								break;
							}
						}
					}
				} else if (sn.hasNext() && sn.next().equalsIgnoreCase("complete")) {
					/*----If the input command line contain COMPLETE
					then turn the story into complete.
					Pattern is checking if the input format is correct----*/
					if (sn.next().equalsIgnoreCase("story") && sn.hasNextInt()) {
						int sid = sn.nextInt();
						completeStory(sid);
					}
				} else if (sn.hasNext() && sn.next().equalsIgnoreCase("move")) {
					/*----If the input command line contain MOVE
					then basing on story id and task id to find the task Column.
					Pattern is checking if the input format is correct----*/
					if (sn.hasNext() && sn.next().equalsIgnoreCase("task")) {
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						String col = sn.next();
						for (int i = 0; i < storyList.size(); i++) {
							// If the item is in the story list
							if (storyList.get(i).getStoryid() == sid) {
								storyList.get(i).moveTask(tid, col);
								break;
							}
						}
					}
				} else if (sn.hasNext() && sn.next().equalsIgnoreCase("update")) {
					/*----If the input command line contain UPDATE
					then basing on story id and task id to find the task Description.
					Pattern is checking if the input format is correct----*/
					if (sn.hasNext() && sn.next().equalsIgnoreCase("task")) {
						int sid = sn.nextInt();
						int tid = sn.nextInt();
						String des = sn.next();
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
			System.out.println("Input format error");
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
			//listStory();
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
