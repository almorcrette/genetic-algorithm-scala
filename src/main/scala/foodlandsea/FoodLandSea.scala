package foodlandsea

import foodlandsea.FoodLandSeaOrganism.Instruction
import model.generics.*


case class Environ(
                                  above: Environ.Environment,
  toLeft: Environ.Environment,    onLocation: Environ.Environment,    toRight: Environ.Environment,
                                  below: Environ.Environment
                  ) extends SensoryInputs

object Environ {
  enum Environment:
    case Empty, Food, Impassable

  enum Direction:
    case Left, Right, Up, Down

  val allEnvirons: List[Environ] = ???
}




trait FoodLandSeaGenome extends Genome:
  val geneSequence: List[Environ] = Environ.allEnvirons

class FoodLandSeaOrganism(chromosomes: Map[Environ, Instruction]) extends FoodLandSeaGenome

object FoodLandSeaOrganism {
  enum Instruction:
    case Move(direction: Environ.Direction)
    case TryEat, DoNothing // TODO: Add Random
}




object FoodLandSea extends Simulation {

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
    def move(instruction: Instruction.Move): Position = instruction match
      case Instruction.Move(Environ.Direction.Left) => copy(col = col - 1)
      case Instruction.Move(Environ.Direction.Right) => copy(col = col + 1)
      case Instruction.Move(Environ.Direction.Up) => copy(col = row - 1)
      case Instruction.Move(Environ.Direction.Down) => copy(col = row + 1)


  case class Score(value: Int):
    def update(event: Event): Score = {
      import FoodLandSeaOrganism.Instruction
      import Environ.Environment

      event match
        case Event(Instruction.Move(_), Environment.Impassable) => copy(value = value - 10)
        case Event(Instruction.Move(_), _) => this
        case Event(Instruction.TryEat, Environment.Food) => copy(value = value + 5)
        case Event(Instruction.TryEat, _) => copy(value = value - 2)
        case Event(Instruction.DoNothing, _) => this
    }


  case class Event(
    instruction: FoodLandSeaOrganism.Instruction,
    environment: Environ.Environment
                  )

}

