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

public class HBarChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
						.addElements(
								new BarChart(BarChart.Style.HBAR)
										.setColour("#EFD36B")
										.addValues(new ValueElement().setLeft(0).setRight(1).setTip("做作业"), 
												new ValueElement().setLeft(1).setRight(2).setTip("做美容"), 
												new ValueElement().setLeft(2).setRight(3).setTip("炒股"), 
												new ValueElement().setLeft(3).setRight(4).setTip("玩乐"))
										.setText("A作息时间"),
								new BarChart(BarChart.Style.HBAR)
								.setColour("#A1FFG1")
								.addValues(new ValueElement().setLeft(0).setRight(1.5).setTip("做作业2"), 
										new ValueElement().setLeft(1.5).setRight(2.3).setTip("做美容2"), 
										new ValueElement().setLeft(2.3).setRight(2.9).setTip("炒股2"), 
										new ValueElement().setLeft(2.9).setRight(4).setTip("玩乐2"))
								.setText("B作息时间"))
						.setBackgroundColour("#FFFFFF")
						.setXAxis(
								(XAxis) new XAxis()
										.setLabels("1月1日", "1月2日", "1月3日", "1月4日", "1月5日")
										.setColour("#377261")
										.setGridColour("#377261"))
						.setTitle(new Text("作息时间")));
	}
}
