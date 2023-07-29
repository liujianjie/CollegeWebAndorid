package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private Integer roomId;
	private Integer roomNum;
	private String roomName;
	private Integer roomState;
	private Set roomOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(Integer roomNum, String roomName, Integer roomState) {
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomState = roomState;
	}

	/** full constructor */
	public Room(Integer roomNum, String roomName, Integer roomState, Set roomOrders) {
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.roomState = roomState;
		this.roomOrders = roomOrders;
	}

	// Property accessors

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getRoomState() {
		return this.roomState;
	}

	public void setRoomState(Integer roomState) {
		this.roomState = roomState;
	}

	public Set getRoomOrders() {
		return this.roomOrders;
	}

	public void setRoomOrders(Set roomOrders) {
		this.roomOrders = roomOrders;
	}

}