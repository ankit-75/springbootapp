package com.example.functionCodeQuality;

import java.util.Date;
import java.util.Map;

public interface History {
    public void applyRecalculation(Double highestTariff, double unitRate) ;
    public Map<Date, Double> getAllFees(Tariff tariff, Service service) ;
}
