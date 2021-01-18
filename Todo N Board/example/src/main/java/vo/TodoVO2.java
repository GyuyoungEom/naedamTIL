package vo;

public class TodoVO2 {
	private int id;
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContents(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "TodoVO2 [id=" + id + ", content=" + content + "]";
	}
}
