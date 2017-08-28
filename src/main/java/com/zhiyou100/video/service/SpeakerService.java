package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.utils.Page;


public interface SpeakerService {

	List<Speaker> findAllSpeaker();

	Page loadPage(Integer page, String speakerJob, String speakerName);

	void addSpeaker(Speaker s);

	void deleteSpeaker(Integer id);

	Speaker updateSpeaker(Integer id);

	void updateSpeaker(Speaker s);

}
