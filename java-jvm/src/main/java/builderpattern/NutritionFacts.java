package builderpattern;

/**
 * @author zhangnan
 * @date 2021/10/28
 */
public class NutritionFacts {

    private final int serviceSize;

    private final int services;

    // optional
    private final int calories;


    // 建造者模式
    public static class Builder {

        // required parameters
        private final int serviceSize;

        private final int services;

        // optional
        private int calories = 0;

        public Builder(int serviceSize, int services) {
            this.serviceSize = serviceSize;
            this.services = services;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        services = builder.services;
        serviceSize = builder.serviceSize;
        calories = builder.calories;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(10, 20)
                .calories(0)
                .build();
    }

}
