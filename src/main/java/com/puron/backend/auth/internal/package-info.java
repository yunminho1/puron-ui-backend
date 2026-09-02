/**
 * auth 도메인 내부 전용 패키지 — 엔티티/Repository/구현체를 둔다.
 *
 * 이 패키지 안의 클래스는 public을 붙이지 않는다(package-private).
 * 다른 도메인 패키지에서는 애초에 import가 불가능하도록 컴파일 단계에서 강제한다
 * (module-boundary-guide.md "어떻게 강제하는가" 절 — 1차 방어: 접근제한자, 2차 방어: ArchUnit).
 *
 * 실제 엔티티/Repository/서비스 구현체는 login 기능 요구사항정의서·기능명세서 확정 후
 * 개발팀(dev-backend)이 채운다. 지금은 도메인 경계 골격만 표시하는 빈 패키지다.
 */
package com.puron.backend.auth.internal;
