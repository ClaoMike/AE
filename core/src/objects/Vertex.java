package objects;

import com.badlogic.gdx.utils.Array;

public class Vertex {
    boolean visited = false;
    int i, j;
    Array<Vertex> neighbours = new Array<>();

    public Vertex(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void visit() {
        visited = true;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setNeighbour(Vertex v) {
        neighbours.add(v);
    }

    public Array<Vertex> getNeighbours() {
        return neighbours;
    }
}
