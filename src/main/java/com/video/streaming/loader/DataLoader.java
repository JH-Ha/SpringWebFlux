package com.video.streaming.loader;

import com.video.streaming.dto.VideoInfoDto;
import com.video.streaming.entity.VideoInfo;
import com.video.streaming.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private StreamingService streamingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        streamingService.saveVideo(new VideoInfo(null, "roujin", 0L, LocalDateTime.now()));
        Pageable pageable = PageRequest.of(0, 10);
        Page<VideoInfoDto> videoInfoDtoList = streamingService.getVideoInfoList(pageable);
    }
}
