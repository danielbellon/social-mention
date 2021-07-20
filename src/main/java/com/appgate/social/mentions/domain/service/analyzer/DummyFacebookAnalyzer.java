package com.appgate.social.mentions.domain.service.analyzer;

import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class DummyFacebookAnalyzer implements FacebookAnalyzer {

	@Override
	public Double calculateFacebookCommentsScore(Collection<String> comments) {

		return 0d;
	}

	@Override
	public Double analyzePost(String message, String account) {

		return 0d;
	}
}
