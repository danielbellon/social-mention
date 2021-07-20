package com.appgate.social.mentions.domain.usecase;

import com.appgate.social.mentions.domain.service.RiskScoreAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SocialMentionAnalyzer {

	private final RiskScoreAdapter riskScoreAdapter;
}
