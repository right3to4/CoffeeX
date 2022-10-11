package com.coffeex.dto;

public class NoticeDto {
	int noticeid;
	int noticestaffid;
	String noticetitle;
	String noticetext;
	String noticeinsertdate;
	String noticeupdatedate;
	String noticedeletedate;

	public NoticeDto() {

	}

	public NoticeDto(int noticeid, String noticetitle, String noticeinsertdate, String noticeupdatedate) {
		super();
		this.noticeid = noticeid;
		this.noticetitle = noticetitle;
		this.noticeinsertdate = noticeinsertdate;
		this.noticeupdatedate = noticeupdatedate;
	}
	
	
	
	public NoticeDto(int noticeid, String noticetitle, String noticetext, String noticeinsertdate,String noticeupdatedate) {
		super();
		this.noticeid = noticeid;
		this.noticetitle = noticetitle;
		this.noticetext = noticetext;
		this.noticeinsertdate = noticeinsertdate;
		this.noticeupdatedate = noticeupdatedate;
	}

	public int getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}

	public int getNoticestaffid() {
		return noticestaffid;
	}

	public void setNoticestaffid(int noticestaffid) {
		this.noticestaffid = noticestaffid;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	public String getNoticetext() {
		return noticetext;
	}

	public void setNoticetext(String noticetext) {
		this.noticetext = noticetext;
	}

	public String getNoticeinsertdate() {
		return noticeinsertdate;
	}

	public void setNoticeinsertdate(String noticeinsertdate) {
		this.noticeinsertdate = noticeinsertdate;
	}

	public String getNoticeupdatedate() {
		return noticeupdatedate;
	}

	public void setNoticeupdatedate(String noticeupdatedate) {
		this.noticeupdatedate = noticeupdatedate;
	}

	public String getNoticedeletedate() {
		return noticedeletedate;
	}

	public void setNoticedeletedate(String noticedeletedate) {
		this.noticedeletedate = noticedeletedate;
	}

}
