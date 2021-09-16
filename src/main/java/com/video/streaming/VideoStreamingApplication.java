package com.video.streaming;

import com.video.streaming.dto.VideoInfoDto;
import com.video.streaming.entity.VideoInfo;
import com.video.streaming.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class VideoStreamingApplication {
    //@Autowired
    //public static StreamingService streamingService;

    public static void main(String[] args) {
        System.out.println("started");
        SpringApplication.run(VideoStreamingApplication.class, args);
    }

}
