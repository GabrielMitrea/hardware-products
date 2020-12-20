package store.Products.entities.products;

import store.Products.entities.reviews.ProcessorReview;
import store.Products.entities.types.ProductType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Processor {

    private long processorId;
    @NotNull(message = "Category cannot be null")
    private ProductType category;
    @NotNull(message = "Model name cannot be null")
    private String modelName;
    @NotNull(message = "Core cannot be null")
    private String core;
    @NotNull(message = "Frequency cannot be null")
    private String frequency;
    @NotNull(message = "Socket cannot be null")
    private String socket;
    @NotNull(message = "Series cannot be null")
    private String series;
    @NotNull(message = "Manufacturing technology cannot be null")
    private String manufacturingTechnology;
    @NotNull(message = "Price cannot be null")
    @Min(1)
    private Double price;
    private List<ProcessorReview> processorReview;

    public Processor(){}

    public Processor(long processorId, ProductType category, String modelName, String core, String frequency, String socket, String series, String manufacturingTechnology, Double price, List<ProcessorReview> processorReview) {
        this.processorId=processorId;
        this.category=category;
        this.modelName = modelName;
        this.core = core;
        this.frequency = frequency;
        this.socket = socket;
        this.series = series;
        this.manufacturingTechnology = manufacturingTechnology;
        this.price = price;
        this.processorReview=processorReview;
    }

    public long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(long processorId) {
        this.processorId = processorId;
    }

    public ProductType getCategory() {
        return category;
    }

    public void setCategory(ProductType category) {
        this.category = category;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getManufacturingTechnology() {
        return manufacturingTechnology;
    }

    public void setManufacturingTechnology(String manufacturingTechnology) {
        this.manufacturingTechnology = manufacturingTechnology;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProcessorReview> getProcessorReview() {
        return processorReview;
    }

    public void setProcessorReview(List<ProcessorReview> processorReview) {
        this.processorReview = processorReview;
    }
}
