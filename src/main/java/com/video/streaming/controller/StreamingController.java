package com.video.streaming.controller;

import com.video.streaming.dto.VideoInfoDto;
import com.video.streaming.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "video/{id}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable Long id, @RequestHeader("Range") String range) {
        System.out.println("range in bytes() : " + range);
        VideoInfoDto videoInfoDto = streamingService.getVideoInfo(id);

        return streamingService.getVideo(videoInfoDto.getName());
    }

}
