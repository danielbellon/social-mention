package com.appgate.social.mentions.domain.service;

import com.appgate.social.mentions.domain.model.RiskScore;

public class FacebookScoreAdapter implements RiskScoreAdapter {

	@Override
	public RiskScore adapt(double score) {

		if (score == -100d) {
			return RiskScore.HIGH_RISK;
		} else if (score > -100d && score < 50d) {
			return RiskScore.MEDIUM_RISK;
		} else if (score >= 50d) {
			return RiskScore.LOW_RISK;
		} else {
			return RiskScore.UNKNOWN_RISK;
		}
	}
}
