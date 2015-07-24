import java.util.ArrayList;
import java.util.Scanner;


public class TaskBoard {
	private static ArrayList<Story> storyList;
	
	public static void main(String[] args){
		try {
			storyList = new ArrayList<Story>();
			Scanner s = new Scanner(System.in).useDelimiter("\\s+");
			
			if(s.next().equalsIgnoreCase("create") && s.hasNext()){
				/*----If the input command line contain CREATE
				then check what kind of data is going to be created.
				Pattern is checking if the input format is correct----*/
				if(s.next().equalsIgnoreCase("story") && s.hasNext("\\d+\\s+\\w+")){
					int sid = s.nextInt();
					String sDes = s.next();
					createStory(sid, sDes);
				}
				else if(s.next().equalsIgnoreCase("task") && s.hasNext("\\d+\\s+\\d+\\s+\\w+")){
					int sid = s.nextInt();
					int tid = s.nextInt();
					String tDes = s.next();
					int i = 0;
					while(i<storyList.size()){
						//If the item is in the story list
						if(storyList.get(i).getStoryid() == sid){
							storyList.get(i).createTask(tid, tDes);
							break;
						}
						i++;
					}
					if(i == storyList.size()){
						Story ns = new Story(sid);
						ns.createTask(tid, tDes);
						storyList.add(ns);
					}
				}
			}
			else if(s.next().equalsIgnoreCase("list") && s.hasNext()){
				/*----If the input command line contain LIST
				then check what kind of data is going to be listed.
				Pattern is checking if the input format is correct----*/
				if(s.next().equalsIgnoreCase("story")){
					listStory();
				}
				else if(s.next().equalsIgnoreCase("task") && s.hasNext("\\d+")){
					int sid = s.nextInt();
					for(int i=0; i<storyList.size(); i++){
						//Check if the item is in the story list
						if(storyList.get(i).getStoryid() == sid){
							storyList.get(i).listTask();
							break;
						}
					}
				}
			}
			else if(s.next().equalsIgnoreCase("delete") && s.hasNext()){
				/*----If the input command line contain DELETE
				then check what kind of data is going to be deleted.
				Pattern is checking if the input format is correct----*/
				if(s.next().equalsIgnoreCase("story") && s.hasNext("\\d+")){
					int sid = s.nextInt();
					deleteStory(sid);
				}
				else if(s.next().equalsIgnoreCase("task") && s.hasNext("\\d+\\s+\\d+")){
					int sid = s.nextInt();
					int tid = s.nextInt();
					for(int i=0; i<storyList.size(); i++){
						//If the item is in the story list
						if(storyList.get(i).getStoryid() == sid){
							storyList.get(i).deleteTask(tid);
							break;
						}
					}
				}
			}
			else if(s.next().equalsIgnoreCase("complete") && s.hasNext()){
				/*----If the input command line contain COMPLETE
				then turn the story into complete.
				Pattern is checking if the input format is correct----*/
				if(s.next().equalsIgnoreCase("story") && s.hasNextInt()){
					int sid = s.nextInt();
					completeStory(sid);
				}
			}
			else if(s.next().equalsIgnoreCase("move") && s.hasNext()){
				/*----If the input command line contain MOVE
				then basing on story id and task id to find the task Column.
				Pattern is checking if the input format is correct----*/
				if(s.next().equalsIgnoreCase("task") && s.hasNext("\\d+\\s+\\d+\\s+\\w+")){
					int sid = s.nextInt();
					int tid = s.nextInt();
					String col = s.next();
					for(int i=0; i<storyList.size(); i++){
							//If the item is in the story list
							if(storyList.get(i).getStoryid() == sid){
								storyList.get(i).moveTask(tid, col);
								break;
							}
					}
				}
			}
			else if(s.next().equalsIgnoreCase("update") && s.hasNext()){
				/*----If the input command line contain UPDATE
				then basing on story id and task id to find the task Description.
				Pattern is checking if the input format is correct----*/
				if(s.next().equalsIgnoreCase("task") && s.hasNext("\\d+\\s+\\d+\\s+\\w+")){
					int sid = s.nextInt();
					int tid = s.nextInt();
					String des = s.next();
					for(int i=0; i<storyList.size(); i++){
							//If the item is in the story list
							if(storyList.get(i).getStoryid() == sid){
								storyList.get(i).updateTask(tid, des);
								break;
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
