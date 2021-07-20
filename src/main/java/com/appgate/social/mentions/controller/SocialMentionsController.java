package com.appgate.social.mentions.controller;

import com.appgate.social.mentions.controller.model.SocialMention;
import com.appgate.social.mentions.domain.usecase.AnalyzeSocialMentionUseCase;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

@Controller
public class SocialMentionsController {

	private final AnalyzeSocialMentionUseCase useCase;

	@Inject
	public SocialMentionsController(AnalyzeSocialMentionUseCase useCase) {

		this.useCase = useCase;
	}

	@Post("/AnalyzeSocialMention")
	@Produces(MediaType.TEXT_PLAIN)
	public String analyze(@Body SocialMention socialMention) {

		return useCase.execute(socialMention).name();
	}
 }
