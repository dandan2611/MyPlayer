package com.dandan2611.api;

import com.dandan2611.MyPlayerMain;
import com.dandan2611.modules.ModuleList;
import com.dandan2611.players.PlayerList;

public class ModuleDev {

	public PlayerList getPlayers() {
		return MyPlayerMain.list;
	}
	
	public ModuleList getModuleList() {
		return MyPlayerMain.mlist;
	}
	
}
