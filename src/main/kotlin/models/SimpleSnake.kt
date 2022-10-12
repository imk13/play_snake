package models

import Board
import java.util.*

class SimpleSnake(override val snakeBody: LinkedList<SnakeBodyNode>) : Snake() {
    private val stepsToIncreaseSnakeSize = 5;
    private var stepsCounter = 0;

    override fun move(direction: Direction) {
        val head  = snakeBody.first
        if(!validateSnakeMove(direction)) return
        stepsCounter++
        increaseSize()
        when(direction) {
            Direction.UP -> {
                val nextHead = SnakeBodyNode(Coordinates(head.coordinates.x - 1, head.coordinates.y), direction)
                snakeBody.addFirst(nextHead);
            }
            Direction.DOWN -> {
                val nextHead = SnakeBodyNode(Coordinates(head.coordinates.x + 1, head.coordinates.y), direction)
                snakeBody.addFirst(nextHead);
            }
            Direction.LEFT -> {
                val nextHead = SnakeBodyNode(Coordinates(head.coordinates.x, head.coordinates.y - 1), direction)
                snakeBody.addFirst(nextHead);
            }
            Direction.RIGHT -> {
                val nextHead = SnakeBodyNode(Coordinates(head.coordinates.x, head.coordinates.y + 1), direction)
                snakeBody.addFirst(nextHead);
            }
        }
    }

    private fun increaseSize() {
        if(stepsCounter == stepsToIncreaseSnakeSize){
            stepsCounter = 0;
        }else if(!snakeBody.isEmpty()){
            snakeBody.removeLast();
        }
    }

    override fun hasCollided(boundary: BoardBoundary): Boolean {
        val snakeList = LinkedList(snakeBody)
        val snakeHead = snakeBody.first.coordinates
        if(snakeHead.x <= boundary.topLeft.x || snakeHead.y <= boundary.topLeft.y || snakeHead.x >= boundary.bottomRight.x || snakeHead.y >= boundary.bottomRight.y) {
            return true
        }
        snakeList.poll()
        while (!snakeList.isEmpty()) {
            if(snakeHead.x == snakeList.first.coordinates.x && snakeList.first.coordinates.y == snakeHead.y) {
                return true
            }
            snakeList.poll()
        }
        return false
    }
}