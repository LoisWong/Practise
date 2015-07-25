package taskboard;

import java.util.Scanner;

public class ASTB {
	public static void main(String[] args){
		TaskBoard tb = TaskBoard.getInstance();
		try {
			Scanner sn = new Scanner(System.in);
			sn.useDelimiter("\\s+");
			String cmd = sn.next();
			while (!cmd.equalsIgnoreCase("exit") && sn.hasNext()){
				String item = sn.next();
				
				if (cmd.equalsIgnoreCase("create")){
					if (item.equalsIgnoreCase("story")){
						while (!sn.hasNextInt()){
							System.out.println("Input story id with number");
							sn.next();
						}
						int sid = sn.nextInt(); 
						if (sn.hasNext()){
							String sDes = sn.next();
							tb.createStory(sid, sDes);
						}else tb.createStory(sid, "NULL");
					}else if (item.equalsIgnoreCase("task")){
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
							tb.createTask(sid,tid,tDes);
						}else tb.createTask(sid, tid, "NULL");
					}else System.out.println("create error"); 
				}
				else if (cmd.equalsIgnoreCase("list")){
					if (item.equalsIgnoreCase("story")){
						tb.listStory();
					}else if (item.equalsIgnoreCase("task")){
						while (!sn.hasNextInt()){
							System.out.println("Input story id for list its tasks");
							sn.next();
						}
						int sid = sn.nextInt(); 
						tb.listTask(sid);
					}
				}
				else if (cmd.equalsIgnoreCase("delete")){
					if (item.equalsIgnoreCase("story")){
						while (!sn.hasNextInt()){
							System.out.println("Input story id for list its tasks");
							sn.next();
						}
						int sid = sn.nextInt(); 
						tb.deleteStory(sid);
					}else if (item.equalsIgnoreCase("task")){
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
					}else System.out.println("delete error"); 
				}
				else if (cmd.equalsIgnoreCase("complete")){
					if (item.equalsIgnoreCase("story")){
						while (!sn.hasNextInt()){
							System.out.println("Input story id for list its tasks");
							sn.next();
						}
						int sid = sn.nextInt(); 
						tb.completeStory(sid);
					}else System.out.println("complete operation error");
				}
				else if (cmd.equalsIgnoreCase("move")){
					if (item.equalsIgnoreCase("task")){
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
						String col = sn.nextLine();
						tb.moveTask(sid, tid, col);
					}else System.out.println("Move operation error");
				}
				else if (cmd.equalsIgnoreCase("update")){
					if (item.equalsIgnoreCase("task")){
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
					}else System.out.println("Update operation error");
				}
				else System.out.println("No such operation");
			}
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Building error");
		}
	}
}
