package com.sunbeam.daos;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.domain.Song;

@Repository
public class SongDaoImpl implements SongDao {

	private JdbcTemplate jdbcTemplate;
	private SongRowMapper songRowMapper;

	public SongDaoImpl(JdbcTemplate jdbcTemplate , SongRowMapper songRowMapper) {
		this.jdbcTemplate=jdbcTemplate;
		this.songRowMapper=songRowMapper;
	}

	@Override
	public List<Song> findByAlbumId(int albumId) {
		String sql ="SELECT * FROM songs WHERE albumId = ?";
		List<Song> songs = jdbcTemplate.query(sql,songRowMapper, albumId);
		return songs;
	}

}
