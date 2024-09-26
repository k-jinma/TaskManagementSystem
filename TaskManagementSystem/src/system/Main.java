package system;

import java.util.Scanner;

import data.Task;

public class Main {

	public static void main(String[] args) {
		
		// １．終了できるようにしてください
		// ２．タスクを配列で管理してください（2作成、1表示）
		
		Task[] tasks = new Task[100];

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
			if (input == 1) {
				if( tasks[0] != null) {
					System.out.println("タスク一覧表示");
					
					// 拡張forの場合
					for( Task t : tasks ) {
						if( t != null) {
							System.out.print(t.getNo());
							
						}
						
					}
					
					for( int i = 0; i < tasks.length; i++ ) {
						if( tasks[i] != null ) {
							System.out.print(tasks[i].getNo());
							System.out.print( " " + tasks[i].getTaskName());
							System.out.print( " " + tasks[i].getTimeLimit1());
							System.out.print( " " + tasks[i].getTimeLimit2());
							System.out.print( " " + tasks[i].getComp());
							System.out.println(); //改行
							
						}
						
					}
					
				}else {
					System.out.println("タスクがありません");
				}
				

			} else if (input == 2) {
				System.out.println("タスク作成");
				
				System.out.print("No入力：");
				int no = sc.nextInt();
				sc.nextLine(); //改行を捨てる
				
				String taskName = sc.nextLine();
				
				//宿題1：残りの部分も入力できるようにする
				//宿題2：100件以上作れないようにする
				
				for( int i = 0; i < tasks.length; i++ ) {
					if( tasks[i] == null ) {
						tasks[i] = new Task(no, taskName, "2024/9/20", "15:00", "済");
						break;
					}
				}
				

			} else if (input == 3) {
				System.out.println("タスク修正");

			} else if (input == 4) {
				System.out.println("タスク削除");

			} else if( input == 5 ){
				System.out.println("終了します");
				return;
			}
		} while (true);
		
		
		
	}

}
