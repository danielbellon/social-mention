package com.appgate.social.mentions.domain.service.analyzer;

import javax.inject.Singleton;

@Singleton
public class DummyTweeterAnalyzer implements TweeterAnalyzer {

	@Override
	public Double analyzeTweet(String message, String tweetUrl, String account) {

		return 0d;
	}
}
