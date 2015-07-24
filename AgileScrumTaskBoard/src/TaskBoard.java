import java.util.ArrayList;


public class TaskBoard {
	private static ArrayList<Story> storyList;
	private static ArrayList<Task> taskList;
	
	public static void main(String[] args){
		try {
			storyList = new ArrayList<Story>();
			taskList = new ArrayList<Task>();
			
			if(args[0].equalsIgnoreCase("create")){
				if(args[1].equalsIgnoreCase("story") && args.length == 4){
					int sid = Integer.parseInt(args[2]);
					String Des = args[3];
					createStory(sid, Des);
				}
				else if(args[1].equalsIgnoreCase("task") && args.length == 5){
					int sid = Integer.parseInt(args[2]);
				}
			}
			else if(args[0].equalsIgnoreCase("list")){
				
			}
			else if(args[0].equalsIgnoreCase("delete")){
				
			}
			else if(args[0].equalsIgnoreCase("complete")){
				
			}
			else if(args[0].equalsIgnoreCase("move")){
				
			}
			else if(args[0].equalsIgnoreCase("update")){
				
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
