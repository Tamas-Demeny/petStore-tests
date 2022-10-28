package org.example.service.uritemplate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UriTemplate {
    private final String uri;

    public String getUri() {
        return String.format(uri, "");
    }

    public String getUri(Object... params) {
        return String.format(uri, params);
    }
}
