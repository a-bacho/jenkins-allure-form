package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/CredentialsProperties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}