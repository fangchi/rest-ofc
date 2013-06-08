package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.axis.XAxis;
import jofc2.model.elements.PieChart;
import jofc2.model.plugins.ValueElement;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class PieChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new PieChart()
										.addValues(new ValueElement(8).setText("呵呵").setTip("值是 (#val#)").setOnClick("my_function").setOnClickText("值是 (#val#)"), 
												   new ValueElement(8).setText("ceshi").setTip("值是 (#val#)/(#total#)(#radius#)").setOnClick("http://www.baidu.com"), 
												   new ValueElement(3).setLabel("测试"), 2, 5.2, 4.1,3.3, 2, 1)
										.setTooltip("#val#<br>#total#<br>#percent#<br>#label#")
										)
						.setBackgroundColour("#FFFFFF")
						.setXAxis(
								(XAxis) new XAxis()
										.setColour("#377261")
										.setGridColour("#377261")));
	}
}
