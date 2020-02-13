package my.sdr.redisex.dto;

import java.io.Serializable;

public class InvoicePoint implements Serializable {

    public InvoicePoint() {
    }

    private String invoiceNumber;
    private Double lat;
    private Double lon;
    private String addr;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "InvoicePoint{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", addr='" + addr + '\'' +
                '}';
    }
}
