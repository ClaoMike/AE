package refactor.objects.maze;

import com.badlogic.gdx.utils.Array;

public class Maze {
    private int rows;
    private final Array<Array<Vertex>> vertices = new Array<>();

    public Maze(int cellsPerRow) {
        rows = cellsPerRow;
        for (int i = 0; i < rows; i++) {
            Array<Vertex> row = new Array<>();
            for (int j = 0; j< rows; j++) {
                Vertex v = new Vertex(i, j);
                row.add(v);
            }
            vertices.add(row);
        }

        createMaze();
    }

    void createMaze() {
        Vertex startVertex = vertices.get(0).get(0);
        randomizedDFS(startVertex);
    }

    void randomizedDFS(Vertex v) {
        v.visit();
        Vertex nextVertex = randomUnvisitedNeighbour(v);

        while(nextVertex != null) {
            connectCells(v, nextVertex);
            randomizedDFS(nextVertex);
            nextVertex = randomUnvisitedNeighbour(v);
        }
    }

    Vertex randomUnvisitedNeighbour(Vertex v) {
        Array<Vertex> neighbours = new Array<>();

        if(v.getJ()+1 >= 0 && v.getJ()+1 < rows) {
            if(vertices.get(v.getI()).get(v.getJ()+1)!= null) {
                Vertex neighbour = vertices.get(v.getI()).get(v.getJ()+1);

                if(!neighbour.isVisited()) {
                    neighbours.add(neighbour);
                }
            }
        }

        if(v.getJ()-1 >= 0 && v.getJ()-1 < rows) {
            if(vertices.get(v.getI()).get(v.getJ()-1)!= null) {
                Vertex neighbour = vertices.get(v.getI()).get(v.getJ()-1);

                if(!neighbour.isVisited()) {
                    neighbours.add(neighbour);
                }
            }
        }

        if(v.getI()+1 >= 0 && v.getI()+1 < rows) {
            if(vertices.get(v.getI()+1).get(v.getJ())!= null) {
                Vertex neighbour = vertices.get(v.getI()+1).get(v.getJ());

                if(!neighbour.isVisited()) {
                    neighbours.add(neighbour);
                }
            }
        }

        if(v.getI()-1 >= 0 && v.getI()-1 < rows) {
            if(vertices.get(v.getI()-1).get(v.getJ())!= null) {
                Vertex neighbour = vertices.get(v.getI()-1).get(v.getJ());

                if(!neighbour.isVisited()) {
                    neighbours.add(neighbour);
                }
            }
        }

        return neighbours.random();
    }

    void connectCells(Vertex v, Vertex nextVertex) {
        v.setNeighbour(nextVertex);
        nextVertex.setNeighbour(v);
    }

    public void printToConsole() {
        for(Array<Vertex> row : vertices) {
            for(Vertex v: row) {
                System.out.println("Vertex with i: " + v.getI() + ", j: " + v.getJ() + ", has the following neighbours:");
                for(Vertex neighbour: v.getNeighbours()) {
                    System.out.println("Vertex with i: " + neighbour.getI() + ", j: " + neighbour.getJ() + ";");
                }
            }
            System.out.println();
        }
    }

    public Array<Array<Vertex>> getVertices() {
        return vertices;
    }
}
