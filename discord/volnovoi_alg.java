package discord;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class volnovoi_alg {
    public static class Player{
        int x, y, move;
        ArrayDeque<Cell> movement = new ArrayDeque<>();

        public Player(Maze maze) {
            this.x = maze.start[0];
            this.y = maze.start[1];
            this.move = 0;
        }

        public void start(Cell cell){
            if (cell.start) System.out.print("Старт в точке " + cell.x + "," + cell.y );
            movement.addLast(cell);
            move(cell);
        }

        public void move(Cell cell){
            if (cell == null) return;
            if (cell.finish){
                System.out.println(" и финиш в точке " + cell.x + "," + cell.y + " на " + cell.step + " шаге");
                return;
            }
            for (int i=0; i<4; i++) {
                if (cell.neighbours[i] != null){
                    if (!cell.neighbours[i].visited) {
                        if (cell.neighbours[i].step == 0)
                            cell.neighbours[i].step = cell.step +1;
                        cell.neighbours[i].visited = true;
                        movement.addLast(cell.neighbours[i]);
                    }
                }
            }

            this.move(movement.pollFirst());
        }

    }
    public static class Cell{
        int x, y, step, space;
        boolean visited, start, finish, homeRun;
        Cell[] neighbours = new Cell[4];

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.step = 0;
            this.visited = false;
            this.start = false;
            this.finish = false;
            this.homeRun = false;
        }

        public void setNeighbours(Maze maze){
            if (maze.cell[this.x+1][this.y].space > 0) this.neighbours[0] = maze.cell[this.x+1][this.y];
            if (maze.cell[this.x-1][this.y].space > 0) this.neighbours[1] = maze.cell[this.x-1][this.y];
            if (maze.cell[this.x][this.y+1].space > 0) this.neighbours[2] = maze.cell[this.x][this.y+1];
            if (maze.cell[this.x][this.y-1].space > 0) this.neighbours[3] = maze.cell[this.x][this.y-1];
        }
    }

    public static class Maze{
        int size;
        Cell[][] cell;
        ArrayList<Cell> path;
        int[] start = new int[2];
        int[] finish = new int[2];


        public Maze(int size) {
            this.size = size;
            this.cell = new Cell[size][size];
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++) {
                    this.cell[j][i] = new Cell(j, i);
//                    System.out.println("x - " + j + " y - " + i + " " + this.cell[j][i].x + " " + this.cell[j][i].y);
                    if (i == 0 || i == this.size - 1 || j == 0 || j == this.size - 1)
                        this.cell[j][i].space = 0;
                    else{
                        Random rnd = new Random();
                        this.cell[j][i].space = rnd.nextInt(2);
                    }
                }
            for (int i = 1; i < size - 2; i++)
                for (int j = 1; j < size - 2; j++) {
                    if (this.cell[i][j - 1].space == 1 && this.cell[i][j + 1].space == 1) this.cell[i][j].space = 1;
                }
            path = new ArrayList<>();
        }
        public void checkWave(int x, int y) {
            if (this.cell[x][y].space == 1) {
                this.cell[x][y].space = 2;
                checkWave(x - 1, y);
                checkWave(x, y - 1);
                checkWave(x + 1, y);
                checkWave(x, y + 1);
            }
        }

        public void wallBreaker() {
            int x, y;
            int[][] steps = {{-1, 0, 1, 2}, {1, 0, 2, 1}, {-1, 0, 2, 1}, {1, 0, 1, 2}, {0, -1, 1, 2}, {0, 1, 2, 1}, {0, -1, 2, 1}, {0, 1, 1, 2}};
            for (y = 1; y < this.size - 1; y++)
                for (x = 1; x < this.size - 1; x++)
                    if (this.cell[x][y].space == 0)
                        for (int[] step : steps)
                            if (this.cell[x + step[0]][y + step[1]].space == step[2] && this.cell[x - step[0]][y - step[1]].space == step[3]) {
                                this.cell[x][y].space = 1;
                                checkWave(x, y);
                            }
        }

        public int[] startWave() {
            int x, y;
            int[] coord = new int[2];
            for (x = 1; x < this.size - 1; x++)
                for (y = 1; y < this.size - 1; y++)
                    if (this.cell[x][y].space == 1) {
                        coord[0] = x;
                        coord[1] = y;
                        return coord;
                    }
            return coord;
        }

        public void fillBoard() {
            int x = startWave()[0];
            int y = startWave()[1];
            checkWave(x, y);
            wallBreaker();
            wallBreaker();
            setStart();
            setFinish();

        }

        public int randomQuarter(){
            Random rnd = new Random();
            int variable;
            boolean quarter = rnd.nextBoolean();
            if (quarter) variable = rnd.nextInt(1,this.size /4);
            else variable = rnd.nextInt((this.size /4)*3,this.size-2);
            return variable;
        }

        public void setStart(){
            while (true){
                int x = randomQuarter();
                int y = randomQuarter();
                if (this.cell[x][y].space == 2) {
                    this.cell[x][y].start = true;
                    this.start[0] = x;
                    this.start[1] = y;
                    break;
                }
            }
        }

        public void setFinish(){
            Random rnd = new Random();
            int[] limitX = new int[2];
            int[] limitY = new int[2];
            if (this.start[0] > this.size / 2){
                limitX[0] = 1;
                limitX[1] = this.size /4;
            }
            else{
                limitX[0] = (this.size /4)*3;
                limitX[1] = this.size-2;
            }
            if (this.start[1] > this.size / 2){
                limitY[0] = 1;
                limitY[1] = this.size /4;
            }
            else{
                limitY[0] = (this.size /4)*3;
                limitY[1] = this.size-2;
            }
            while (true) {
                int x = rnd.nextInt(limitX[0], limitX[1]);
                int y = rnd.nextInt(limitY[0], limitY[1]);
                if (this.cell[x][y].space == 2) {
                    this.cell[x][y].finish = true;
                    this.finish[0] = x;
                    this.finish[1] = y;
                    break;
                }
            }
        }

        public ArrayList<Cell> findWay(Cell cell){
            path.add(cell);
            if (cell.start) return path;
            for( int i=0; i<4; i++) {
                if (cell.neighbours[i] != null)
                    if (cell.neighbours[i].step == cell.step - 1) {
                        findWay(cell.neighbours[i]);
                        break;
                    }
            }
            return path;
        }

        public void print(){
            for (int i =0; i<this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (this.start[0] == j && this.start[1] == i) System.out.print(" S ");
                    else if (this.finish[0] == j && this.finish[1] == i) System.out.print(" F ");
                    else if (this.cell[j][i].homeRun) System.out.print(" * ");
                    else {
                        switch (this.cell[j][i].space) {
                            case (0) -> System.out.print("###");
                            case (1) -> System.out.print(" 0 ");
                            case (2) -> {
                                if (this.cell[j][i].step != 0)
                                    System.out.printf("   ", this.cell[j][i].step);
                                else System.out.print("   ");
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите размер квадратного лабиринта: ");
        int mazeSize = input.nextInt();
        Maze maze;
        while(true){
            maze = new Maze(mazeSize);
            maze.fillBoard();
            maze.print();
            System.out.print("Обновить лабиринт (y/n)? ");
            String answer = input.next();
            if (answer.equals("n")) break;
        }
        for (int i=1; i<maze.size - 1; i++)
            for (int j=1; j<maze.size - 1; j++)
                maze.cell[j][i].setNeighbours(maze);
        Player player = new Player(maze);
        player.start(maze.cell[maze.start[0]][maze.start[1]]);
        ArrayList<Cell> homeRun = maze.findWay(maze.cell[maze.finish[0]][maze.finish[1]]);
        for(int k = homeRun.size()-1; k >= 0 ; k--)
            homeRun.get(k).homeRun = true;
        maze.print();
    }
}