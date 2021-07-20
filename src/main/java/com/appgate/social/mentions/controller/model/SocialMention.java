package com.appgate.social.mentions.controller.model;

import lombok.Data;

import java.util.List;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 0.1
 */
@Data
public class SocialMention {

	private String message;
	private String facebookAccount;
	private String tweeterAccount;
	private String creationDate;
	private String tweeterUrl;
	private List<String> facebookComments;


}
