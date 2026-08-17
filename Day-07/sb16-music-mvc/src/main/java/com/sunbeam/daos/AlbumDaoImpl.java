package com.sunbeam.daos;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.domain.Album;

@Repository
public class AlbumDaoImpl implements AlbumDao {

	private JdbcTemplate jdbcTemplate;
	private AlbumRowMapper albumRowMapper;

	public AlbumDaoImpl(JdbcTemplate jdbcTemplate, AlbumRowMapper albumRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.albumRowMapper = albumRowMapper;
	}

	public List<Album> findAlbums() {
		String sql = "SELECT * FROM albums";
		List<Album> albumList = jdbcTemplate.query(sql, albumRowMapper);
		return albumList;
	}
}
