package com.appgate.social.mentions.repository;

public interface TweetsRepository {

	void save(Double score, String message, String url, String account);
}
