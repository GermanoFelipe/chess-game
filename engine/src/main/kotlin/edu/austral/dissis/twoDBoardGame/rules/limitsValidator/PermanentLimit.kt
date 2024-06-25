package edu.austral.dissis.twoDBoardGame.rules.limitsValidator

import edu.austral.dissis.twoDBoardGame.board.DefaultBoard
import edu.austral.dissis.twoDBoardGame.game.Movement
import edu.austral.dissis.twoDBoardGame.results.Invalid
import edu.austral.dissis.twoDBoardGame.results.RuleResult
import edu.austral.dissis.twoDBoardGame.results.Valid
import edu.austral.dissis.twoDBoardGame.rules.RuleManager
import java.lang.Math.abs

class PermanentLimit (
                      val exactLimit: Int
                      ): RuleManager {
  override fun checkMovement(board: DefaultBoard, movement: Movement): RuleResult {
    val absColumn = abs(movement.getFrom().column - movement.getTo().column)
    val absRow = abs(movement.getFrom().row - movement.getTo().row)

    return if (absRow == exactLimit || absColumn == exactLimit) {
      Valid()
    } else Invalid("Limit passed or not reached")
  }
}