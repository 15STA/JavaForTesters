package JavaForTesters.Lesson8.Homework08;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricImperial {
    @JsonProperty(value = "Value")
    private float value;

    @JsonProperty(value = "Unit")
    private String unit;

    @JsonProperty(value = "UnitType")
    private float unitType;

    public MetricImperial() {
    }

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public float getUnitType() {
        return unitType;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUnitType(float unitType) {
        this.unitType = unitType;
    }
}
