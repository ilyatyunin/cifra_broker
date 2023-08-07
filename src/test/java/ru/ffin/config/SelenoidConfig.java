package ru.ffin.config;

import org.aeonbits.owner.Config;

public interface SelenoidConfig extends Config{

    @Config.Key("selenoid.url")
    String url();

    @Config.Key("selenoid.login")
    String login();

    @Config.Key("selenoid.password")
    String password();
}