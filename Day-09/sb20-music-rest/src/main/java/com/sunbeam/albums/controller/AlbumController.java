package com.sunbeam.albums.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.ValueRange;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Value("${music.dirname}")
	private String musicDirPath;

	//Option 2 : High level File NIO & Spring resource
//	@GetMapping(value = "/image/{imageName}",produces = "image/jpg")
//	public Resource getAlbumImage(@PathVariable String imageName) {
//		Path imagePath = Paths.get(musicDirPath,imageName);
//
//		try {
//			Resource resource = new UrlResource(imagePath.toUri());
//			return resource;
//		} catch (Exception e) {
//			throw new RuntimeException("DOWNLOAD ERROR: " + e.getMessage());
//		}
//	}

	// This can work for any type
	//Option 2: High level file NIO & Spring Resource with "Dynamic Content Type"
	@GetMapping("/image/{imageName}")
	public ResponseEntity<Resource> getAlbumImage(@PathVariable String imageName){
		Path imagePath = Paths.get(musicDirPath,imageName);
		try {
			Resource resource = new UrlResource(imagePath.toUri());
			MediaType contentType = MediaTypeFactory.getMediaType(resource)
					.orElse(MediaType.APPLICATION_OCTET_STREAM);

			return ResponseEntity.ok()
					.contentType(contentType)
					.body(resource);

		} catch (Exception e) {
			throw new RuntimeException("Download Error : "+e.getMessage());
		}
	}
}
