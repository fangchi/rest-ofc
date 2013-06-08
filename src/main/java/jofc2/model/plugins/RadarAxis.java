package jofc2.model.plugins;

import java.util.List;

import jofc2.model.axis.Axis;
import jofc2.model.axis.Label;
import jofc2.model.axis.RadarAxisLabels;
import jofc2.model.metadata.Alias;

public class RadarAxis extends Axis {

	private static final long serialVersionUID = 1L;

	@Alias("spoke-labels")
	private RadarAxisLabels spoke_labels = new RadarAxisLabels();
	
	
	
	public RadarAxisLabels getSpokeLabels() {
		return spoke_labels;
	}

	public RadarAxis setSpokeLabels(RadarAxisLabels spoke_labels) {
		this.spoke_labels = spoke_labels;
		return this;
	}

	public RadarAxis setSpokeLabels(String... labels) {
		this.spoke_labels = new RadarAxisLabels(labels);
		return this;
	}

	public RadarAxis setSpokeLabels(List<String> labels) {
		this.spoke_labels = new RadarAxisLabels(labels);
		return this;
	}

	public RadarAxis addLabels(String... labels) {
		this.spoke_labels.addLabels(labels);
		return this;
	}

	public RadarAxis addLabels(Label... labels) {
		this.spoke_labels.addLabels(labels);
		return this;
	}

	public RadarAxis addLabels(List<Label> labels) {
		this.spoke_labels.addLabels(labels);
		return this;
	}
}
