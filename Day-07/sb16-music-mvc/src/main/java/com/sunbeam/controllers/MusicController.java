package com.sunbeam.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.domain.Album;
import com.sunbeam.domain.Song;
import com.sunbeam.models.AlbumCreadentials;
import com.sunbeam.services.MusicService;

@Controller
public class MusicController {
	private MusicService musicService;

	public MusicController(MusicService musicService) {
		this.musicService = musicService;
	}

	@RequestMapping("/album")
	public String showAlbums(Model model) {
		List<Album> albums = musicService.showAlbums();
		model.addAttribute("albums", albums);
		return "albums";
	}

	/*
	 * @RequestMapping("/songManagement") public String
	 * showAlbumsSongs(AlbumCreadentials ac ,Model model) { List<Song>songs =
	 * musicService.showAlbumSongs(ac.getAlbumId()); model.addAttribute("songs",
	 * songs); return "albumSongs"; }
	 */
	// Writing POJO for the "one request parameter" is insufficient
	// So use @RequestParameter for that
	// But for "multiple request parameter" - Use POJO
	@RequestMapping("/songManagement")
	public String showAlbumSongs(Model model, @RequestParam("albumId") int id) {
		List<Song> songs = musicService.showAlbumSongs(id);
		model.addAttribute("songs", songs);

		return "albumSongs";
	}
}
