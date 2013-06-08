package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.YAxis;
import jofc2.model.elements.BarChart;
import jofc2.model.plugins.KeyElement;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class BarAllClickChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new BarChart()
										.setColour("#E2D66A")
										.addValues(1, 8, 7, 2, 5.2, 4.1,3.3, 1)
										.setOn_click("barClicked")
										.setOn_click_text("#key# = #val#")
										.setKeys(new KeyElement().setText("key1"))
										.setTooltip("#key#<br>#val#"))
						.setBackgroundColour("#FFFFFF")
						.setTitle(new Text("Many data lines","{font-size: 20px; color:#0000ff; font-family: Verdana; text-align: center;}"))
						.setYAxis(
								(YAxis) new YAxis()
										.setTickLength(3)
										.setColour("#d000d0")
										.setMin(0)
										.setMax(10)
										.setGridColour("#00ff00"))
						);
	}
}
