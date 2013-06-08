package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.LineChart;
import jofc2.model.plugins.ValueElement;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class LineChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new LineChart()
										.setColour("#F8H9GA")
										.addValues(1, 8, new ValueElement(7), 2, 5.2, 4.1,3.3, 2, 1)
										.setText("中国远洋600366")
										.setTooltip("#label"),
								new LineChart()
										.setColour("#E2D66A")
										.addValues(2, 3, 4, 2.5, 3.2, 6.1,4.3, 6.2, 7.1)
										.setText("精工钢构600157")
										)
						.setBackgroundColour("#FFFFFF")
						
						);
	}
}
