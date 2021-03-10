package me.jeeneee.springboot.config.auth.dto;

import java.io.Serializable;

import lombok.Getter;
import me.jeeneee.springboot.domain.user.User;

@Getter
public class SessionUser implements Serializable {

	private final String name;
	private final String email;
	private final String picture;

	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
}
