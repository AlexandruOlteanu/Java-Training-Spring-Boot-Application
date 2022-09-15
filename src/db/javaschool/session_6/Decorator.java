package db.javaschool.session_6;

import java.util.ArrayList;
import java.util.List;

abstract class Tree {
    List<String> decorations = new ArrayList<>();
}
class ChristmasTree extends Tree {

}


abstract class DecorateTreeDecorator extends Tree {
    protected Tree tree;

    DecorateTreeDecorator(Tree tree) {
        this.tree = tree;
    }

    public abstract void decorate();

    public Tree tree() {
        return tree;
    }
}

class GlobeDecorateTreeDecorator extends DecorateTreeDecorator {
    GlobeDecorateTreeDecorator(Tree tree) {
        super(tree);
    }

    @Override
    public void decorate() {
        tree.decorations.add("globe");
    }

}
class StarDecorateTreeDecorator extends DecorateTreeDecorator {
    StarDecorateTreeDecorator(Tree tree) {
        super(tree);
    }

    @Override
    public void decorate() {
        tree.decorations.add("star");
    }
}

