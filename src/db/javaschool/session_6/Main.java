

package db.javaschool.session_6;

public class Main {
    public static void main(String[] args) {
        SingletonExample singleton = SingletonExample.getInstance();
        SingletonExample singleton2 = SingletonExample.getInstance();

        System.out.println(singleton);
        System.out.println(singleton2);

        Factory factory = new Factory();

        System.out.println(factory.createGeometricObject(GeometricObjectType.SQUARE));
        System.out.println(factory.createGeometricObject(GeometricObjectType.RECTANGLE));

        House house = new House.HouseBuilder()
                .hasFoundation(true) // hasFoundation = true;
                .numberOfStories(3)
                .hasRoof(true)
                .build();

//        House.HouseBuilder builder = new House.HouseBuilder();
//        builder.hasFoundation(true);
//        builder.hasSecondStore(true);

        System.out.println(house);

        ChristmasTree tree = new ChristmasTree();
        GlobeDecorateTreeDecorator globeTree = new GlobeDecorateTreeDecorator(tree);
        StarDecorateTreeDecorator starTree = new StarDecorateTreeDecorator(tree);

        globeTree.decorate();
        starTree.decorate();
        globeTree.decorate();

        System.out.println(tree.decorations);

        Subject subject = new Subject();

        Observer o1 = new Observer(subject);
        Observer o2 = new Observer(subject);
        Observer o3 = new Observer(subject);

        subject.setState(6);
        subject.setState(0);

        Dog dog = new Dog();
        Command command1 = new CommandBring();
        Command command2 = new CommandStay();

        command1.execute(dog);
        command2.execute(dog);

    }
}
