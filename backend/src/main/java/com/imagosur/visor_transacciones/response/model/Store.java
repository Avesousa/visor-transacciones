package com.imagosur.visor_transacciones.response.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Store {
	private List<Integer> secondary;
	private boolean multiple;
	private Long main;
	
	public List<Integer> getSecondary() {
		return secondary;
	}
	public void setSecondary(List<Integer> secondary) {
		this.secondary = secondary;
	}
	public boolean isMultiple() {
		return multiple;
	}
	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}
	public Long getMain() {
		return main;
	}
	public void setMain(Long main) {
		this.main = main;
	}
	@Override
	public String toString() {
		return "Store [secondary=" + secondary + ", multiple=" + multiple + ", main=" + main + "]";
	}
	
	
	
	
}
