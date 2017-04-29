package com.dandan2611.player;

import java.util.HashMap;

import com.dandan2611.Main;
import com.dandan2611.modules.Module;

public class Player {

	String name;
	String displayname;

	String prefix = name + " : ";

	HashMap<String, Module> modules = new HashMap<String, Module>();

	public Player(String name, String displayname) {

		this.name = name;
		this.displayname = displayname;

		 prefix = name + " : ";
		
	}

	// Modules section //

	public HashMap<String, Module> getModules() {
		return modules;
	}

	public void addModule(String name, Module module) {
		modules.put(name, module);
	}

	public void removeModule(String name) {
		modules.remove(name);
	}

	// Loading Modules //

	public void loadModulesFromMap() {

		if(modules.size() != 0) {

			for(String key : modules.keySet()) {

				System.out.println(prefix + "Loading module " + modules.get(key).name() + "...");
				System.out.println(" ");
				modules.get(key).execute();

			}
		}else{
			System.out.println("Oops, the player doesn't have module installed !");
		}
	}
	
	public void loadModulesFromList() {

		for(Module module : Main.mlist.getModules()) {

			System.out.println(prefix + "Loading module " + module.name() + "...");
			System.out.println(" ");
			module.execute();

		}
	}
	
	// Using name and DisplayName //
	
	public String getName() {
		return name;
	}
	
	public String getDisplayName() {
		return displayname;
	}

}
