package com.arc.datamodel.model;

public class ExternalAccount extends Account {
	
	private String ffiecInstruction;

	public String getFfiecInstruction() {
		return ffiecInstruction;
	}

	public void setFfiecInstruction(String ffiecInstruction) {
		this.ffiecInstruction = ffiecInstruction;
	}

	@Override
	public String toString() {
		return "ExternalAccount [ffiecInstruction=" + ffiecInstruction + ", toString()=" + super.toString() + "]";
	}
}
