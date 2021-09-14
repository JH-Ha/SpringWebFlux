package com.video.streaming.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.video.streaming.dto.VideoInfoDto;
import com.video.streaming.entity.QVideoInfo;
import com.video.streaming.entity.VideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VideoRepository {
    @Autowired
    private EntityManager em;

    public void saveVideo(VideoInfo videoInfo) {
        em.persist(videoInfo);
    }

    public Page<VideoInfoDto> findVideos(Pageable pageable) {
        JPAQuery<VideoInfo> query = new JPAQuery<>(em);
        QVideoInfo qVideoInfo = QVideoInfo.videoInfo;

        List<VideoInfoDto> videoInfoDtoList = query.select(Projections.constructor(VideoInfoDto.class,
                        qVideoInfo.id, qVideoInfo.name, qVideoInfo.uploadDate, qVideoInfo.viewCount))
                .from(qVideoInfo)
                .fetch();
        return new PageImpl<>(videoInfoDtoList);
    }

    public VideoInfoDto getOneVideo(Long id) {
        JPAQuery<VideoInfo> query = new JPAQuery<>(em);
        QVideoInfo qVideoInfo = QVideoInfo.videoInfo;
        VideoInfoDto videoInfoDto = query.select(Projections.constructor(VideoInfoDto.class,
                        qVideoInfo.id, qVideoInfo.name, qVideoInfo.uploadDate, qVideoInfo.viewCount))
                .from(qVideoInfo)
                .where(qVideoInfo.id.eq(id))
                .fetchFirst();
        return videoInfoDto;
    }
}
