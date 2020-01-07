package model;

public class ExchangeRate {

    private String ccy;
    private String base_ccy;
    private float buy;
    private float sale;

    public ExchangeRate(){
    }

    public ExchangeRate(String ccy, String base_ccy, float buy,float sale)
    {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public float getBuy() {
        return buy;
    }

    public float getSale() {
        return sale;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public String getCcy() {
        return ccy;
    }

    @Override
    public String toString() {
        return base_ccy+" к "+ccy+"\nПокупка: "+buy+"\nПродажа: "+sale;
    }
}


