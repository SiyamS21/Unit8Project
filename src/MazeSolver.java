public class MazeSolver {
    private String[][] maze;
    private int currentRow;
    private int currentColumn;
    private String mostRecentMove;
    private String endMessage;

    public MazeSolver(String[][] m) {
        maze = m;
        currentRow = 0;
        currentColumn = 0;
        mostRecentMove = "";
        endMessage = "";
    }

    public void solvePath() {
        // just in case the maze is just a dot lol
        if (maze.length == 1 && maze[0].length == 1) {
            System.out.println("(0, 0)");
        }
        boolean up = true, down = true, left = true, right = true;

        // check which ways are available
        if (mostRecentMove.equals("up")) {
            down = false;
        } else if (mostRecentMove.equals("down")) {
            up = false;
        } else if (mostRecentMove.equals("left")) {
            right = false;
        } else if (mostRecentMove.equals("right")) {
            left = false;
        }

        if (currentRow == 0) {
            up = false;
        }
        if (currentRow == maze.length - 1) {
            down = false;
        }
        if (currentColumn == 0) {
            left = false;
        }
        if (currentColumn == maze[0].length - 1) {
            right = false;
        }

        // indicates whether the path has reached the end of the maze or not
        boolean solved = false;

        // solved will stay false if it has not reached the end and will change to true if it has which can be seen at the top of the overloaded method that is used during the recursion
        if (up && maze[currentRow - 1][currentColumn].equals(".")) {
            solved = solvePath(maze, currentRow - 1, currentColumn, "up", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
        if (!solved && down && maze[currentRow + 1][currentColumn].equals(".")) {
            solved = solvePath(maze, currentRow + 1, currentColumn, "down", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
        if (!solved && left && maze[currentRow][currentColumn - 1].equals(".")) {
            solved = solvePath(maze, currentRow, currentColumn - 1, "left", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
        if (!solved && right && maze[currentRow][currentColumn + 1].equals(".")) {
            solved = solvePath(maze, currentRow, currentColumn + 1, "right", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
    }

    // for the recursion part to use
    private boolean solvePath(String[][] maze, int currentRow, int currentColumn, String mostRecentMove, String endMessage) {
        if (currentRow == maze.length - 1 && currentColumn == maze[0].length - 1) {
            // reached the end of the maze
            endMessage += "(" + currentRow + ", " + currentColumn + ")";
            System.out.println(endMessage);
            return true;
        }

        boolean up = true, down = true, left = true, right = true;

        if (mostRecentMove.equals("up")) {
            down = false;
        } else if (mostRecentMove.equals("down")) {
            up = false;
        } else if (mostRecentMove.equals("left")) {
            right = false;
        } else if (mostRecentMove.equals("right")) {
            left = false;
        }

        if (currentRow == 0) {
            up = false;
        }
        if (currentRow == maze.length - 1) {
            down = false;
        }
        if (currentColumn == 0) {
            left = false;
        }
        if (currentColumn == maze[0].length - 1) {
            right = false;
        }

        boolean solved = false;

        if (up && maze[currentRow - 1][currentColumn].equals(".")) {
            solved = solvePath(maze, currentRow - 1, currentColumn, "up", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
        if (!solved && down && maze[currentRow + 1][currentColumn].equals(".")) {
            solved = solvePath(maze, currentRow + 1, currentColumn, "down", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
        if (!solved && left && maze[currentRow][currentColumn - 1].equals(".")) {
            solved = solvePath(maze, currentRow, currentColumn - 1, "left", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }
        if (!solved && right && maze[currentRow][currentColumn + 1].equals(".")) {
            solved = solvePath(maze, currentRow, currentColumn + 1, "right", endMessage + "(" + currentRow + ", " + currentColumn + ") ---> ");
        }

        return solved;
    }

    public void setMaze(String[][] m) {
        this.maze = m;
    }
}
