package com.appgate.social.mentions.domain.service.strategy;

import com.appgate.social.mentions.controller.model.SocialMention;
import com.appgate.social.mentions.domain.model.RiskScore;
import com.appgate.social.mentions.domain.model.SocialNetwork;

public interface SocialMentionAnalysisStrategy {

	SocialNetwork name();

	RiskScore analyze(SocialMention socialMention);
}
