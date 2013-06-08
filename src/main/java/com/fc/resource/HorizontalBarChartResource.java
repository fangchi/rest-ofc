package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.axis.XAxis;
import jofc2.model.elements.HorizontalBarChart;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HorizontalBarChartResource extends ServerResource {


	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new HorizontalBarChart()
										.setColour("#E2D66A")
										.addValues(1, 8, 7, 2, 5.2, 4.1,3.3, 2, 1))
						.setBackgroundColour("#FFFFFF")
						.setXAxis(
								(XAxis) new XAxis()
										.setLabels("fangchi", "liqiong")
										.setColour("#377261")
										.setGridColour("#377261")));
	}
}
