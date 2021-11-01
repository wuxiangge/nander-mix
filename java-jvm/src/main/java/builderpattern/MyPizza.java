package builderpattern;

import java.util.Objects;

/**
 * @author zhangnan
 * @date 2021/10/28
 */
public class MyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;


    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }


        @Override
        public MyPizza build() {
            return new MyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }


    public MyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
