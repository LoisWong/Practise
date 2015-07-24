import java.util.ArrayList;


public class TaskBoard {
	private static ArrayList<Story> storyList;
	
	public static void main(String[] args){
		try {
			storyList = new ArrayList<Story>();
			
			if(args[0].equalsIgnoreCase("create")){
				if(args[1].equalsIgnoreCase("story") && args.length == 4){
					int sid = Integer.parseInt(args[2]);
					String Des = args[3];
					createStory(sid, Des);
				}
				else if(args[1].equalsIgnoreCase("task") && args.length == 5){
					int sid = Integer.parseInt(args[2]);
					int tid = Integer.parseInt(args[3]);
					int i = 0;
					while(i<storyList.size()){
						//If the item is in the story list
						if(storyList.get(i).getStoryid() == sid){
							storyList.get(i).createTask(tid, args[4]);
							break;
						}
						i++;
					}
					if(i == storyList.size()){
						Story ns = new Story(sid);
						ns.createTask(tid, args[4]);
						storyList.add(ns);
					}
				}
			}
			else if(args[0].equalsIgnoreCase("list")){
				if(args[1].equalsIgnoreCase("story")){
					listStory();
				}
				else if(args[1].equalsIgnoreCase("task") && args.length == 3){
					int sid = Integer.parseInt(args[2]);
					for(int i=0; i<storyList.size(); i++){
						//If the item is in the story list
						if(storyList.get(i).getStoryid() == sid){
							storyList.get(i).listTask();
							break;
						}
					}
				}
			}
			else if(args[0].equalsIgnoreCase("delete")){
				if(args[1].equalsIgnoreCase("story") && args.length == 3){
					int sid = Integer.parseInt(args[2]);
					deleteStory(sid);
				}
				else if(args[1].equalsIgnoreCase("task") && args.length == 4){
					int sid = Integer.parseInt(args[2]);
					int tid = Integer.parseInt(args[3]);
					for(int i=0; i<storyList.size(); i++){
						//If the item is in the story list
						if(storyList.get(i).getStoryid() == sid){
							storyList.get(i).deleteTask(tid);
							break;
						}
					}
				}
			}
			else if(args[0].equalsIgnoreCase("complete")){
				if(args[1].equalsIgnoreCase("story") && args.length == 3){
					int sid = Integer.parseInt(args[2]);
					completeStory(sid);
				}
			}
			else if(args[0].equalsIgnoreCase("move")){
				if(args[1].equalsIgnoreCase("task") && args.length == 5){
					int sid = Integer.parseInt(args[2]);
					int tid = Integer.parseInt(args[3]);
					for(int i=0; i<storyList.size(); i++){
							//If the item is in the story list
							if(storyList.get(i).getStoryid() == sid){
								storyList.get(i).moveTask(tid, args[4]);
								break;
							}
					}
				}
			}
			else if(args[0].equalsIgnoreCase("update")){
				if(args[1].equalsIgnoreCase("task") && args.length == 5){
					int sid = Integer.parseInt(args[2]);
					int tid = Integer.parseInt(args[3]);
					for(int i=0; i<storyList.size(); i++){
							//If the item is in the story list
							if(storyList.get(i).getStoryid() == sid){
								storyList.get(i).updateTask(tid, args[4]);
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
