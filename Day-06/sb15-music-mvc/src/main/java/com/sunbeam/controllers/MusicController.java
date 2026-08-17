package com.sunbeam.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.domain.Album;
import com.sunbeam.domain.Song;
import com.sunbeam.models.AlbumCreadentials;
import com.sunbeam.services.MusicService;

@Controller
public class MusicController {
	private MusicService musicService;

	public MusicController(MusicService musicService) {
		this.musicService=musicService;
	}

	@RequestMapping("/album")
	public String showAlbums(Model model) {
		List<Album> albums = musicService.showAlbums();
		model.addAttribute("albums", albums);
		return "albums";
	}

	@RequestMapping("/songManagement")
	public String showAlbumsSongs(AlbumCreadentials ac ,Model model) {
		List<Song>songs = musicService.showAlbumSongs(ac);
		model.addAttribute("songs", songs);
		return "albumSongs";
	}
}
