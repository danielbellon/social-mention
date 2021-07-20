package com.appgate.social.mentions.controller;

import com.appgate.social.mentions.controller.model.SocialMention;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

/**
 * @author <a href="mailto:danielbellon77@gmail.com"> Daniel Bellón </a>
 * @since 0.1
 */
@Controller
public class SocialMentionsController {

	@Post("/AnalyzeSocialMention")
	@Produces(MediaType.TEXT_PLAIN)
	public String analyze(@Body SocialMention socialMention) {

		return null;
	}
 }
