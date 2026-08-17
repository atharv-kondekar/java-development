package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.domain.Album;

@Component
public class AlbumRowMapper implements RowMapper<Album> {

	@Override
	public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Album album = new Album();

		album.setId(rs.getInt("id"));
		album.setTitle(rs.getString("title"));
		;
		album.setThumbnail(rs.getString("thumbnail"));

		return album;
	}
}
