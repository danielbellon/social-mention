package com.appgate.social.mentions.repository;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class DummyTweetsRepository implements TweetsAnalysisRepository {

	@Override
	public void save(Double score, String message, String url, String account) {

		log.info("Saving Tweets analysis repository: {}:{}:{}:{}", score, message, url, account);
	}
}
