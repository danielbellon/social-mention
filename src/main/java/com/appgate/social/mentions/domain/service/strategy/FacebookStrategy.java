package com.appgate.social.mentions.domain.service.strategy;

import com.appgate.social.mentions.controller.model.SocialMention;
import com.appgate.social.mentions.domain.model.RiskScore;
import com.appgate.social.mentions.domain.model.SocialNetwork;
import com.appgate.social.mentions.domain.service.adapter.RiskScoreAdapter;
import com.appgate.social.mentions.domain.service.analyzer.FacebookAnalyzer;
import com.appgate.social.mentions.repository.FacebookPostsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

import static com.appgate.social.mentions.domain.model.RiskScore.LOW_RISK;
import static com.appgate.social.mentions.domain.model.SocialNetwork.FACEBOOK;

@Singleton
public class FacebookStrategy implements SocialMentionAnalysisStrategy {

	private final FacebookAnalyzer analyzer;
	private final FacebookPostsRepository repository;
	private final RiskScoreAdapter adapter;

	@Inject
	public FacebookStrategy(
			final FacebookAnalyzer analyzer,
			final FacebookPostsRepository repository,
			final RiskScoreAdapter adapter) {

		this.analyzer = analyzer;
		this.repository = repository;
		this.adapter = adapter;
	}

	@Override
	public SocialNetwork getStrategyName() {

		return FACEBOOK;
	}

	@Override
	public RiskScore analyze(SocialMention socialMention) {

		var score = getCommentsScore(socialMention);

		if (score > -100d) {
			score = getPostScore(socialMention);
		}

		repository.save(
				score,
				socialMention.getMessage(),
				socialMention.getFacebookAccount());

		return adapter.adapt(score);
	}

	private double getCommentsScore(SocialMention socialMention) {

		return Optional
				.ofNullable(socialMention.getFacebookComments())
				.map(analyzer::calculateFacebookCommentsScore)
				.orElse(0d);
	}

	private double getPostScore(SocialMention socialMention) {

		return analyzer.analyzePost(
				socialMention.getMessage(),
				socialMention.getFacebookAccount());
	}
}
