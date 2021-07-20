package com.appgate.social.mentions.domain.service.strategy;

import com.appgate.social.mentions.domain.model.SocialNetwork;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

@Singleton
public class StrategyFactory {

	private final Map<SocialNetwork, SocialMentionAnalysisStrategy> strategies;

	@Inject
	public StrategyFactory(final Collection<SocialMentionAnalysisStrategy> strategies) {

		this.strategies = new EnumMap<>(SocialNetwork.class);
		strategies.forEach(strategy -> this.strategies.put(strategy.name(), strategy));
	}

	public SocialMentionAnalysisStrategy getStrategy(SocialNetwork socialNetwork) {

		return strategies.get(socialNetwork);
	}
}
