package com.appgate.social.mentions.domain.service.strategy;

import com.appgate.social.mentions.controller.model.SocialMention;
import com.appgate.social.mentions.domain.model.RiskScore;
import com.appgate.social.mentions.domain.model.SocialNetwork;
import com.appgate.social.mentions.domain.service.adapter.RiskScoreAdapter;
import com.appgate.social.mentions.domain.service.analyzer.FacebookAnalyzer;
import com.appgate.social.mentions.repository.FacebookAnalysisRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;

import static com.appgate.social.mentions.domain.model.SocialNetwork.FACEBOOK;

@Singleton
public class FacebookStrategy implements SocialMentionAnalysisStrategy {

	private final FacebookAnalyzer analyzer;
	private final FacebookAnalysisRepository repository;
	private final RiskScoreAdapter adapter;

	@Inject
	public FacebookStrategy(
			final FacebookAnalyzer analyzer,
			final FacebookAnalysisRepository repository,
			@Named("FacebookScoreAdapter") final RiskScoreAdapter adapter) {

		this.analyzer = analyzer;
		this.repository = repository;
		this.adapter = adapter;
	}

	@Override
	public SocialNetwork name() {

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
