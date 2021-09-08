package com.video.streaming.controller;

import com.video.streaming.entity.VideoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    static List<VideoEntity> videos;

    static {
        videos = new ArrayList<>();
        videos.add(new VideoEntity(1L, "roujin.mp4", 1L, LocalDateTime.now()));
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("videos", videos);
        return "index";
    }

    @GetMapping("/view/video/{videoName}")
    public String viewVideo(@PathVariable String videoName) {
        return "video";
    }
}
