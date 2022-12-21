package FoodLandSea

import model.generics.*

case class FoodLandSeaEnvironment(
                                   toTheNorth: FoodLandSeaEnvironment.AtLocation,
                                   ToTheWest: FoodLandSeaEnvironment.AtLocation,
                                   here: FoodLandSeaEnvironment.AtLocation,
                                   toTheEast: FoodLandSeaEnvironment.AtLocation,
                                   toTheSouth: FoodLandSeaEnvironment.AtLocation
                  ) extends SensoryInputs

object FoodLandSeaEnvironment {
  enum AtLocation:
    case Empty, Food, Impassable

  enum Direction:
    case East, West, North, South

  val allEnvirons: List[FoodLandSeaEnvironment] = ???
}