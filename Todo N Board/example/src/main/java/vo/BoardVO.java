package vo;

import java.sql.Date;

public class BoardVO {
	private int boardNum;
	private String id;
	private String content;
	private Date writeDate;
	private String title;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", id=" + id + ", content=" + content + ", writeDate=" + writeDate
				+ ", title=" + title + "]";
	}
}
