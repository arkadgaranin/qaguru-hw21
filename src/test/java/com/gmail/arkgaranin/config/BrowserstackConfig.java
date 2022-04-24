package com.gmail.arkgaranin.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources("classpath:browserstack.properties")
public interface BrowserstackConfig extends Config {

  @Key("url")
  String getUrl();

  @Key("user")
  String getUser();

  @Key("key")
  String getKey();

  @Key("app")
  String getApp();

  @Key("device")
  String getDevice();

  @Key("os_version")
  String getOsVersion();

  @Key("project")
  String getProject();

  @Key("build")
  String getBuild();

  @Key("name")
  String getName();

  @Key("api")
  String getApi();
}
