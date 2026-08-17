package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.domain.Album;

public interface AlbumDao {
	List<Album> findAlbums();
}
