package com.sunbeam.albums.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.albums.dao.AlbumDao;
import com.sunbeam.albums.domain.Album;
import com.sunbeam.albums.dto.AlbumResponseDTO;

@Transactional
@Service
public class AlbumService {

	private AlbumDao albumDao;
	private ModelMapper mapper;

	public AlbumService(AlbumDao albumDao, ModelMapper mapper) {
		super();
		this.albumDao = albumDao;
		this.mapper = mapper;
	}

	public List<AlbumResponseDTO> findAll() {
		List<Album> albumList = albumDao.findAll();
		return albumList.stream()
				.map( album -> mapper.map(album, AlbumResponseDTO.class))
				.toList();
	}
}
