package com.dandan2611;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.dandan2611.modules.Module;
import com.dandan2611.modules.ModuleList;
import com.dandan2611.players.PlayerList;

public class Main {

	public static PlayerList list = new PlayerList();
	public static ModuleList mlist = new ModuleList();

	public static void main(String[] args) {

		File folder = new File("Player/Modules/");
		if(!folder.exists()) { folder.mkdirs(); }

		File[] listOfFiles = folder.listFiles();
		URL[] urls = new URL[1];


		for (File file : listOfFiles) {
			if (file.isFile()) {

				//System.out.println(file.getName());

				try {
					urls[0] = file.toURI().toURL();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}

				// Chargement du module

				URLClassLoader child = new URLClassLoader (urls, 
						new Main().getClass().getClassLoader());
				try {
					@SuppressWarnings("rawtypes")
					Class classToLoad;
					classToLoad = Class.forName ("com.module.Module" + file.getName().replaceAll(".jar", ""), true, child);
					try {
						Module module = (Module) classToLoad.newInstance();
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
