package online.huihua.suzhou.com.huihuaapp.util.update;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VersionItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2806100607978597248L;

	@SerializedName("version")
	private String Version;
	@SerializedName("description")
	private String description;
	
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



}
