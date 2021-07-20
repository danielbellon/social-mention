package com.appgate.social.mentions.domain.service;

import com.appgate.social.mentions.domain.model.RiskScore;

/**
 * @author <a href="mailto:daniel.bellon@payulatam.com"> Daniel Bellón </a>
 * @since
 */
public interface RiskScoreAdapter {

	RiskScore adapt(double score);
}
