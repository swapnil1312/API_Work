package resources;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import pojo.LocationChild;
import pojo.ReqPlaceData;

public class TestDataBuild {

	public ReqPlaceData requestData() {

		ReqPlaceData d = new ReqPlaceData();
		LocationChild c = new LocationChild();

		Faker f = new Faker();

		c.setLat(-38.383494);
		c.setLng(33.427362);

		d.setLocation(c);
		d.setAccuracy(50);
		d.setName(f.name().firstName());
		d.setPhone_number(f.number().digits(10));
		d.setAddress(f.address().city());

		List<String> l = new ArrayList<>();
		l.add("shoe park");
		l.add("Shop");

		d.setTypes(l);
		d.setWebsite("https://www.google.com/");
		d.setLanguage("Hindi");
		return d;
	}

}
