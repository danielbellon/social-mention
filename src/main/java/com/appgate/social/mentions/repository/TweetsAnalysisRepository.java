package com.appgate.social.mentions.repository;

public interface TweetsAnalysisRepository {

	void save(Double score, String message, String url, String account);
}
