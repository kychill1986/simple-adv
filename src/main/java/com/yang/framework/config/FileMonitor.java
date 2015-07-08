package com.yang.framework.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Monitor class for file changes.
 * 
 * @author Rafael Steil
 * @version $Id: FileMonitor.java,v 1.9 2007/04/12 02:11:53 rafaelsteil Exp $
 */
public class FileMonitor {

	private static final Log log = LogFactory.getLog(FileMonitor.class);

	private static final FileMonitor instance = new FileMonitor();

	private Timer timer;

	private Map<String, Object> timerEntries;

	private FileMonitor() {
		this.timerEntries = new HashMap<String, Object>();
		this.timer = new Timer(true);
	}

	public static FileMonitor getInstance() {
		return instance;
	}

	/**
	 * Add a file to the monitor
	 * 
	 * @param listener
	 *            The file listener
	 * @param filename
	 *            The filename to watch
	 * @param period
	 *            The watch interval.
	 */
	public void addFileChangeListener(FileChangeListener listener, String filename, long period) {
		this.removeFileChangeListener(filename);

		log.info("Watching " + filename);

		FileMonitorTask task = new FileMonitorTask(listener, filename);

		this.timerEntries.put(filename, task);
		this.timer.schedule(task, period, period);
	}

	/**
	 * Stop watching a file
	 * 
	 * @param filename
	 *            The filename to keep watch
	 */
	public void removeFileChangeListener(String filename) {
		FileMonitorTask task = (FileMonitorTask) this.timerEntries.remove(filename);

		if (task != null) {
			task.cancel();
		}
	}

	private static class FileMonitorTask extends TimerTask {

		private FileChangeListener listener;

		private String filename;

		private File monitoredFile;

		private long lastModified;

		public FileMonitorTask(FileChangeListener listener, String filename) {
			this.listener = listener;
			this.filename = filename;

			this.monitoredFile = new File(filename);
			if (!this.monitoredFile.exists()) {
				return;
			}

			this.lastModified = this.monitoredFile.lastModified();
		}

		public void run() {
			long latestChange = this.monitoredFile.lastModified();
			if (this.lastModified != latestChange) {
				this.lastModified = latestChange;

				this.listener.fileChanged(this.filename);
			}
		}
	}
}