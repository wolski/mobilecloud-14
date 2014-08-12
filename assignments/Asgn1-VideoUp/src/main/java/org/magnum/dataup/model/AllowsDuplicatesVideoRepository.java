package org.magnum.dataup.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.magnum.dataup.model.Video;

/**
 * An implementation of the VideoRepository that allows duplicate
 * Videos. 
 * 
 * Yes...there is a lot of code duplication with NoDuplicatesVideoRepository
 * that could be refactored into a base class or helper object. The
 * goal was to have as few classes as possible in the example and so
 * we did not do that refactoring.
 * 
 * @author jules
 *
 */
public class AllowsDuplicatesVideoRepository implements VideoRepository {

	// Lists allow duplicate objects that are .equals() to
	// each other
	//
	// Assume a lot more reads than writes
	private List<Video> videoList = new CopyOnWriteArrayList<Video>();
	
	@Override
	public Video addVideo(Video v) {
		videoList.add(v);
		v.setId(videoList.size());
		return v;
	}

	@Override
	public Collection<Video> getVideos() {
		return videoList;
	}
	
	public Video findVidByID(long id){
		--id;
		if(id >= 0 && id < videoList.size())
			return  videoList.get((int) id);
		else
			return null;
	}

	

}
