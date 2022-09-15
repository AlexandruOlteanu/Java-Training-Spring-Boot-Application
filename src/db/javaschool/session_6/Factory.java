package db.javaschool.session_6;

class GeometricObject {
}

class Circle extends GeometricObject {
}

class Square extends GeometricObject {
}

class Rectangle extends GeometricObject {
}

enum GeometricObjectType {
    CIRCLE, SQUARE, RECTANGLE
}

class Factory {
    public GeometricObject createGeometricObject(GeometricObjectType type) {
        return switch (type) {
            case CIRCLE -> new Circle();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
            default -> null;
        };
    }
}