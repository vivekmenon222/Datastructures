import java.lang.invoke.ConstantCallSite;

/**
 * Created by Home on 6/5/2016.
 */
public class City {

    private String name;
    private boolean visited;

    public City(String name) {
        this.name = name.toLowerCase();
    }


    public String getName() {
        return name;
    }

    public void visit()
    {
        this.visited=true;
        System.out.println(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();

    }

    @Override
    public boolean equals(Object obj) {
        boolean returnVal=false;
        if (obj == null || !(obj instanceof City)) {
            returnVal = false;
        } else if (((City) obj).name.equals(this.name)) {
            returnVal = true;
        }

        return returnVal;
    }


    public boolean isVisited() {
        return visited;
    }
}
