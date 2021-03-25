import java.util.ArrayList;
import java.util.List;

public class Area {

    String name;
    Area parent;
    List<Area> children;

    Area(String name, Area parent) {
        this.name = name;
        this.parent = parent;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    public List<Area> getChildren() {
        return children;
    }

    public void setChildren(List<Area> children) {
        this.children = children;
    }
}
