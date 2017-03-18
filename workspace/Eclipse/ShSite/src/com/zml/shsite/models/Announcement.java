package com.zml.shsite.models;

import java.sql.Timestamp;

/**
 * Announcement entity. @author MyEclipse Persistence Tools
 */

public class Announcement implements java.io.Serializable {

	// Fields

	private Integer announcementId;
	private String annoContent;
	private Timestamp annoTime;
	private String announceTitle;
	
	// Constructors

	/** default constructor */
	public Announcement() {
	}

	/** full constructor */
	public Announcement(String annoContent, Timestamp annoTime, String announceTitle) {
		this.annoContent = annoContent;
		this.annoTime = annoTime;
		this.announceTitle = announceTitle;
	}

	// Property accessors

	public Integer getAnnouncementId() {
		return this.announcementId;
	}

	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}

	public String getAnnoContent() {
		return this.annoContent;
	}

	public void setAnnoContent(String annoContent) {
		this.annoContent = annoContent;
	}

	public Timestamp getAnnoTime() {
		return this.annoTime;
	}

	public void setAnnoTime(Timestamp annoTime) {
		this.annoTime = annoTime;
	}

	public String getAnnounceTitle() {
		return this.announceTitle;
	}

	public void setAnnounceTitle(String announceTitle) {
		this.announceTitle = announceTitle;
	}

}