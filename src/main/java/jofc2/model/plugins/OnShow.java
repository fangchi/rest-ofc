package jofc2.model.plugins;

public class OnShow {

	private String type;
	
	private Integer cascade;
	
	private Double delay;

	public String getType() {
		return type;
	}

	public OnShow setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getCascade() {
		return cascade;
	}

	public OnShow setCascade(Integer cascade) {
		this.cascade = cascade;
		return this;
	}

	public Double getDelay() {
		return delay;
	}

	public OnShow setDelay(Double delay) {
		this.delay = delay;
		return this;
	}
}
