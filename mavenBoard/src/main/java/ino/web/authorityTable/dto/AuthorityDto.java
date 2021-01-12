package ino.web.authorityTable.dto;

import org.apache.ibatis.type.Alias;

@Alias("authorityDto")
public class AuthorityDto {

	private String groupId;
	private String groupName;
	private String useYn;
	private String objId;
	private String objName;
	private int dept;
	
	public AuthorityDto() {
		super();
	}

	public AuthorityDto(String groupId, String groupName, String useYn, String objId, String objName, int dept) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.useYn = useYn;
		this.objId = objId;
		this.objName = objName;
		this.dept = dept;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "AuthorityDto [groupId=" + groupId + ", groupName=" + groupName + ", useYn=" + useYn + ", objId=" + objId
				+ ", objName=" + objName + ", dept=" + dept + "]";
	}
	
	
}
