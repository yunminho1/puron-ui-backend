package com.puron.backend.sample;

import java.time.Instant;

import org.springframework.stereotype.Service;

/**
 * 프론트-백엔드-게이트웨이 연결 확인용 샘플 서비스 (정식 기능 아님).
 *
 * 1줄짜리 로직이라 인터페이스 분리 없이 단일 클래스로 둔다.
 */
@Service
public class SampleTimeService {

    /** 현재 시각을 ISO-8601 UTC 문자열로 반환한다. */
    public String getCurrentTime() {
        return Instant.now().toString();
    }
}
