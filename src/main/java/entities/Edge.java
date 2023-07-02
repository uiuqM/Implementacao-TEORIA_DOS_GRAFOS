package entities;

public class Edge {
    private Vertex v;
    private Vertex u;
    
    public Edge (Vertex v, Vertex u){
        this.v = v;
        this.u = u;
    }

    public String getV(){
        return this.v.toString();
    }

    public String getU(){
        return this.u.toString();
    }

    public Vertex getVobj(){
        return this.v;
    }

    public Vertex getUobj(){
        return this.u;
    }

    public String getName(){
        return "(" + this.v + ", "+ this.u +")";
    }

    public String toString(){
        return "(" + this.v+", "+ this.u +")";
    }
}
