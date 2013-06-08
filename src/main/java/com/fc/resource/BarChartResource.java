package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.XAxis;
import jofc2.model.elements.BarChart;
import jofc2.model.plugins.ValueElement;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class BarChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		String casServerUrl ="";
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new BarChart()
										.setColour("#E2D66A")
										.addValues(new ValueElement().setTop(5).setOnClick(casServerUrl).setColour("#d01f3c"), 
						                          new ValueElement().setTop(4).setOnClick(casServerUrl).setColour("#356aa0"), 
						                          new ValueElement().setTop(3).setOnClick(casServerUrl).setColour("#C79810"),
						                          new ValueElement().setTop(2).setOnClick(casServerUrl).setColour("#d91g3c"),
						                          new ValueElement().setTop(1).setOnClick(casServerUrl).setColour("#FF6633"),
						                          new ValueElement().setTop(0).setOnClick(casServerUrl).setColour("#00FF66"))
						                 .setOn_click(""),
								new BarChart()
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
