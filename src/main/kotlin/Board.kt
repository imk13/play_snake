import models.*
import java.util.*

class Board {
    private var snake: SimpleSnake
    private var boundary: BoardBoundary = BoardBoundary(Coordinates(0, 0), Coordinates(100, 100))

    init {
        val snakeList = LinkedList<SnakeBodyNode>()
        snakeList.add(SnakeBodyNode(Coordinates(50, 52), Direction.RIGHT))
        snakeList.add(SnakeBodyNode(Coordinates(50, 51), Direction.RIGHT))
        snakeList.add(SnakeBodyNode(Coordinates(50, 50), Direction.RIGHT))
        snake = SimpleSnake(snakeList)
    }

    public fun startGame() {
        while (true) {
            // take direction input from user
            val direction = Direction.RIGHT;
            snake.move(direction)
            if (snake.hasCollided(boundary)) {
                println("Game Over!")
                println("Your score ${snake.snakeBody.size}")
                return
            }
        }
    }
}