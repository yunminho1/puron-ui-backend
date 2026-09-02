package com.puron.backend.auth.api;

import java.util.Optional;

/**
 * auth 도메인이 외부(다른 도메인)에 공개하는 유일한 창구.
 *
 * 다른 도메인은 이 인터페이스(와 아래 DTO)만 의존해야 하며,
 * auth.internal 패키지(엔티티/Repository/구현체)는 직접 참조할 수 없다.
 * (docs/00-system-design/framework-design/module-boundary-guide.md 참고 — 실제 도메인 확정 전 예시 골격)
 */
public interface AuthQueryService {

    Optional<AuthUserSummary> findActiveUser(Long userId);

    /** 다른 도메인에 필요한 최소 정보만 담은 DTO. 엔티티를 그대로 노출하지 않는다. */
    record AuthUserSummary(Long id, String username, boolean active) {
    }
}
