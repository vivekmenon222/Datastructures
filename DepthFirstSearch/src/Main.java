
public class Main {

    public static void main(String[] args) {
        FlightsGraph paths=new FlightsGraph();
        paths.addPath(new City("Boston"),new City("Paris"));
        paths.addPath(new City("Boston"),new City("Chicago"));
        paths.addPath(new City("Paris"),new City("Mumbai"));
        paths.addPath(new City("Mumbai"),new City("Beijing"));
        paths.addPath(new City("Mumbai"),new City("Delhi"));
        paths.addPath(new City("Delhi"),new City("Boston"));
        paths.depthFirstSearch(new City("Boston"));
    }
}
