package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.LineChart;
import jofc2.model.plugins.ValueElement;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class LineChartResourceReload extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new LineChart()
										.setColour("#F8H9GA")
										.addValues(2, 1, new ValueElement(1), 1, 1.2, 1.1,0.3, 0.2, 0.1)
										.setText("中国远洋600366")
										.setTooltip("#label")
										)
						.setBackgroundColour("#FFFFFF")
						
						);
	}
}
