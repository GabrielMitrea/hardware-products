package store.Products.entities.products;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Processor {

    private int processorId;
    @NotNull(message = "Category cannot be null")
    private String categoryName;
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
    private int productId;



    public Processor(){}

    public Processor(int processorId,  String categoryName,  String core,  String frequency,  String socket,String series,  String manufacturingTechnology,int productId) {
        this.processorId = processorId;
        this.categoryName = categoryName;
        this.core = core;
        this.frequency = frequency;
        this.socket = socket;
        this.series = series;
        this.manufacturingTechnology = manufacturingTechnology;
        this.productId=productId;
    }

    public int getProcessorId() {
        return processorId;
    }

    public void setProcessorId(int processorId) {
        this.processorId = processorId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
