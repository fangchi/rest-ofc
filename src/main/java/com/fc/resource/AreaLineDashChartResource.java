package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.XAxis;
import jofc2.model.axis.YAxis;
import jofc2.model.plugins.AreaChart;
import jofc2.model.plugins.DotStyle;
import jofc2.model.plugins.LineStyle;
import jofc2.model.plugins.OnShow;
import jofc2.model.plugins.ValueElement;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class AreaLineDashChartResource extends ServerResource {
	@Get("json")
	public String represent() {
		return OFC.getInstance().render(new Chart(new Date().toString())
				.addElements(
						((AreaChart) new AreaChart()
								.setLineStyle(new LineStyle().setStyle("dash").setOn(4).setOff(2))
								.setFill("#343399")
								.setColour("#CC3399")
								.setOnShow(new OnShow().setType("mid-slide").setCascade(1).setDelay(0.5))
								.addValues(1, 8, 7, 2,
										new ValueElement(5.2).setType("star"),
										4.1, 3.3, 2, 1))
								.setDotStyle(new DotStyle().setSize(2)
										.setSides(3)
										.setTip("这里是值:#val#")
										.setType("hollow-dot").setWidth(3))
								.setFontSize(10))
				.setYAxis((YAxis) new YAxis().setMax(20).setMin(0))
				.setXAxis((XAxis) new XAxis().setLabels("1月","2月","3月","4月","5月","6月","7月","8月","9月"))
				.setYLegend(new Text("OFC", "{font-size: 12px; color:#736AFF;}"))
				);
	}
}
