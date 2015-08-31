package mcm.projects.mypaths.uml;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class UploadedImage implements Serializable{
	public static final String SERVING_URL = "servingUrl";
	public static final String CREATED_AT = "createdAt";
	public static final String OWNER_ID = "ownerId";

	private String key;

	private Date createdAt;
	private String servingUrl;
	private String ownerId;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getServingUrl() {
		return servingUrl;
	}

	public void setServingUrl(String imageUrl) {
		this.servingUrl = imageUrl;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
