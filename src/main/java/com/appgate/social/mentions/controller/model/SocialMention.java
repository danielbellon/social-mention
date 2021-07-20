package com.appgate.social.mentions.controller.model;

import com.appgate.social.mentions.domain.model.SocialNetwork;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data
public class SocialMention {

	private String message;
	private String facebookAccount;
	private String tweeterAccount;
	private String creationDate;
	private String tweeterUrl;
	private List<String> facebookComments;

	public SocialNetwork getSocialNetwork() {

		if (StringUtils.isNotBlank(facebookAccount)) return SocialNetwork.FACEBOOK;
		if (StringUtils.isNotBlank(tweeterAccount)) return SocialNetwork.TWEETER;
		return SocialNetwork.UNKNOWN;
	}
}
