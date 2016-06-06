import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Home on 6/5/2016.
 */
public class FlightsGraph {

    Map<City, List<City>> adjacencyList;

    public FlightsGraph() {
        adjacencyList = new HashMap<City, List<City>>();
    }

    public void addPath(City originCity, City destCity) {
        List<City> destinations;
        if (adjacencyList.get(originCity) == null) {
            destinations = new ArrayList<City>();
        } else {
            destinations = adjacencyList.get(originCity);
        }
        destinations.add(destCity);
        adjacencyList.put(originCity, destinations);
    }

    public void depthFirstSearch(City originCity) {
        originCity.visit();
        List<City> destinations = adjacencyList.get(originCity);
        if(destinations!=null)
        {
            for (City destination : destinations) {
                if (!(destination.isVisited())) {
                    depthFirstSearch(destination);

                }
            }
        }



    }
}
