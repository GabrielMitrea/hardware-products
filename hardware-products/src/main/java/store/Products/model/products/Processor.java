package store.Products.model.products;

import store.Products.model.ProductCategory;
import store.Products.model.reviews.ProcessorReview;

import java.util.List;

public class Processor {

    private long id;
    private ProductCategory catergory;
    private String modelName;
    private String core;
    private String frequency;
    private String socket;
    private String series;
    private String manufacturingTechnology;
    private Double price;
    private List<ProcessorReview> processorReview;

    public Processor(){}

    public Processor(long id,ProductCategory catergory, String modelName, String core, String frequency, String socket, String series, String manufacturingTechnology, Double price,List<ProcessorReview> processorReview) {
        this.id=id;
        this.catergory=catergory;
        this.modelName = modelName;
        this.core = core;
        this.frequency = frequency;
        this.socket = socket;
        this.series = series;
        this.manufacturingTechnology = manufacturingTechnology;
        this.price = price;
        this.processorReview=processorReview;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductCategory getCatergory() {
        return catergory;
    }

    public void setCatergory(ProductCategory catergory) {
        this.catergory = catergory;
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
