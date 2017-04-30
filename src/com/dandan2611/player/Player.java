package com.dandan2611.player;

import java.util.HashMap;

import com.dandan2611.MyPlayerMain;
import com.dandan2611.modules.Module;

public class Player {

	// Variables //
	
	String name;
	String displayname;
	String prefix = name + " : ";

	HashMap<String, Module> modules = new HashMap<String, Module>();

	// Main constructor //
	
	public Player(String name, String displayname) {

		this.name = name;
		this.displayname = displayname;

		 prefix = name + " : ";
		 
		 System.out.println("MyPlayer : New Player named : " + name);
		
	}

	// Modules section //

	public HashMap<String, Module> getModules() {
		return modules;
	}

	public void addPlayerModule(String name, Module module) {
		modules.put(name, module);
		System.out.println("Adding module : " + module.getConfig().getName() + " to " + name);
	}

	public void removePlayerModule(String name) {
		modules.remove(name);
		System.out.println("Removing 1 module from " + name);
	}

	// Loading Modules //

	// Custom modules for players //
	
	public void loadPlayerModules() {

		if(modules.size() != 0) {

			for(String key : modules.keySet()) {

				System.out.println(prefix + "Loading module " + modules.get(key).getConfig().getName() + "...");
				System.out.println(" ");
				modules.get(key).onDetected();
				modules.get(key).onExecute();

			}
		}else{
			System.out.println("Oops, the player doesn't have module installed !");
		}
	}
	
	// Modules for all players //
	
	public void loadMainModules() {

		for(Module module : MyPlayerMain.mlist.getModules()) {

			System.out.println(prefix + "Loading module " + module.getConfig().getName() + "...");
			System.out.println(" ");
			module.onExecute();

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
