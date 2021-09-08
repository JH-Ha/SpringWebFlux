package com.video.streaming.service;

import com.video.streaming.dto.VideoInfoDto;
import com.video.streaming.entity.VideoInfo;
import com.video.streaming.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@Transactional
public class StreamingService {

    private static final String FORMAT = "classpath:videoResources/%s.mp4";
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private VideoRepository videoRepository;

    @PostConstruct
    public void init() {
//        saveVideo(new VideoInfo(null, "roujin", 0L, LocalDateTime.now()));
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<VideoInfoDto> videoInfoDtoList = getVideoInfoList(pageable);

    }

    public void saveVideo(VideoInfo videoInfo) {
        videoRepository.saveVideo(videoInfo);
    }

    public Page<VideoInfoDto> getVideoInfoList(Pageable pageable) {
        return videoRepository.findVideos(pageable);
    }

    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
    }
}
