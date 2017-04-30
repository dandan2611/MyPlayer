package com.dandan2611;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.dandan2611.modules.Module;
import com.dandan2611.modules.ModuleList;
import com.dandan2611.players.PlayerList;

public class MyPlayerMain {

	/*
	 * SOLO PLAYER MODULE
	 * 
	 * MULTI PLAYER MODULE
	 */

	public static PlayerList list = new PlayerList();
	public static ModuleList mlist = new ModuleList();

	public static void main(String[] args) {

		System.out.println("MyPlayer : Starting MyPlayer...");
		System.out.println("MyPlayer : Cheking for modules...");

		File folder = new File("Player/Modules/");
		if(!folder.exists()) { folder.mkdirs(); }

		File[] listOfFiles = folder.listFiles();
		URL[] urls = new URL[1];


		for (File file : listOfFiles) {
			if (file.isFile()) {

				System.out.println("Detected file : " + file.getName());

				try {
					urls[0] = file.toURI().toURL();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}

				URLClassLoader child = new URLClassLoader (urls, 
						new MyPlayerMain().getClass().getClassLoader());
				try {
					Class classToLoad;
					try {
						classToLoad = Class.forName ("com.module.Module" + file.getName().replaceAll(".jar", ""), true, child);
						Module module = (Module) classToLoad.newInstance();
						System.out.println("File " + file.getName() + " is detected as a module");
						System.out.println("Checking version of module...");
							if(!(module.getConfig().noMoving().getModuleMainVersion() == "1.0")) {
								System.out.println("The module " + module.getConfig().getName() + " is not at the correct version, please update it to the correct version !");
								file.delete();
							}
							
						System.out.println("The module " + module.getConfig().getName() + " is at the correct version, adding it to module list");

						mlist.getModules().add(module);

					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}			
			}
		}
	}
}
