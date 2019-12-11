package com.pks.desktop.client.repository;

import org.springframework.data.repository.CrudRepository;

import com.pks.desktop.client.model.Track;

public interface TrackRepository extends CrudRepository<Track,Integer> {

}
