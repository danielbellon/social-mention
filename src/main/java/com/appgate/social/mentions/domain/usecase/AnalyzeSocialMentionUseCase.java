package com.appgate.social.mentions.domain.usecase;

import com.appgate.social.mentions.controller.model.SocialMention;
import com.appgate.social.mentions.domain.model.RiskScore;
import com.appgate.social.mentions.domain.service.strategy.StrategyFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AnalyzeSocialMentionUseCase {

	private final StrategyFactory strategyFactory;

	@Inject
	public AnalyzeSocialMentionUseCase(final StrategyFactory strategyFactory) {

		this.strategyFactory = strategyFactory;
	}

	public RiskScore execute(final SocialMention socialMention) {

		return socialMention
				.getSocialNetwork()
				.map(strategyFactory::getStrategy)
				.map(strategy -> strategy.analyze(socialMention))
				.orElse(RiskScore.UNKNOWN_RISK);
	}
}
