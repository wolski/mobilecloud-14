package org.magnum.dataup.model;

import java.util.Collection;

import org.magnum.dataup.model.Video;

/**
 * An interface for a repository that can store Video
 * objects and allow them to be searched by title.
 * 
 * @author jules
 *
 */
public interface VideoRepository {

	// Add a video
	public Video addVideo(Video v);
	
	// Get the videos that have been added so far
	public Collection<Video> getVideos();
	
	public Video findVidByID(long id);
	
	
}
