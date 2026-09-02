package com.puron.backend;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * module-boundary-guide.md 2차 방어 — 도메인 간 internal 패키지 직접 참조 금지를 빌드 단계에서 검증한다.
 *
 * 실제 도메인이 여러 개 생기면 도메인 쌍마다 규칙을 추가한다.
 * 지금은 auth 도메인 하나뿐이라 "어떤 패키지든 auth.internal을 참조하면 안 된다"는
 * 골격만 두고, auth 자기 자신은 예외로 둔다.
 */
class ModuleBoundaryArchTest {

    private static final JavaClasses APP_CLASSES =
            new ClassFileImporter().importPackages("com.puron.backend");

    @Test
    void 다른_도메인은_auth의_internal_패키지를_참조하면_안된다() {
        noClasses()
                .that().resideOutsideOfPackage("..auth.internal..")
                .and().resideOutsideOfPackage("com.puron.backend.auth.internal")
                .should().dependOnClassesThat().resideInAPackage("..auth.internal..")
                .check(APP_CLASSES);
    }
}
