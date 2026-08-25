package com.sunbeam.albums.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.albums.dto.AlbumResponseDTO;
import com.sunbeam.albums.services.AlbumService;
import com.sunbeam.users.utils.ApiResponse;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}

	@GetMapping
	public ApiResponse<List<AlbumResponseDTO>> getAllAlbums() {
		return ApiResponse.success( albumService.findAll());
	}
}
