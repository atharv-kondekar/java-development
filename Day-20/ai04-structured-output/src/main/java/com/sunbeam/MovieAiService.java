package com.sunbeam;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class MovieAiService {

	private ChatClient chatClient;

	public MovieAiService(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	public MovieInfo getMovieInfo(String movieName) {
		MovieInfo info = chatClient
			.prompt()
			.user( prompt -> prompt
					.text("Give me the Information of the {movie}")
					.param("movie", movieName)
				)
			.call()
			.entity( MovieInfo.class ,
					spec -> spec
						.useProviderStructuredOutput()  // not works for the groq.com
						.validateSchema()
					);

		return info;
	}

	public List<MovieInfo> giveMovieList(String description , int count) {
		List<MovieInfo> list= chatClient
			.prompt()
			.user( prompt -> prompt
					.text("Give me information of {count} movies. Choose movies like: {description}")
					.param("count", count)
					.param("description", description)
					)
			.call()
			//.entity( MovieInfo.class , // We can't use here
			.entity( new ParameterizedTypeReference<List<MovieInfo> >() {},
						spec -> spec
							.useProviderStructuredOutput()
							.validateSchema()
					);

		return list;
	}

	public ResponseEntity<ChatResponse,MovieInfo> getMovieChatInfo(String movie) {

		ResponseEntity<ChatResponse,MovieInfo>  response =
			chatClient
			.prompt()
			.user( prompt -> prompt
					.text("Give me information of this {movie}")
					.param("movie", movie)
					)
			.call()
			.responseEntity( MovieInfo.class ,
					spec -> spec
						.useProviderStructuredOutput()
						.validateSchema()

					);

		return response;
	}
}
