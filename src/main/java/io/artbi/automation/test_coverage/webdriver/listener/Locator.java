package io.artbi.automation.test_coverage.webdriver.listener;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Accessors(fluent = false, chain = true)
@Getter
@Setter
public class Locator {

    private String type;
    private String fullPath;
    private String action;
    private Set<String> urls = new HashSet<>();

}
