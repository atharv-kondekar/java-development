package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.domain.Song;

@Component
public class SongRowMapper implements RowMapper<Song>{

	@Override
	public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
		Song song = new Song();

		song.setId( rs.getInt("id"));
		song.setTitle( rs.getString("title"));
		song.setFile( rs.getString("file"));
		song.setDuration( rs.getString("duration"));
		song.setAlbumId( rs.getInt("albumId"));

		return song;
	}
}
