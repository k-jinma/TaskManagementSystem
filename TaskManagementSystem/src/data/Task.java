package data;

public class Task {

	private int no; //No
	private String taskName; //タスク名
	private String timeLimit1; //期限（年月日）
	private String timeLimit2; //時間
	private String comp; //済, 未
	
	
	public Task(int no, String taskName, String timeLimit1, String timeLimit2, String comp) {
		super();
		this.no = no;
		this.taskName = taskName;
		this.timeLimit1 = timeLimit1;
		this.timeLimit2 = timeLimit2;
		this.comp = comp;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTimeLimit1() {
		return timeLimit1;
	}
	public void setTimeLimit1(String timeLimit1) {
		this.timeLimit1 = timeLimit1;
	}
	public String getTimeLimit2() {
		return timeLimit2;
	}
	public void setTimeLimit2(String timeLimit2) {
		this.timeLimit2 = timeLimit2;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	
	
}
