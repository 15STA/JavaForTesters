package JavaForTesters.Lesson8.Homework08;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty(value = "Metric")
    private MetricImperial metric;

    @JsonProperty(value = "Imperial")
    private MetricImperial imperial;

    public MetricImperial getMetric() {
        return metric;
    }

    public MetricImperial getImperial() {
        return imperial;
    }

    public void setMetric(MetricImperial metric) {
        this.metric = metric;
    }

    public void setImperial(MetricImperial imperial) {
        this.imperial = imperial;
    }

    public Temperature() {
    }
}
