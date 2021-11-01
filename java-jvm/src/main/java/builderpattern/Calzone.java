package builderpattern;

/**
 * @author zhangnan
 * @date 2021/10/28
 */
public class Calzone extends Pizza {

    private final boolean sauceInside;


    public Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }


    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; //default

        @Override
        public Pizza build() {
            return new Calzone(this);
        }

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }
    }

    public static void main(String[] args) {
        new MyPizza.Builder(MyPizza.Size.SMALL)
                .addTopping(Topping.SAUSAGE)
                .addTopping(Topping.ONION)
                .build();

        new Builder().addTopping(Topping.HAM)
                .sauceInside()
                .build();

    }

}
