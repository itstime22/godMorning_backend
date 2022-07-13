package com.godMorning_backend.service;

import com.godMorning_backend.domain.Heart;
import com.godMorning_backend.repository.JDBCHeartRepository;
import org.springframework.stereotype.Service;


@Service
public class HeartServiceImpl {

    private final JDBCHeartRepository jdbcHeartRepository;

    public HeartServiceImpl(JDBCHeartRepository jdbcHeartRepository) {
        this.jdbcHeartRepository = jdbcHeartRepository;
    }

    public String deleteHeart(Long id, Long post_no) {
        return jdbcHeartRepository.deleteHeart(id, post_no);
    }

    public String insertHeart(Heart heart) {
        if (jdbcHeartRepository.findByUserIdAndPost_no(heart.getId(), heart.getPost_no()).isPresent()) {
            return "~";
        } else {
            jdbcHeartRepository.insertHeart(heart);
        }

        return String.valueOf(heart.getId());
    }




}