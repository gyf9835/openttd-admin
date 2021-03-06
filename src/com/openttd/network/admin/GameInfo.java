package com.openttd.network.admin;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GameInfo implements Cloneable {
	private int version;

	// Server Info (Welcome)
	private String serverName;
	private String serverRevision;
	private boolean serverDedicated;
	// Map Info (Welcome)
	private String mapName;
	private long mapSeed;
	private short mapSet;
	private long startDate;
	private int mapWidth;
	private int mapHeight;
	// Unused
	private long currentDate;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerRevision() {
		return serverRevision;
	}

	public void setServerRevision(String serverRevision) {
		this.serverRevision = serverRevision;
	}

	public boolean isServerDedicated() {
		return serverDedicated;
	}

	public void setServerDedicated(boolean serverDedicated) {
		this.serverDedicated = serverDedicated;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public short getMapSet() {
		return mapSet;
	}

	public void setMapSet(short mapSet) {
		this.mapSet = mapSet;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public long getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(long currentDate) {
		this.currentDate = currentDate;
	}

	public void setMapSeed(long seed) {
		this.mapSeed = seed;
	}

	public long getMapSeed() {
		return this.mapSeed;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		GameInfo clone = (GameInfo) super.clone();
		clone.version = version;
		// Server
		clone.serverDedicated = serverDedicated;
		clone.serverName = serverName;
		clone.serverRevision = serverRevision;
		// Map
		clone.mapSeed = mapSeed;
		clone.mapSet = mapSet;
		clone.mapName = mapName;
		clone.mapWidth = mapWidth;
		clone.mapHeight = mapHeight;
		// Game
		clone.startDate = startDate;
		clone.currentDate = currentDate;
		return clone;
	}

	@Override
	public String toString() {
		StringWriter writer = new StringWriter();
		PrintWriter pw = new PrintWriter(writer);
		pw.println("GameInfo v" + version + ".");
		pw.println("Server:" + serverName + ", " + serverRevision + ", dedicated:" + serverDedicated + ".");
		pw.println("Map:" + mapName + ", Set:" + mapSet + ", " + mapWidth + "x" + mapHeight + ".");
		pw.println("Game:" + currentDate + ", started:" + startDate + ".");
		pw.flush();
		return writer.getBuffer().toString();
	}
}
