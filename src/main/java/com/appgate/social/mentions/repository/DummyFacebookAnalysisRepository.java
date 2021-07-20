package com.appgate.social.mentions.repository;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class DummyFacebookAnalysisRepository implements FacebookAnalysisRepository {

	@Override
	public void save(Double score, String message, String account) {

		log.info("Saving facebook analysis: {}:{}:{}", message, account, score);
	}
}
