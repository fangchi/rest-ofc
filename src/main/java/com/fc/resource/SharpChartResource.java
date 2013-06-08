package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.ShapeChart;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SharpChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
				.addElements(new ShapeChart()
						.addPoints(new jofc2.model.elements.ShapeChart.Point(1,2),
								new jofc2.model.elements.ShapeChart.Point(2,4),
								new jofc2.model.elements.ShapeChart.Point(5,2),
								new jofc2.model.elements.ShapeChart.Point(3,4))));
	}
}
