package com.video.streaming.controller;

import com.video.streaming.dto.VideoInfoDto;
import com.video.streaming.entity.VideoInfo;
import com.video.streaming.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    StreamingService streamingService;

    @GetMapping("/")
    public String mainPage(Model model) {
        Page<VideoInfoDto> page = streamingService.getVideoInfoList(Pageable.unpaged());
        model.addAttribute("videos", page.getContent());
        return "index";
    }

    @GetMapping("/view/video/{videoName}")
    public String viewVideo(@PathVariable String videoName) {
        return "video";
    }
}
