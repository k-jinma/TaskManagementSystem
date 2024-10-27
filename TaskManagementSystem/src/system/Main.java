package system;

import java.util.ArrayList;
import java.util.Scanner;

import data.Task;

public class Main {

	public static void main(String[] args) {
		
		// １．終了できるようにしてください
		// ２．タスクを配列で管理してください（2作成、1表示）
		
//		int taskCnt = 100;
		
//		Task[] tasks = new Task[taskCnt];
		ArrayList<Task> lists = new ArrayList<>();

		do {
			System.out.println("--------------------");
			System.out.println("1.タスク一覧表示");
			System.out.println("2.タスク作成");
			System.out.println("3.タスク修正");
			System.out.println("4.タスク削除");
			System.out.println("5.終了");
			System.out.println("--------------------");
			System.out.print("入力:");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			sc.nextLine(); //改行を捨てる
			
			if (input == 1) {
				if( lists.size() != 0 ) {
					System.out.println("タスク一覧表示");
					
					System.out.println("---------------------------------------------");
					System.out.printf("%-4s%-10s\n","NO","タスク名");
					System.out.println("---------------------------------------------");
					
					// 拡張forの場合
					for( Task t : lists ) {
						
						//System.out.print(t.getNo() + "  ");
						System.out.printf("%-4d", t.getNo() );
						System.out.printf("%-10s",t.getTaskName() );
						System.out.print(t.getTimeLimit1() + "  ");
						System.out.print(t.getTimeLimit2() + "  ");
						System.out.print(t.getComp() + "  ");
						System.out.println(); //改行
	
					}
					// 通常のforの場合
//					for( int i = 0; i < lists.size(); i++ ) {
//						
//						System.out.print(lists.get(i).getNo());
//						System.out.print(lists.get(i).getTaskName());
//						System.out.print(lists.get(i).getTimeLimit1());
//						System.out.print(lists.get(i).getTimeLimit2());
//						System.out.print( lists.get(i).getComp());
//						System.out.println(); //改行
//						
//					}
					
				}else {
					System.out.println("タスクがありません");
				}
				

			} else if (input == 2) {
				System.out.println("タスク作成");
				
				if (lists.size() == 100) {
					System.out.println("これ以上登録できません");
					continue;
				}
				
//				System.out.print("No入力：");
//				int no = sc.nextInt();
//				sc.nextLine(); //改行を捨てる
				
				System.out.print("タスク名入力：");
				String taskName = sc.nextLine();
				
				System.out.print("期限を入力（yyyyMMdd）：");
				String startDate = sc.nextLine();
				
				System.out.print("期限を入力（hh:mm)：");
				String endTime = sc.nextLine();
				
				//リストにデータがある場合、最後のNoを取得
				//ない場合、1を設定
				int no = 1;
				if (lists.size() > 0) {
					no = lists.getLast().getNo()+1;
				}
				
				Task t = new Task(no, taskName, startDate, endTime, "未");
				lists.add(t);
				

			} else if (input == 3) {
				System.out.println("タスク修正");

			} else if (input == 4) {
				System.out.println("タスク削除");
				
				for( int i = 0, j = 1; i < lists.size(); i++, j++ ) {
					
					System.out.print(j + " : ");
					System.out.print(lists.get(i).getNo());
					System.out.print(lists.get(i).getTaskName());
					System.out.print(lists.get(i).getTimeLimit1());
					System.out.print(lists.get(i).getTimeLimit2());
					System.out.print( lists.get(i).getComp());
					System.out.println(); //改行
					
				}
				
				
				System.out.print("削除するNoを入力：");
				int no = sc.nextInt();
				sc.nextLine(); //改行を捨てる	
				
				// 削除するタスクがありませんのような	メッセージを表示したい
				for (int i = 0; i < lists.size(); i++) {
					if (lists.get(i).getNo() == no) {
						lists.remove(i);
						System.out.println("削除しました");
						break;
					}
				}
				
				

			} else if( input == 5 ){
				System.out.println("終了します");
				return;
			}
		} while (true);
		
		
		
	}

}
