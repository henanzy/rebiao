package com.hnzy.custompojo;

public class VillageTreeNodes {
	private int nodeId;
	private int parentId;
	private String nodeName;
	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	@Override
	public String toString() {
		return "VillageTreeNodes [nodeId=" + nodeId + ", parentId=" + parentId + ", nodeName=" + nodeName + "]";
	}

	
}
