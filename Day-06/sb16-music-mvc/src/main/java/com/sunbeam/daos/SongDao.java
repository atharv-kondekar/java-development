package com.sunbeam.daos;

import java.util.List;
import com.sunbeam.domain.Song;

public interface SongDao {
	List<Song> findByAlbumId(int id);
}
