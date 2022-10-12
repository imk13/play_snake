package models

import java.util.LinkedList


abstract class Snake {
    public abstract val snakeBody: LinkedList<SnakeBodyNode>
    public abstract fun move(direction : Direction)
    public abstract fun hasCollided(boundary: BoardBoundary): Boolean

    public fun validateSnakeMove(direction: Direction) : Boolean {
        val head  = snakeBody.first
        when(direction) {
            Direction.UP -> {
                if (head.direction == Direction.DOWN) {
                    println("Invalid Move $direction");
                    return false
                }
            }
            Direction.DOWN -> {
                if (head.direction == Direction.UP) {
                    println("Invalid Move $direction");
                    return false
                }
            }
            Direction.LEFT -> {
                if (head.direction == Direction.RIGHT) {
                    println("Invalid Move $direction");
                    return false
                }
            }
            Direction.RIGHT -> {
                if (head.direction == Direction.LEFT) {
                    println("Invalid Move $direction");
                    return false
                }
            }
        }
        return true
    }
}

