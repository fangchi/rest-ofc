package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.XAxis;
import jofc2.model.axis.YAxis;
import jofc2.model.elements.ScatterChart;
import jofc2.model.plugins.DotStyle;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ScatterChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC
				.getInstance()
				.render(new Chart(new Date().toString())
						.addElements(
								new ScatterChart()
										.addPoints(
												new jofc2.model.elements.ScatterChart.Point(
														2, 3),
												new jofc2.model.elements.ScatterChart.Point(
														3, 1).setDotSize(15).setTip("hheheh").setColour("#FF0000"),
												new jofc2.model.elements.ScatterChart.Point(
														0, 3)).setColour("#FFB900").setDotStyle(new DotStyle().setType("solid-dot"))
										)
						.setXAxis((XAxis) new XAxis().setMax(5).setMin(-1))
						.setYAxis((YAxis) new YAxis().setMax(5).setMin(-1))
						.setYLegend(new Text("time", "{font-size: 20px; color: #736AFF;}")));
	}
}
