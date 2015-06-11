package practice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class RequestParams {
	public static void main(String[] args) {
		ResourceEndpoint rpObj = new ResourceEndpoint("users", "24");
		rpObj.index();
		rpObj.addParams("amigoes", "hola");
		String url = rpObj.getUrl();
		System.out.println(url);
		rpObj.edit();
		rpObj.addParams("tick", "invest");
		url = rpObj.getUrl();
		System.out.println(url);
	}
}

class ResourceEndpoint {

	private static HashMap<String, String> hmParams = new HashMap<String, String>();

	StringBuilder sb;
	private String resource_id;
	// resource identifier is the name of resource eg users, ticks etc
	private String resourceIdentifier;

	// the constructor provides mechanism to pass resource name and id(if
	// present).
	public ResourceEndpoint(String resourceIdentifier, String id) {
		this.resourceIdentifier = resourceIdentifier;
		this.resource_id = id;
	}

	public void addParams(String key, String value) {
		hmParams.put(key, value);
	}

	public void index() {
		sb = new StringBuilder();
		sb.append("pavitrakansara.com" + "/" + resourceIdentifier + "/" + resource_id + "/index");
	}

	public void edit() {
		sb = new StringBuilder();
		sb.append("pavitrakansara.com" + "/" + resourceIdentifier + "/" + resource_id + "/edit");
	}

	public String getEncodedParams() {
		StringBuilder sb = new StringBuilder();
		for (String key : hmParams.keySet()) {
			try {
				// encode the url
				String value = URLEncoder.encode(hmParams.get(key), "UTF-8");
				// append the value to key
				sb.append(key + "=" + value);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public String getUrl() {
		return sb.toString() + "-----" + getEncodedParams();
	}
}
