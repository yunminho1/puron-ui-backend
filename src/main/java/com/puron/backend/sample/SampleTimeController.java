package com.puron.backend.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 프론트-백엔드-게이트웨이 연결 확인용 샘플 컨트롤러 (정식 기능 아님).
 *
 * 인증/DB/Redis 접근 없이 현재 시각만 반환하는 순수 REST 진입점.
 */
@RestController
@RequestMapping("/api/sample")
public class SampleTimeController {

    private final SampleTimeService sampleTimeService;

    public SampleTimeController(SampleTimeService sampleTimeService) {
        this.sampleTimeService = sampleTimeService;
    }

    @GetMapping("/current-time")
    public CurrentTimeResponse getCurrentTime() {
        return new CurrentTimeResponse(sampleTimeService.getCurrentTime());
    }

    /** 응답 DTO. */
    public record CurrentTimeResponse(String currentTime) {
    }
}
