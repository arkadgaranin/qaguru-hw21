package com.gmail.arkgaranin.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.gmail.arkgaranin.config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

  public static URL getBrowserstackUrl() {
    try {
      return new URL(Credentials.config.getUrl());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public WebDriver createDriver(DesiredCapabilities caps) {

    // Set your access credentials
    caps.setCapability("browserstack.user", Credentials.config.getUser());
    caps.setCapability("browserstack.key", Credentials.config.getKey());

    // Set URL of the application under test
    caps.setCapability("app", Credentials.config.getApp());

    // Specify device and os_version for testing
    caps.setCapability("device", Credentials.config.getDevice());
    caps.setCapability("os_version", Credentials.config.getOsVersion());

    // Set other BrowserStack capabilities
    caps.setCapability("project", Credentials.config.getProject());
    caps.setCapability("build", Credentials.config.getBuild());
    caps.setCapability("name", Credentials.config.getName());

    return new AndroidDriver(getBrowserstackUrl(), caps);
  }
}
