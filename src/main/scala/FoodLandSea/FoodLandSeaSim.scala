package FoodLandSea

import FoodLandSea.FoodLandSeaGenome
import model.generics.*

object FoodLandSeaSimulation extends Simulation {

  import FoodLandSeaOrganism.Instruction
  import FoodLandSeaEnvironment.{AtLocation, Direction}

  def runTrial(organism: FoodLandSeaOrganism): TrialOutcome = ???

  def startingStateOfTheWorld(): StateOfTheWorld = ???

  def completeYear(startingState: StateOfTheWorld): StateOfTheWorld = ???

  case class StateOfTheWorld(
    landscape: Landscape,
    organismStatus: OrganismStatus
                            )

  case class Landscape(grid: Grid, foodLocation: List[Food])

  case class OrganismStatus(position: Position, score: Score, turns: Int)

  case class Grid(height: Int, width: Int)

  case class Food(location: (Int, Int))(implicit grid: Grid)

  case class Position(row: Int, col: Int):
    def move(instruction: FoodLandSeaOrganism.Instruction.Move): Position = instruction match
      case Instruction.Move(FoodLandSeaEnvironment.Direction.West) => copy(col = col - 1)
      case Instruction.Move(FoodLandSeaEnvironment.Direction.East) => copy(col = col + 1)
      case Instruction.Move(FoodLandSeaEnvironment.Direction.North) => copy(col = row - 1)
      case Instruction.Move(FoodLandSeaEnvironment.Direction.South) => copy(col = row + 1)


  case class Score(value: Int):
    def update(event: Event): Score = event match
      case Event(Instruction.Move(_), AtLocation.Impassable) => copy(value = value - 10)
      case Event(Instruction.Move(_), _) => this
      case Event(Instruction.TryEat, AtLocation.Food) => copy(value = value + 5)
      case Event(Instruction.TryEat, _) => copy(value = value - 2)
      case Event(Instruction.DoNothing, _) => this


  case class Event(
    instruction: FoodLandSeaOrganism.Instruction,
    environment: FoodLandSeaEnvironment.AtLocation
                  )

}

