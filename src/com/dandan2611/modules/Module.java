package com.dandan2611.modules;

import java.util.Map;

public interface Module {

	public void onDetected();
	public void onExecute();
	public void in(Object o);
	public Map<String, Object> out();
	
	public Config getConfig();
	
}
