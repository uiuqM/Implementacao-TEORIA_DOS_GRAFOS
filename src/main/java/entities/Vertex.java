package entities;

public class Vertex {
    private String name;

    public Vertex(){

    }
    public Vertex(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name;
    }
}
