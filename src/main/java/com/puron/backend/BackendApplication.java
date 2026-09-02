package com.puron.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * puron-ui-backend 진입점.
 *
 * Spring profile 3종(plan/dev/prod)으로 로컬 환경을 분리한다.
 * (docs/05-deployment/phase-1/environment-setup-plan.md 1절/3절 참고)
 */
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
