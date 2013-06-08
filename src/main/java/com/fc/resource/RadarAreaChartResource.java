package com.fc.resource;

import java.util.Date;

import jofc2.OFC;
import jofc2.model.Chart;
import jofc2.model.plugins.AreaChart;
import jofc2.model.plugins.RadarAxis;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RadarAreaChartResource extends ServerResource {

	@Get("json")
	public String represent() {
		return OFC.getInstance().render(
				new Chart(new Date().toString())
						.addElements(
								new AreaChart().setColour("#E2D66A").addValues(
										1, 2,3, 4,5,6,7,8,9).setLoop(true)
								)
						.setBackgroundColour("#FFFFFF")
						.setRadar_axis((RadarAxis)new RadarAxis().setSpokeLabels("1月","2月","3月","4月","5月","6月","7月","8月","9月").setMin(0).setMax(10).setSteps(1))
						);
	}
}
