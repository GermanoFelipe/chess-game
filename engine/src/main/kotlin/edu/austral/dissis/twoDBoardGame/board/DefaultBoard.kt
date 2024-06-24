package edu.austral.dissis.twoDBoardGame.board

import edu.austral.dissis.twoDBoardGame.piece.Piece
import edu.austral.dissis.twoDBoardGame.position.Position

class DefaultBoard (
  private val row: Int,
  private val column: Int,
  //val size: Position,
  private val pieces: Map<Position, Piece>
  ) : Board {

  override fun getPieces(): Map<Position, Piece> {
    return pieces
  }


  override fun movePiece(from: Position, to: Position): DefaultBoard {
    val piece = pieces[from] ?: throw IllegalArgumentException("No piece at $from")
    val newPieces = pieces - from + Pair(to, piece.copy(hasMoved = true))
    return DefaultBoard(8,8, newPieces)
  }

  override fun positionExists(position: Position): Boolean {
    return pieces.containsKey(position)
  }

  override fun getPiece (position: Position): Piece? {
    return pieces[position]
  }

  override fun getUsedPositions(): List<Position> {
    return pieces.keys.toList()
  }

  override fun removePiece(from: Position): DefaultBoard {
    return DefaultBoard(8,8, pieces - from)
  }

  override fun getRow(): Int {
    return row
  }

  override fun getColumn(): Int {
    return column
  }
}