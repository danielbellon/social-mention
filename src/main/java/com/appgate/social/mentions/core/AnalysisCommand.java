package com.appgate.social.mentions.core;

import com.appgate.social.mentions.controller.model.SocialMention;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since
 */
@Data
@Builder(setterPrefix = "with")
public class AnalysisCommand {

	private SocialNetwork socialNetwork;
	private String message;
	private Date creationDate;

	public static AnalysisCommand from(SocialMention socialMention) {

		return AnalysisCommand
				.builder()
				.build();
	}
}
