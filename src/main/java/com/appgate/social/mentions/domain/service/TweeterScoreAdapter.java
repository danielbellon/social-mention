package com.appgate.social.mentions.domain.service;

import com.appgate.social.mentions.domain.model.RiskScore;

public class TweeterScoreAdapter implements RiskScoreAdapter {

	@Override public RiskScore adapt(double score) {

		if (score >= -1 && score <= -0.5d) {
			return RiskScore.HIGH_RISK;
		} else if (score > -0.5d && score < 0.7d) {
			return RiskScore.MEDIUM_RISK;
		} else if (score >= 0.7d) {
			return RiskScore.LOW_RISK;
		} else {
			return RiskScore.UNKNOWN_RISK;
		}
	}
}
