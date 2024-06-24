package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.chessTurn.TurnDefault
import edu.austral.dissis.chess.engine.rules.winCondition.IsCheckMate
import edu.austral.dissis.chess.engine.rules.winCondition.IsNotInCheck
import edu.austral.dissis.twoDBoardGame.game.Game
import edu.austral.dissis.twoDBoardGame.game.Movement
import edu.austral.dissis.twoDBoardGame.game.mover.DefaultMovApplier
import edu.austral.dissis.twoDBoardGame.piece.Color
import edu.austral.dissis.twoDBoardGame.piece.Piece
import edu.austral.dissis.twoDBoardGame.rules.RuleManager
import edu.austral.dissis.twoDBoardGame.rules.boardRulesValidator.PieceExistsValidator
import edu.austral.dissis.twoDBoardGame.rules.boardRulesValidator.SameTeamValidator
import edu.austral.dissis.twoDBoardGame.rules.boardRulesValidator.TurnValidator

object DefualtChessGame{
  operator fun invoke(): Game{
    return Game(
      board = createDefaultBoard(),
      turn = TurnDefault(Color.WHITE),
      rules = createNormalRules(),
      history = mapOf<Piece?, List<Movement>>(),
      winningCondition = IsCheckMate(),
      movementApplier = DefaultMovApplier()
    )

  }
}


fun createDefaultChess (): Game {
  return Game(
    board = createDefaultBoard(),
    turn = TurnDefault(Color.WHITE),
    rules = createNormalRules(),
    history = mapOf<Piece?, List<Movement>>(),
    winningCondition = IsCheckMate(),
    movementApplier = DefaultMovApplier()
  )
}

fun createNormalRules(): List<RuleManager>{
  return listOf(
    PieceExistsValidator(),
    TurnValidator(),
    SameTeamValidator(),
    IsNotInCheck()
  )
}