// B"H
package shmulik.coupons_manager.final_project.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//
//        FOOD,
//        HEALTH,
//        BABY,
//        ENTERTAINMENT,
//        SPORTS,

@Converter(autoApply = true)
public class CouponTypeConvertor implements AttributeConverter<CouponCategory , String > {

    @Override
    public String convertToDatabaseColumn(CouponCategory method) {
        switch(method){
            case FOOD:
                return "FOOD";
            case HEALTH:
                return "HEALTH";
            case BABY:
                return "BABY";
            case SPORTS:
                return "SPORTS";
            default:
                throw new IllegalArgumentException("Unknown method: " + method);
        }
    }

    @Override
    public CouponCategory convertToEntityAttribute(String dbData) {
        switch(dbData){
            case "FOOD":
                return CouponCategory.FOOD;
            case "HEALTH":
                return CouponCategory.HEALTH;
            case "BABY":
                return CouponCategory.BABY;
            case "SPORTS":
                return CouponCategory.SPORTS;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }
}

