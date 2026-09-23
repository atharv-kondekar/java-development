package com.sunbeam.albums.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.albums.domain.Album;

public interface AlbumDao extends JpaRepository<Album, Integer>{

}