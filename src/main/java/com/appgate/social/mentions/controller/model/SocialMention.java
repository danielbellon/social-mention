package com.appgate.social.mentions.controller.model;

import com.appgate.social.mentions.domain.model.SocialNetwork;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

@Data
public class SocialMention {

	private String message;
	private String facebookAccount;
	private String tweeterAccount;
	private String creationDate;
	private String tweeterUrl;
	private List<String> facebookComments;

	public Optional<SocialNetwork> getSocialNetwork() {

		if (StringUtils.isNotBlank(facebookAccount)) return Optional.of(SocialNetwork.FACEBOOK);
		if (StringUtils.isNotBlank(tweeterAccount)) return Optional.of(SocialNetwork.TWEETER);

		return Optional.empty();
	}
}
