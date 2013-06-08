package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.XAxis;
import jofc2.model.elements.BarChart;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class Bar3DChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new BarChart(BarChart.Style.THREED)
										.setColour("#E2D66A")
										.addValues(1, 8, 7, 2, 5.2, 4.1,3.3, 2, 1),
								new BarChart(BarChart.Style.THREED)
										.setColour("#A2D66A")
										.addValues(2, 4, 3, 6, 3, 1,2, 5, 2))
						.setBackgroundColour("#FFFFFF")
						.setTitle(new Text("Many data lines","{font-size: 20px; color:#0000ff; font-family: Verdana; text-align: center;}"))
						.setXAxis(
								(XAxis) new XAxis()
										.setLabels("fangchi", "liqiong")
										.setColour("#377261")
										.setGridColour("#377261")));
	}
}
