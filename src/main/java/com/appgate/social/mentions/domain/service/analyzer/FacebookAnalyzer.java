package com.appgate.social.mentions.domain.service.analyzer;

import java.util.Collection;

public interface FacebookAnalyzer {

	Double calculateFacebookCommentsScore(Collection<String> comments);

	Double analyzePost(String message, String account);
}
