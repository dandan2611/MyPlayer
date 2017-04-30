package com.dandan2611.modules;

public class Config {

	String name;
	String author;
	String version;
	String description;
	String website;
	
	boolean isPlayerModule;
	
	NoMovingConfigurationSection noMoving = new NoMovingConfigurationSection("1.0");
	
	public Config(String name, String author, String version, String description, String website, boolean isPlayerModule) {
		this.name = name;
		this.author = author;
		this.version = version;
		this.description = description;
		this.website = website;
		this.isPlayerModule = isPlayerModule;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public boolean isPlayerModule() {
		return isPlayerModule();
	}
	
	public NoMovingConfigurationSection noMoving() {
		return noMoving;
	}
	
}
