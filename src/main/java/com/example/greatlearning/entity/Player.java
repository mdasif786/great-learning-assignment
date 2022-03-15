package com.example.greatlearning.entity;

import com.example.greatlearning.enums.PlayerStatus;
import com.example.greatlearning.utils.RandomUtils;

/**
 * 
 * @author Md Asif <asifmd786kgn@gmail.com>
 *
 */
public class Player {
	private String id;
	private String name;
	private PlayerStatus status;

	public Player(String name) {
		this.id = RandomUtils.generateRandomUUID();
		this.name = name;
		this.status = PlayerStatus.READY;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PlayerStatus getStatus() {
		return status;
	}

	public void setStatusToPlaying() {
		if (this.status == PlayerStatus.READY) {
			this.status = PlayerStatus.PLAYING;
		}
	}

	public void setStatusToCompleted() {
		if (this.status == PlayerStatus.PLAYING) {
			this.status = PlayerStatus.COMPLETED;
		}
	}

	public void setStatusToInActive() {
		this.status = PlayerStatus.IN_ACTIVE;
	}
}
