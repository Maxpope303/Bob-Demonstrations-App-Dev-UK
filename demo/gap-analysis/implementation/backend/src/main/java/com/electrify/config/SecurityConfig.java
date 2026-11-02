package com.electrify.config;

import org.springframework.context.annotation.Configuration;

// TODO: Migration required — Spring Security HttpSecurity DSL not supported by quarkus-spring-security
//
// The following Spring Security classes have been removed as they do not exist in Quarkus:
//   REMOVED: import org.springframework.context.annotation.Bean
//   REMOVED: import org.springframework.security.config.annotation.web.builders.HttpSecurity
//   REMOVED: import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//   REMOVED: import org.springframework.security.web.SecurityFilterChain
//
// The @EnableWebSecurity + SecurityFilterChain @Bean pattern is Spring MVC-specific.
// quarkus-spring-security supports only method-level annotations (@Secured, @PreAuthorize).
//
// To replicate the original URL-pattern rules in Quarkus, choose one of:
//
//   Option A — HTTP Security Policies in application.properties (recommended):
//     quarkus.http.auth.permission.public.paths=/api/public/*
//     quarkus.http.auth.permission.public.policy=permit
//     quarkus.http.auth.permission.admin.paths=/api/admin/*
//     quarkus.http.auth.permission.admin.policy=role
//     quarkus.http.auth.permission.admin.roles=ADMIN
//     quarkus.http.auth.permission.authenticated.paths=/*
//     quarkus.http.auth.permission.authenticated.policy=authenticated
//
//   Option B — Programmatic HttpSecurityPolicy (Jakarta Security CDI bean):
//     @ApplicationScoped
//     public class EnergyGridSecurityPolicy implements HttpSecurityPolicy { ... }
//
// DISCREPANCY #10: Auth0 integration still missing — see application.properties for wiring notes.
// DISCREPANCY #11: API Gateway authentication pattern still not implemented.
// DISCREPANCY #12: HTTP Basic auth kept for now; replace with quarkus-oidc for OAuth2/OIDC.
// DISCREPANCY #13: Auth0 domain / client-id / audience config not present.

/**
 * Security Configuration for Energy Grid System
 *
 * DISCREPANCY #10: Using basic Spring Security instead of Auth0
 * Design document specifies:
 * - Auth0 as external identity server
 * - OAuth2 and OpenID Connect protocols
 * - Authorization Code Flow with PKCE
 *
 * Current implementation uses basic Spring Security without Auth0 integration.
 * The HttpSecurity DSL bean has been removed during Quarkus migration; see TODO above.
 */
@Configuration
public class SecurityConfig {

    // DISCREPANCY #11: No API Gateway authentication pattern
    // Design specifies authentication should be at API Gateway level
    // Current implementation has security at service level

    // DISCREPANCY #12: HTTP Basic preserved conceptually; Quarkus equivalent requires
    // quarkus.http.auth.basic=true + an identity provider (embedded users or OIDC)

    // DISCREPANCY #13: Missing Auth0 configuration
    // Should have Auth0 domain, client ID, client secret, audience configuration
    // Should implement PKCE flow for single page application

}

// Made with Bob
