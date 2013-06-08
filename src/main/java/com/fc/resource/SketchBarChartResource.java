package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.SketchBarChart;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SketchBarChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
				.addElements(new SketchBarChart().addBars(
						new jofc2.model.elements.SketchBarChart.Bar(1),
						new jofc2.model.elements.SketchBarChart.Bar(4),
						new jofc2.model.elements.SketchBarChart.Bar(23),
						new jofc2.model.elements.SketchBarChart.Bar(3))
						));
	}
}
