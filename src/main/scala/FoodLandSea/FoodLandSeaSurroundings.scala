package FoodLandSea

import model.generics.*

case class FoodLandSeaSurroundings(
                                    above: FoodLandSeaSurroundings.Environment,
                                    toLeft: FoodLandSeaSurroundings.Environment, onLocation: FoodLandSeaSurroundings.Environment, toRight: FoodLandSeaSurroundings.Environment,
                                    below: FoodLandSeaSurroundings.Environment
                  ) extends SensoryInputs

object FoodLandSeaSurroundings {
  enum Environment:
    case Empty, Food, Impassable

  enum Direction:
    case Left, Right, Up, Down

  val allEnvirons: List[FoodLandSeaSurroundings] = ???
}