package com.appgate.social.mentions.repository;

public interface FacebookAnalysisRepository {

	void save(Double score, String message, String account);
}
