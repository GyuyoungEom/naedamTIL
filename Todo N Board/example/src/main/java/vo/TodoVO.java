package vo;

public class TodoVO {
	private int todoNum;
	private int id;
	private String pwd;
	private String content;
	private String writeDate;
	private String limitDate;
	private boolean checkBox;
	
	public int getTodoNum() {
		return todoNum;
	}
	public void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	public boolean isCheckBox() {
		return checkBox;
	}
	public void setCheckBox(boolean checkBox) {
		this.checkBox = checkBox;
	}
	@Override
	public String toString() {
		return "TodoVO [todoNum=" + todoNum + ", id=" + id + ", pwd=" + pwd + ", content=" + content + ", writeDate="
				+ writeDate + ", limitDate=" + limitDate + ", checkBox=" + checkBox + "]";
	}
}
