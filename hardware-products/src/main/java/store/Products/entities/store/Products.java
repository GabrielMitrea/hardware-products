package store.Products.entities.store;

import store.Products.entities.products.*;

import java.util.List;

public class Products {
    private List<Mouse> Mice;
    private List<Keyboard> Keyboards;
    private List<Processor> Processors;
    private List<GraphicCard> graphicCards;
    private List<Headset> Headsets;
    private List<Laptop> Laptops;

    public Products(){}

    public Products(List<Mouse> Mice, List<Keyboard> Keyboards, List<Processor> Processors, List<GraphicCard> graphicCards, List<Headset> Headsets, List<Laptop> Laptops) {

        this.Mice = Mice;
        this.Keyboards = Keyboards;
        this.Processors = Processors;
        this.graphicCards = graphicCards;
        this.Headsets = Headsets;
        this.Laptops=Laptops;
    }



    public List<Mouse> getMice() {
        return Mice;
    }

    public void setMice(List<Mouse> Mice) {
        this.Mice = Mice;
    }

    public List<Keyboard> getKeyboards() {
        return Keyboards;
    }

    public void setKeyboards(List<Keyboard> Keyboards) {
        this.Keyboards = Keyboards;
    }

    public List<Processor> getProcessors() {
        return Processors;
    }

    public void setProcessors(List<Processor> Processors) {
        this.Processors = Processors;
    }

    public List<GraphicCard> getgraphicCards() {
        return graphicCards;
    }

    public void setgraphicCards(List<GraphicCard> graphicCards) {
        this.graphicCards = graphicCards;
    }

    public List<Headset> getHeadsets() {
        return Headsets;
    }

    public void setHeadsets(List<Headset> Headsets) {
        this.Headsets = Headsets;
    }

    public List<Laptop> getLaptops() {
        return Laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        Laptops = laptops;
    }
}
