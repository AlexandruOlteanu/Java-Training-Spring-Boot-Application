package db.javaschool.session_6;

class House {
    private boolean hasFoundation;
    private int numberOfStories = 0;
    private boolean hasRoof;

    public House(HouseBuilder houseBuilder) {
        this.hasFoundation = houseBuilder.hasFoundation;
        this.numberOfStories = houseBuilder.numberOfStories;
        this.hasRoof = houseBuilder.hasRoof;
    }

    @Override
    public String toString() {
        return "House{" +
                "hasFoundation=" + hasFoundation +
                ", numberOfStories=" + numberOfStories +
                ", hasRoof=" + hasRoof +
                '}';
    }

    static class HouseBuilder {
        private boolean hasFoundation = false;
        private int numberOfStories = 0;
        private boolean hasRoof = false;

        public HouseBuilder () { }

        public HouseBuilder hasFoundation(boolean hasFoundation) {
            this.hasFoundation = hasFoundation;
            return this;
        }

        public HouseBuilder numberOfStories(int numberOfStories) {
            this.numberOfStories = numberOfStories;
            return this;
        }

        public HouseBuilder hasRoof(boolean hasRoof) {
            this.hasRoof = hasRoof;
            return this;
        }

        public House build() {
            House house = new House(this);
            return house;
        }
    }
}
