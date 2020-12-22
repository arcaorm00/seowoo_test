package ino.web.freeBoard.dto;

import org.apache.ibatis.type.Alias;

@Alias("freeBoardDto")
public class FreeBoardDto {

	private String codeType;
	private int num;
	private String title;
	private String name;
	private String regdate;
	private String content;
	private int readcnt;

	public FreeBoardDto() {}

	
	public FreeBoardDto(String codeType, int num, String title, String name, String regdate, String content,
			int readcnt) {
		super();
		this.codeType = codeType;
		this.num = num;
		this.title = title;
		this.name = name;
		this.regdate = regdate;
		this.content = content;
		this.readcnt = readcnt;
	}


	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	@Override
	public String toString() {
		return "FreeBoardDto [num=" + num + ", title=" + title + ", name=" + name + ", regdate=" + regdate
				+ ", content=" + content + ", readcnt=" + readcnt + "]";
	}

}
