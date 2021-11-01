package telescopingconstrutor;

/**
 * @author zhangnan
 * @date 2021/10/28
 */
public class NutritionFacts {

    private final int serviceSize;

    private final int services;

    public NutritionFacts(int serviceSize) {
        this(serviceSize, 0);
    }

    public NutritionFacts(int serviceSize, int services) {
        this.serviceSize = serviceSize;
        this.services = services;
    }


}
