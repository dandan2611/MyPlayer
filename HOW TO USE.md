# MyPlayer
A Java PlayerAPI

**Presentation**

MyPlayer is a development API that will serve you especially in your games to offer modules to your players (Mods).
It will also offer you a fluidity and personal settings.

**Player Module**


The player module is a module that is going to be given to the player only and not to the set of players created, it allows that a player has a module, and not another

**All-Players Modules**


The All-Players module is a module group that will be added to all players during a load of modules

# How to install ?

Add `MyPlayer.jar` in your [Java Build Path](http://stackoverflow.com/questions/18870213/adding-external-jar-to-eclipse) of your project

# How to use ?

# Players

**Creating a player**

To create a player its very simple :
````
Player p = new Player(name, displayname);
````

**Get player name**

````
p.getName(); // Return STRING
````

**Get player displayname**
````
p.getDisplayName(); // Return STRING
````

**Add module to player**
````
p.addPlayerModule(name, module);
````

**Remove module to player**

````
p.removePlayerModule(name);
````

**Load player module**

````
p.loadPlayerModules();
````

**Load All-Players Module**

````
p.loadMainModules();
````

# Modules

**Creating a module**

To create a new module, you need to create a new Java Project,
````
Create a new package named :
com.module

Create a new class named : Module[NAMEOFJARWITHOUT.JAR]

Implement the class with Module

Create a new Config :

Config config = new Config(name of module, author, version, description, website, isplayermodule);

And change :

	@Override
	public Config getConfig() {
		return null;
	}
  
to :

	@Override
	public Config getConfig() {
		return config;
	}

You can code in

	@Override
	public void execute() {
		System.out.println("The module " + config.getName() + " is started !");
	}


````

When your module is finished you can export it and move it to MyPlayer/Modules
