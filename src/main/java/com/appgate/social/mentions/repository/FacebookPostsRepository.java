package com.appgate.social.mentions.repository;

public interface FacebookPostsRepository {

	void save(Double score, String message, String account);
}
