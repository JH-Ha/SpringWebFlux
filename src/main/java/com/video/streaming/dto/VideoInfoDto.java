package com.video.streaming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class VideoInfoDto {
    private long id;
    private String name;
    private LocalDateTime uploadDate;
    private long viewCount;
}
