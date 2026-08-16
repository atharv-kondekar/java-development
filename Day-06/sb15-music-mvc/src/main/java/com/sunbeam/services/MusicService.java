package com.sunbeam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.daos.AlbumDao;
import com.sunbeam.daos.SongDao;
import com.sunbeam.domain.Album;
import com.sunbeam.domain.Song;
import com.sunbeam.models.AlbumCreadentials;

import ch.qos.logback.classic.jul.LevelChangePropagator;

@Service
public class MusicService {

	private AlbumDao albumDao;
	private SongDao songDao;

	public MusicService(AlbumDao albumDao,SongDao songDao) {
		this.albumDao=albumDao;
		this.songDao=songDao;
	}

	public List<Album> showAlbums(){
		List<Album> list = albumDao.findAlbums();
		return list;
	}

	public List<Song> showAlbumSongs(AlbumCreadentials ac) {
		List<Song> songs = songDao.findByAlbumId(ac.getAlbumId());
		return songs;
	}
}
