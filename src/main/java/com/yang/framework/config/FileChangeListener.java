package com.yang.framework.config;

public interface FileChangeListener {

	/**
	 * Invoked when a file changes
	 * 
	 * @param filename
	 *            Name of the changed file
	 */
	public void fileChanged(String filename);
}
