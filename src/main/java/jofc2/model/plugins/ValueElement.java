package jofc2.model.plugins;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.util.plugins.ValueElementConverter;

@Converter(ValueElementConverter.class)
public class ValueElement {

	private Number value;
	
	private Number right;
	
	private Number left;

	private String type;

	private String colour;
	
	private String text;
	
	@Alias("dot-size")
	private String dotSize;
	
	@Alias("on-click")
	private String onClick;
	
	@Alias("on-click-text")
	private String onClickText;

	private String tip;
	
	private String label;
	
	private Number top;
	
	private Number x;
	
	private Number y;
	
	@Alias("label-colour")
	private String labelColour;

	public ValueElement() {

	}

	public ValueElement(Number value) {
		this.value = value;
	}

	public Number getValue() {
		return value;
	}

	public ValueElement setValue(Number value) {
		this.value = value;
		return this;
	}

	public String getType() {
		return type;
	}

	public ValueElement setType(String type) {
		this.type = type;
		return this;
	}

	public String getColour() {
		return colour;
	}

	public ValueElement setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public String getDotSize() {
		return dotSize;
	}

	public ValueElement setDotSize(String dotSize) {
		this.dotSize = dotSize;
		return this;
	}

	public String getTip() {
		return tip;
	}

	public ValueElement setTip(String tip) {
		this.tip = tip;
		return this;
	}

	public String getOnClick() {
		return onClick;
	}

	public ValueElement setOnClick(String onClick) {
		this.onClick = onClick;
		return this;
	}

	public String getText() {
		return text;
	}

	public ValueElement setText(String text) {
		this.text = text;
		return this;
	}

	public String getOnClickText() {
		return onClickText;
	}

	public ValueElement setOnClickText(String onClickText) {
		this.onClickText = onClickText;
		return this;
	}

	public Number getRight() {
		return right;
	}

	public ValueElement setRight(Number right) {
		this.right = right;
		return this;
	}

	public Number getLeft() {
		return left;
	}

	public ValueElement setLeft(Number left) {
		this.left = left;
		return this;
	}

	public String getLabel() {
		return label;
	}

	public ValueElement setLabel(String label) {
		this.label = label;
		return this;
	}

	public Number getTop() {
		return top;
	}

	public ValueElement setTop(Number top) {
		this.top = top;
		return this;
	}

	public Number getX() {
		return x;
	}

	public ValueElement setX(Number x) {
		this.x = x;
		return this;
	}

	public Number getY() {
		return y;
	}

	public ValueElement setY(Number y) {
		this.y = y;
		return this;
	}

	public String getLabelColour() {
		return labelColour;
	}

	public ValueElement setLabelColour(String labelColour) {
		this.labelColour = labelColour;
		return this;
	}
}
