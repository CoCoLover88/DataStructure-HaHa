package com.company.recursion;

public class maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][7];
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("迷宫走路");
        getWay(maze, 1, 1);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean getWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            /*策略：下-》右-》上-》左*/
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                if (getWay(maze, i + 1, j)) {
                    return true;
                } else if (getWay(maze, i, j + 1)) {
                    return true;
                } else if (getWay(maze, i - 1, j)) {
                    return true;
                } else if (getWay(maze, i, j - 1)) {
                    return true;
                } else {
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
