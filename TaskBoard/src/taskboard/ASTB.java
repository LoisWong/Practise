package taskboard;

import java.util.Scanner;

public class ASTB {
	public static void main(String[] args){
		TaskBoard tb = TaskBoard.getInstance();
		try {
			//Initialize scanner to get input from command-line
			Scanner sn = new Scanner(System.in);
			String cmd = "Null";
			String item = "Null";
			
			//Jump out recursive when getting exit command
			while (!cmd.equalsIgnoreCase("exit") && !item.isEmpty()){
				sn.useDelimiter("\\s+");
				cmd = sn.next();
				item = sn.next();
				
				/*----If the input command line contain CREATE
				then check what kind of data is going to be created.
				Checking if the input format is correct before execute----*/
				if (cmd.equalsIgnoreCase("create")){
					if (item.equalsIgnoreCase("story")){
						//Getting id and description to create story
						while (!sn.hasNextInt()){
							System.out.println("Input story id with number, and description");
							sn.next();
						}
						int sid = sn.nextInt(); 
						if (sn.hasNext()){
							String sDes = sn.next();
							tb.createStory(sid, sDes);
						}else tb.createStory(sid, "NULL");
					}else if (item.equalsIgnoreCase("task")){
						//Getting story id, task id and description to create task
						while (!sn.hasNextInt()){
							System.out.println("Input story id with number");
							sn.next();
						}
						int sid = sn.nextInt(); 
						while (!sn.hasNextInt()){
							System.out.println("Input task id with number, and description");
							sn.next();
						}
						int tid = sn.nextInt();
						if (sn.hasNext()){
							String tDes = sn.next();
							tb.createTask(sid,tid,tDes);
						}else tb.createTask(sid, tid, "NULL");
					}else {
						//If not create story or task, return error
						System.out.println("create error"); 
					}
				}
				/*----If the input command line contain LIST
				then check what kind of data is going to be listed.----*/
				else if (cmd.equalsIgnoreCase("list")){
					if (item.equalsIgnoreCase("stories")){
						tb.listStory();
					}else if (item.equalsIgnoreCase("tasks")){
						//Getting story id to list tasks
						while (!sn.hasNextInt()){
							System.out.println("Input story id for list its tasks");
							sn.next();
						}
						int sid = sn.nextInt(); 
						tb.listTask(sid);
					}else {
						//If not list story or task, return error
						System.out.println("list error"); 
					}
				}
				/*----If the input command line contain DELETE
				then check what kind of data is going to be deleted.
				Checking if the input format is correct before execute----*/
				else if (cmd.equalsIgnoreCase("delete")){
					if (item.equalsIgnoreCase("story")){
						//Getting story id to delete story
						while (!sn.hasNextInt()){
							System.out.println("Input story id for list its tasks");
							sn.next();
						}
						int sid = sn.nextInt(); 
						tb.deleteStory(sid);
					}else if (item.equalsIgnoreCase("task")){
						//Getting story id and task id to delete task
						while (!sn.hasNextInt()){
							System.out.println("Input story id with number");
							sn.next();
						}
						int sid = sn.nextInt(); 
						while (!sn.hasNextInt()){
							System.out.println("Input task id with number");
							sn.next();
						}
						int tid = sn.nextInt();
						tb.deleteTask(sid, tid);
					}else {
						//If not delete story or task, return error
						System.out.println("delete error"); 
					}
				}
				/*----If the input command line contain COMPLETE
				then check if the story can be marked as complete.
				Checking if the input format is correct before execute----*/
				else if (cmd.equalsIgnoreCase("complete")){
					if (item.equalsIgnoreCase("story")){
						while (!sn.hasNextInt()){
							//Getting story id to check its tasks status
							System.out.println("Input story id for list its tasks");
							sn.next();
						}
						int sid = sn.nextInt(); 
						tb.completeStory(sid);
					}else {
						//If not operate a story, return error
						System.out.println("complete operation error");
					}
				}
				/*----If the input command line contain MOVE
				then basing on story id and task id to find the task Column.
				Checking if the input format is correct before execute----*/
				else if (cmd.equalsIgnoreCase("move")){
					if (item.equalsIgnoreCase("task")){
						//Getting story id, task id, and new column to move
						while (!sn.hasNextInt()){
							System.out.println("Input story id with number");
							sn.next();
						}
						int sid = sn.nextInt(); 
						while (!sn.hasNextInt()){
							System.out.println("Input task id with number");
							sn.next();
						}
						int tid = sn.nextInt();
						while (!sn.hasNext()){
							System.out.println("Input the new column");
						}
						String col = sn.nextLine().trim();
						//System.out.println(col);
						tb.moveTask(sid, tid, col);
					}else {
						//If not move a task, then return error
						System.out.println("Move operation error");
					}
				}
				/*----If the input command line contain UPDATE
				then basing on story id and task id to find the task Description.
				Pattern is checking if the input format is correct----*/
				else if (cmd.equalsIgnoreCase("update")){
					if (item.equalsIgnoreCase("task")){
						//Getting story id, task id, and new description to update
						while (!sn.hasNextInt()){
							System.out.println("Input story id with number");
							sn.next();
						}
						int sid = sn.nextInt(); 
						while (!sn.hasNextInt()){
							System.out.println("Input task id with number");
							sn.next();
						}
						int tid = sn.nextInt();
						if (sn.hasNext()){
							String tDes = sn.next();
							tb.updateTask(sid, tid, tDes);
						}else tb.updateTask(sid, tid, "NULL");
					}else {
						//If not update a task, then return error
						System.out.println("Update operation error");
					}
				}
				else {
					//If the command is illegal,return error
					System.out.println("No such operation");
				}
			}
			//Inform exit
			System.out.println("Finish Operation");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Building error");
		}
	}//End of main
}//End of ASTB
