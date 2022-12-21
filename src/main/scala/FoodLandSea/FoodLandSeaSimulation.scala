package FoodLandSea

import FoodLandSea.FoodLandSeaGenome
import model.generics.*

object FoodLandSeaSimulation extends Simulation {

  import FoodLandSeaOrganism.Instruction
  import FoodLandSeaSurroundings.{Environment, Direction}

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
      case Instruction.Move(FoodLandSeaSurroundings.Direction.Left) => copy(col = col - 1)
      case Instruction.Move(FoodLandSeaSurroundings.Direction.Right) => copy(col = col + 1)
      case Instruction.Move(FoodLandSeaSurroundings.Direction.Up) => copy(col = row - 1)
      case Instruction.Move(FoodLandSeaSurroundings.Direction.Down) => copy(col = row + 1)


  case class Score(value: Int):
    def update(event: Event): Score = event match
      case Event(Instruction.Move(_), Environment.Impassable) => copy(value = value - 10)
      case Event(Instruction.Move(_), _) => this
      case Event(Instruction.TryEat, Environment.Food) => copy(value = value + 5)
      case Event(Instruction.TryEat, _) => copy(value = value - 2)
      case Event(Instruction.DoNothing, _) => this


  case class Event(
    instruction: FoodLandSeaOrganism.Instruction,
    environment: FoodLandSeaSurroundings.Environment
                  )

}

