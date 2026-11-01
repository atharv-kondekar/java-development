package com.sunbeam;


import java.util.List;

import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class MoiveController {

	private final MovieAiService movieAiService;

	MoiveController(MovieAiService movieAiService) {
		this.movieAiService = movieAiService;
	}

	@GetMapping("/movie")
	public MovieInfo getInfo(@RequestParam String movie) {
		return movieAiService.getMovieInfo(movie);
	}

	@GetMapping("/movielist")
	public List<MovieInfo> getList( @RequestParam String desc ,@RequestParam int count){
		return movieAiService.giveMovieList(desc, count);
	}

	@GetMapping("/moviechatinfo")
	public ResponseEntity<ChatResponse,MovieInfo> getMovieEntity(@RequestParam String movie){
		return movieAiService.getMovieChatInfo(movie);
	}
}
