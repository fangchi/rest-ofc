package com.fc.resource;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.elements.LineChart;
import jofc2.model.plugins.RadarAxis;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RadarChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(
				new Chart("diaosi奋斗史")
						.addElements(
								new LineChart().setColour("#E2D66A").addValues(
										1, 3, 5).setLoop(true).setText("10年"),
								new LineChart().setColour("#343399").addValues(
										2, 4, 5).setLoop(true).setText("11年"),
								new LineChart().setColour("#Z2X66P").addValues(
										5, 5, 5).setLoop(true).setText("12年")
								)
						.setBackgroundColour("#FFFFFF")
						.setRadar_axis((RadarAxis)new RadarAxis().setSpokeLabels("高","富","帅").setMax(6).setSteps(1).setStroke(1))
						);
	}
}
