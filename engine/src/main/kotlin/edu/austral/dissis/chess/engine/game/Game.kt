package edu.austral.dissis.chess.engine.game

import edu.austral.dissis.chess.engine.board.DefaultBoard
import edu.austral.dissis.chess.engine.game.results.*
import edu.austral.dissis.chess.engine.piece.Position
import edu.austral.dissis.chess.engine.movement.Movement
import edu.austral.dissis.chess.engine.piece.Piece
import edu.austral.dissis.chess.engine.rules.ChessRuleManager


class Game (
  val board: DefaultBoard,
  val turn: TurnManager,
  val history: Map<Piece, List<Movement>>,
  val ruleManager: ChessRuleManager
  ) {


  fun movePiece(from: Position, to: Position): MovementResult {
    val piece = board.getPiece(from) ?: return InvalidMovement()

    val movement = Movement(from, to, board, piece)

    when (ruleManager.checkMovement(this, movement)) {
      is Valid -> {
        val newBoard = board.movePiece(from, to)

        val newHistory = history.toMutableMap()
        newHistory[piece] = newHistory[piece]?: listOf()
        val updateMovements = newHistory[piece]!! + movement
        newHistory[piece] = updateMovements

        val changeTurn = turn.nextTurn()

        return Valid(Game(newBoard, changeTurn, newHistory, ruleManager))
      }

      is InvalidMovement -> {
        return InvalidMovement()
      }
    }
  }

}