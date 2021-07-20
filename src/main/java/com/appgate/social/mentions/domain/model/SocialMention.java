package com.appgate.social.mentions.domain.model;

import lombok.Data;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since
 */
@Data
public class SocialMention {

	private String message;
	private String account;
	private String creationDate;

}
