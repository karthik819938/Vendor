package com.app.dao;

import java.util.List;

import com.app.model.Location;

public interface ILocationDao {
	public int saveLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(int locId);
	public Location getLocById(int locId);
	public List<Location> getAllLocations();
}
