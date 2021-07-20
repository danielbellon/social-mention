package com.appgate.social.mentions.domain.service.strategy;

import com.appgate.social.mentions.controller.model.SocialMention;
import com.appgate.social.mentions.domain.model.RiskScore;
import com.appgate.social.mentions.domain.model.SocialNetwork;
import com.appgate.social.mentions.domain.service.adapter.RiskScoreAdapter;
import com.appgate.social.mentions.domain.service.analyzer.TweeterAnalyzer;
import com.appgate.social.mentions.repository.TweetsAnalysisRepository;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import static com.appgate.social.mentions.domain.model.SocialNetwork.TWEETER;

@Slf4j
@Singleton
public class TweeterStrategy implements SocialMentionAnalysisStrategy {

	private final TweetsAnalysisRepository repository;
	private final TweeterAnalyzer analyzer;
	private final RiskScoreAdapter adapter;

	@Inject
	public TweeterStrategy(
			final TweetsAnalysisRepository repository,
			final TweeterAnalyzer analyzer,
			@Named("TweeterScoreAdapter") final RiskScoreAdapter adapter) {

		this.repository = repository;
		this.analyzer = analyzer;
		this.adapter = adapter;
	}

	@Override
	public SocialNetwork name() {

		return TWEETER;
	}

	@Override
	public RiskScore analyze(SocialMention socialMention) {

		log.debug("Using Tweeter Strategy to analyze incoming social mention: [{}]", socialMention);

		var score = analyzer.analyzeTweet(
				socialMention.getMessage(),
				socialMention.getTweeterUrl(),
				socialMention.getFacebookAccount());

		repository.save(
				score,
				socialMention.getMessage(),
				socialMention.getTweeterUrl(),
				socialMention.getTweeterAccount());

		return adapter.adapt(score);
	}
}
