package com.example.user.config;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeyCloakManager {

    private final KeyCloakProperties keyCloakProperties;

    public RealmResource getKeycloakInstanceWithRealm() {
        return keyCloakProperties.getKeycloakInstance().realm(keyCloakProperties.getRealm());
    }
}
