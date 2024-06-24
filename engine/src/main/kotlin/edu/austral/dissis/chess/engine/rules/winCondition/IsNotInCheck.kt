package edu.austral.dissis.chess.engine.rules.winCondition

import edu.austral.dissis.twoDBoardGame.game.Game
import edu.austral.dissis.twoDBoardGame.game.Movement
import edu.austral.dissis.twoDBoardGame.results.Invalid
import edu.austral.dissis.twoDBoardGame.results.RuleResult
import edu.austral.dissis.twoDBoardGame.results.Valid
import edu.austral.dissis.twoDBoardGame.rules.RuleManager

class IsNotInCheck : RuleManager {
  val check = Check()

  override fun checkMovement(game: Game, movement: Movement): RuleResult {
    val boardMoved = game.getBoard().movePiece(movement.getFrom(), movement.getTo())

    if (check.inCheck(game, boardMoved, movement.getTurn() )){
      return Invalid("You cant leave in Check")
    }
    return Valid()
  }
}