package resources;

public enum APIResources {

	addPlaceAPI("maps/api/place/add/json"), 
	getPlaceAPT("maps/api/place/get/json"),
	updatePlaceAPI("maps/api/place/update/json"), 
	deletePlaceAPI("maps/api/place/add/json");

	public String resource;

	APIResources(String resource) {
		this.resource = resource;

	}

	public String getResource() {
		return resource;

	}

}
