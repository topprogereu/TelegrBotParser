package model;

import java.util.List;
import java.util.Map;

// Класс для получения результата от АПИ Авториа в JSON с помощью jackson ObjectMapper
public class AutoriaApiAverageCoast {

    private String total;
    private double arithmeticMean;
    private double interQuartileMean;
    private Map<String,Float> percentiles;// = new ArrayList<>() ;
    private List<Float> prices;// = new ArrayList<>();
    private List<Integer> classifieds;// = new ArrayList<>();

    public void setTotal(String total) {
        this.total = total;
    }

    public void setArithmeticMean(double arithmeticMean) {
        this.arithmeticMean = arithmeticMean;
    }

    public void setInterQuartileMean(double interQuartileMean) {
        this.interQuartileMean = interQuartileMean;
    }

    public void setPercentiles(Map<String, Float> percentiles) {
        this.percentiles = percentiles;
    }

    public void setPrices(List<Float> prices) {
        this.prices = prices;
    }

    public void setClassifieds(List<Integer> classifieds) {
        this.classifieds = classifieds;
    }

    public String getTotal() {
        return total;
    }

    public double getArithmeticMean() {
        return arithmeticMean;
    }

    public double getInterQuartileMean() {
        return interQuartileMean;
    }

    public Map<String, Float> getPercentiles() {
        return percentiles;
    }

    public List<Float> getPrices() {
        return prices;
    }

    public List<Integer> getClassifieds() {
        return classifieds;
    }
}
