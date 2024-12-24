package system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.Task;

public class Main {

	public static void main(String[] args) {
		
		// ファイルの書き込みは３つのクラスを使う
		// 1. File
		// 2. FileWriter
		// 3. BufferedWriter
		
		// ファイルの読み込みは３つのクラスを使う
		// 1. File
		// 2. FileReader
		// 3. BufferedReader
		
		ArrayList<Task> lists = new ArrayList<>();
		File file = new File("data.csv");
		FileWriter fw;
		BufferedWriter bw;
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] a = line.split(",");
				Task t = new Task(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4]);
				//Task.TaskSu++;
				lists.add(t);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		


		Scanner sc = new Scanner(System.in); // System.in = 標準入力(キーボード)からの入力
		
		do {
			System.out.println("--------------------");
			System.out.println("1.タスク一覧表示");
			System.out.println("2.タスク完了");
			System.out.println("3.タスク作成");
			System.out.println("4.タスク修正");
			System.out.println("5.タスク削除");
			System.out.println("9.終了");
			System.out.println("--------------------");
			System.out.print("入力:");
			
			try {
				int input = sc.nextInt();
				sc.nextLine(); //改行までを捨てる
				
				if (input == 1) {
					
					if (lists.size() == 0) {
						System.out.println("タスクがありません");
						continue;
					}
					
					// 11/30宿題　リストにある全てのタスク一覧表示をする
					for (int i = 0; i < lists.size(); i++) {
						System.out.print(i + 1 + "：" + lists.get(i).getTaskName() + " " +  lists.get(i).getComp() + " " + lists.get(i).getTimeLimit1() + " " + lists.get(i).getTimeLimit2() + "\n");
						
					}
					
					
				} else if (input == 2) {
					
					for (int i = 0; i < lists.size(); i++) {
						
						if (lists.get(i).getComp().equals("済")) {
							continue;
						}
						System.out.println(i+1 + "：" + lists.get(i).getTaskName());
						
					}
					
					System.out.print("完了する番号を入力してください：");
					int no = sc.nextInt();
					sc.nextLine(); //改行までを捨てる
					
					lists.get(no-1).setComp("済");
					
				
				} else if (input == 3) {
					
					System.out.print("タスク名を入力してください:");
					String taskName = sc.nextLine();
					System.out.print("期限（年月日）を入力してください:");
					String timeLimit1 = sc.nextLine();
					System.out.print("時間を入力してください:");
					String timeLimit2 = sc.nextLine();
					
					Task task = new Task( 1,taskName, timeLimit1, timeLimit2, "未");
					lists.add(task);

				} else if (input == 4) {

					
				} else if (input == 5) {
					
					for (int i = 0; i < lists.size(); i++) {
						System.out.println(i+1 + "：" + lists.get(i).getTaskName());
					}
					
					System.out.print("削除する番号を入力してください：");
					int no = sc.nextInt();
					sc.nextLine(); //改行までを捨てる
					
					lists.remove(no-1);
					


				} else if (input == 9) {
					
					fw = new FileWriter(file);
					bw = new BufferedWriter(fw);
					
					
					for (int i = 0; i < lists.size(); i++) {
						bw.write( lists.get(i).getNo() + "," + lists.get(i).getTaskName() + "," + lists.get(i).getTimeLimit1() + ","
								+ lists.get(i).getTimeLimit2() + "," + lists.get(i).getComp() + "\n");
					}
					bw.flush();
					
					System.out.println("終了します");
					break;
					
				} else {
					System.out.println("1～5の数字を入力してください");
					
				}
				
			} catch (Exception e) {
				System.out.println("1～5の数字を入力してください");
				sc.nextLine(); //改行までを捨てる
			}
			
			
		} while (true);
				
		sc.close();
	}

}
