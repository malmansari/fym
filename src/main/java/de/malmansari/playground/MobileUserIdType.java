package de.malmansari.playground;

public enum MobileUserIdType {

	IMODE("imode"), SPMODE("spmode");

	private String val;

	private MobileUserIdType(String val) {
		this.val = val;
	}

	public String toString() {
		return val;
	}

}
